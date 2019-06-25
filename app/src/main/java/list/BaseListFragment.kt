package list

import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Toast
import base.BaseFragment
import base.BaseObserver
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.e.kotlinwanandroid.R

abstract class BaseListFragment<T>:BaseFragment(),SwipeRefreshLayout.OnRefreshListener{
   private lateinit var recycleView: RecyclerView
   private lateinit var privider:BaseProvider<T>
   private lateinit var adapter:BaseQuickAdapter<T, BaseViewHolder>
   private lateinit var refresh_layout:SwipeRefreshLayout
    override fun getLayoutId(): Int {
      return R.layout.fragment_baselist
    }
    fun getProvider():BaseProvider<T>{
        if (!::privider.isInitialized){
            privider=createSubscriber()
            privider!!.observer=baseSubscribe
        }
        return privider
    }
    fun getAdapter():BaseQuickAdapter<T, BaseViewHolder>{
        if (!::adapter.isInitialized){
            adapter=createAdapter()
        }
        return adapter
    }

    var baseSubscribe:BaseObserver<T> = object : BaseObserver<T>() {
        override fun onStart() {
            super.onStart()
            refresh_layout!!.isRefreshing=true
        }

        override fun onComplete() {
            super.onComplete()
            refresh_layout!!.isRefreshing=false
        }

        override fun onNext(value: T) {
            super.onNext(value)
            getAdapter().notifyDataSetChanged()
        }

        override fun onError(e: Throwable?) {
            super.onError(e)
            Toast.makeText(context,e!!.message,Toast.LENGTH_LONG).show()
        }

              }
    override fun initData(bundle: Bundle?) {
        var manager=LinearLayoutManager(context)
        manager.orientation=LinearLayoutManager.VERTICAL
        recycleView.layoutManager=manager;
        recycleView.adapter=getAdapter()
        initHeadView()
        initHeaderData()
        getProvider().bindRecyclerView(recycleView)
        getProvider().loadNext(true)

    }

    override fun initView(views: View) {
        recycleView=views.findViewById(R.id.list_layout)
        refresh_layout=views.findViewById(R.id.refresh_layout)
        refresh_layout!!.setOnRefreshListener(this)
    }

    abstract fun createAdapter(): BaseQuickAdapter<T, BaseViewHolder>
    abstract fun createSubscriber():BaseProvider<T>

    override fun onRefresh() {
        getProvider().refresh()
    }

    /**
     * 新增RecyclerView addHeader
     */
    open fun initHeadView() {

    }

    open fun initHeaderData() {

    }


    fun getRecycleView():RecyclerView{
       return recycleView
    }
}