package demo

import android.os.Bundle
import android.view.View
import com.e.kotlinwanandroid.R
import mvp.BaseMvpFragment

class DemoFragment :BaseMvpFragment<DemoView,DemoPresenter>(){
    override fun initPresenter()= DemoPresenter()
    override fun initView(views: View) {
    }

    override fun initData(bundle: Bundle?) {
    }

    override fun getLayoutId()= R.layout.activity_demo
}