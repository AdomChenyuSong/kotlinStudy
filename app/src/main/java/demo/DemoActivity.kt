package demo

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import base.BaseActivity
import com.e.kotlinwanandroid.R
import com.youth.banner.Banner
import com.youth.banner.BannerConfig
import conn.RetfitMain
import imageloader.GlideImageLoader
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

class DemoActivity:BaseActivity(){
    private lateinit var mBanner: Banner
    private lateinit var tv_demo123:TextView
    override fun initView() {
        mBanner =findViewById(R.id.banner_demo)
        tv_demo123=findViewById(R.id.tv_demo123)
    }

    override fun initData(bundle: Bundle?) {
        tv_demo123.text="我来了————————————"
        mBanner.setImageLoader(GlideImageLoader())
        mBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE)
        mBanner.setDelayTime(5000)
        //设置是否自动轮播
        mBanner.isAutoPlay(true)
        var images= ArrayList<String>()
        var titles =ArrayList<String>()
        for (datum in 1..8){
            images.add("https://www.wanandroid.com/blogimgs/50c115c2-cf6c-4802-aa7b-a4334de444cd.png")
            titles.add("123456")
        }
        mBanner!!.setImages(images)
        mBanner!!.setBannerTitles(titles)
        mBanner!!.start()
    }

    override fun getLayoutId()= R.layout.activity_demo

}