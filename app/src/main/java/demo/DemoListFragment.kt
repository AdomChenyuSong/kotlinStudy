package demo

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.content.ContextCompat
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import base.BaseObserver
import bean.HomeBannerBean
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.e.kotlinwanandroid.R
import com.youth.banner.Banner
import com.youth.banner.BannerConfig
import conn.RxClient
import imageloader.GlideImageLoader
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import list.BaseListFragment
import list.BaseProvider
import list.DefaultListProvider
import java.util.*

class DemoListFragment :BaseListFragment<HomeBannerBean>(){
    private var mBanner: Banner? = null
    override fun createAdapter(): BaseQuickAdapter<HomeBannerBean, BaseViewHolder> {
        val provider = getProvider() as DefaultListProvider<HomeBannerBean>
        val adapter=MyAdapter(R.layout.item_demo,provider.data)
        return adapter
    }

    override fun createSubscriber(): BaseProvider<HomeBannerBean> {
        val demoProvider=DefaultDemo() as BaseProvider<HomeBannerBean>
        return demoProvider
    }


    inner class MyAdapter(@LayoutRes layoutResId: Int, data: ArrayList<HomeBannerBean>) : BaseQuickAdapter<HomeBannerBean, BaseViewHolder>(
        R.layout.item_demo, data) {

        override fun convert(helper: BaseViewHolder, item: HomeBannerBean) {
            helper.setText(com.e.kotlinwanandroid.R.id.tv_demo1, item.title)
            helper.setImageResource(com.e.kotlinwanandroid.R.id.img_demo1,R.mipmap.bottom_menu_mine)
        }
    }

    override fun initHeadView() {
        var view=layoutInflater.inflate(R.layout.frame_banner, getRecycleView().getParent() as ViewGroup, false) as View
        mBanner = view!!.findViewById(R.id.banner)
        mBanner!!.setImageLoader(GlideImageLoader())
        mBanner!!.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE)
        mBanner!!.setDelayTime(5000)
        //设置是否自动轮播
        mBanner!!.isAutoPlay(true)
        getAdapter().addHeaderView(view)
    }

    override fun initHeaderData() {
        RxClient.getBannerList()!!.subscribe(observer)
    }
    val observer: BaseObserver<List<HomeBannerBean>> = object : BaseObserver<List<HomeBannerBean>>() {
        override fun onStart() {
            super.onStart()
        }

        override fun onComplete() {
            super.onComplete()
        }

        override fun onNext(value: List<HomeBannerBean>) {
            super.onNext(value)
            fillBanner(value)
        }

        override fun onError(e: Throwable?) {
            super.onError(e)
        }

    }
    fun fillBanner(dataBean:List<HomeBannerBean>) {
        var images= ArrayList<String>()
        var titles =ArrayList<String>()
        for (datum in dataBean){
            images.add(datum.imagePath!!)
            titles.add(datum.title!!)
        }
        mBanner!!.setImages(images)
        mBanner!!.setBannerTitles(titles)
        mBanner!!.start()
    }
}