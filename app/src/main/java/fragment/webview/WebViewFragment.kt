package fragment.webview

import activity.WebviewActivity
import android.os.Bundle
import android.view.View
import base.BaseFragment
import com.e.kotlinwanandroid.R
import views.Html5Webview

class WebViewFragment :BaseFragment(){
    private lateinit var html5Webview:Html5Webview
    private lateinit var loadUrl:String
    companion object {
        fun newInstance(loadUrl:String):WebViewFragment{
            var webviewFragment= WebViewFragment()
            var bundle=Bundle()
            bundle.putString( WebviewActivity.ARGS_URL,loadUrl)
            webviewFragment.arguments=bundle
            return webviewFragment
        }
    }
    override fun initView(views: View) {
        html5Webview=views.findViewById(R.id.html_webview)
    }

    override fun initData(bundle: Bundle?) {
        loadUrl=bundle!!.getString(WebviewActivity.ARGS_URL)
        html5Webview.loadUrl(loadUrl)
    }

    override fun getLayoutId(): Int = R.layout.fragment_webview
}