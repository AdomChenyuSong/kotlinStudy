package fragment.wechat

import adapters.WxChatListAdapter
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.view.View
import bean.WxChaptersBean
import com.e.kotlinwanandroid.R
import mvp.BaseMvpFragment

class WeChatFragment :BaseMvpFragment<WeChatView,WeChatPresenter>(),WeChatView{
    private var tab_layout: TabLayout? = null
    private var view_pager: ViewPager? = null
    var weChatPresenter=WeChatPresenter()
    override fun updataWxChatListData(value: List<WxChaptersBean>) {
        var adapter= WxChatListAdapter(childFragmentManager,value)
        view_pager!!.adapter=adapter
        tab_layout!!.setupWithViewPager(view_pager)
    }

    override fun initPresenter(): WeChatPresenter = weChatPresenter

    override fun initView(views: View) {
        view_pager = views.findViewById(R.id.view_pager)
        tab_layout = views.findViewById(R.id.tab_layout)
    }

    override fun initData(bundle: Bundle?) {
        weChatPresenter.getListData()

    }

    override fun getLayoutId(): Int = R.layout.fragment_tabproject

}