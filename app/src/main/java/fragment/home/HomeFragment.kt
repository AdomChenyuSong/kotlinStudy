package fragment.home

import adapters.BaseListAdapter
import android.view.View
import android.view.ViewGroup
import base.BaseListDataBean
import base.BaseObserver
import bean.HomeBannerBean
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.e.kotlinwanandroid.R
import com.youth.banner.Banner
import com.youth.banner.BannerConfig
import conn.RxClient
import imageloader.GlideImageLoader
import list.BaseListFragment
import list.BaseProvider
import list.DefaultListProvider
import untils.IntentUntils

class HomeFragment: BaseListFragment<BaseListDataBean>() {
    private var mBanner: Banner? = null
    override fun createAdapter(): BaseQuickAdapter<BaseListDataBean, BaseViewHolder> {
        var defaultListProvider = getProvider() as DefaultListProvider<BaseListDataBean>
        val homeArticleAdapter=BaseListAdapter(context,defaultListProvider.data)
        return homeArticleAdapter
    }

    override fun createSubscriber(): BaseProvider<BaseListDataBean> {
        val homeListProvider=HomeListProvider() as BaseProvider<BaseListDataBean>
        return homeListProvider
    }

    override fun initHeadView() {
        val view= layoutInflater.inflate(R.layout.frame_banner, getRecycleView().getParent() as ViewGroup, false) as View
        mBanner = view!!.findViewById(R.id.banner)
        mBanner!!.setImageLoader(GlideImageLoader())
        mBanner!!.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE)
        mBanner!!.setDelayTime(3000)
        //设置是否自动轮播
        mBanner!!.isAutoPlay(true)
        getAdapter().addHeaderView(view)
    }

    override fun initHeaderData() {
        RxClient.getBannerList()!!.subscribe(observer)
    }
    val observer:BaseObserver<List<HomeBannerBean>> = object : BaseObserver<List<HomeBannerBean>>() {
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
        mBanner!!.setOnBannerListener {position ->
           IntentUntils.startToWebview(context,dataBean[position].url!!,titles[position])
        }
        mBanner!!.start()
    }
}