package conn

import android.util.Log
import bean.BaseDataBean
import bean.BaseListPlusBean
import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.ObservableTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetfitMain{
     var okhttoClient:OkHttpClient?=null
     var mRetfit: Retrofit?=null

    companion object {
        const val DATA_URL:String="https://www.wanandroid.com/"
        var retfitMain:RetfitMain?=null
        fun getInstance():RetfitMain?{
            if (retfitMain==null){
                retfitMain=RetfitMain()
            }
            return retfitMain
        }
    }
    class SchedulerTransFormer<T>:ObservableTransformer<T,T>{
        override fun apply(upstream: Observable<T>?): ObservableSource<T> {
            return upstream!!.subscribeOn(Schedulers.io()).unsubscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
        }

    }

    class ListDataTransFormer<T>:ObservableTransformer<T,List<T>>{
        override fun apply(upstream: Observable<T>?): ObservableSource<List<T>> {
            return upstream!!.flatMap{ t ->
                var list:List<T>?=null
                if (t is BaseDataBean<*>){
                    list=(t as BaseDataBean<*>).data as List<T>
                }else if (t is BaseListPlusBean<*>){
                    list=(t as BaseListPlusBean<*>).data!!.datas as List<T>
                }
                Observable.just(list!!)
            }
        }
    }

    constructor(){
        init()
    }

    fun init(){
        if (okhttoClient==null){
            okhttoClient=OkHttpClient().newBuilder()
                .addInterceptor(HttpLoggingInterceptor())
                .connectTimeout(10,TimeUnit.SECONDS)
                .writeTimeout(10,TimeUnit.SECONDS)
                .readTimeout(10,TimeUnit.SECONDS)
                .build()
        }
        if (mRetfit==null){
            mRetfit=Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okhttoClient)
                .baseUrl(DATA_URL)
                .build()
        }
    }
   fun <T> createClass(mClass:Class<T>):T{
       return mRetfit!!.create(mClass)
   }




}
