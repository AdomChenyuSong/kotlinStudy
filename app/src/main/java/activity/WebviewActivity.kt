package activity

import android.os.Bundle
import android.support.v4.app.Fragment
import base.BaseToolbarActivity
import fragment.webview.WebViewFragment

class WebviewActivity :BaseToolbarActivity(){
    lateinit var title:String
    lateinit var loadUrl:String
   companion object {
       const val ARGS_TITLE="args_title"
       const val ARGS_URL="args_url"
   }

    override fun initData(bundle: Bundle?) {
        title=bundle!!.getString(ARGS_TITLE)
        loadUrl=bundle!!.getString(ARGS_URL)
        super.initData(bundle)

    }
    override fun getTransFragment(): Fragment=WebViewFragment.newInstance(loadUrl)

    override fun getToolsBarTitle(): String =title
}