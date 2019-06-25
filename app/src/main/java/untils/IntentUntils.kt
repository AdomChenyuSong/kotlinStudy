package untils

import activity.*
import android.content.Context
import android.content.Intent
import android.os.Bundle
import fragment.search.SearchKeyFragment.Companion.ARGS_SEARCH_KEYS
object IntentUntils{
    fun startToMain(mContext: Context){
        startTo(mContext, MainActivity::class.java);
    }

    fun startToLogin(mContext: Context){
        startTo(mContext,LoginActivity::class.java)
    }

    fun startToRegister(mContext: Context){
        startTo(mContext,RegisterActivity::class.java)
    }
    fun startToSearch(mContext: Context){
        startTo(mContext,SearchActivity::class.java)
    }
    fun startToSearch(mContext: Context,keys:String){
        var bundle=Bundle()
        bundle.putString(ARGS_SEARCH_KEYS,keys)
        startTo(mContext,SearchActivity::class.java,bundle)
    }

    fun startToWebview(mContext: Context,loadUrl:String,title:String){
        var bundle=Bundle()
        bundle.putString(WebviewActivity.ARGS_URL,loadUrl)
        bundle.putString(WebviewActivity.ARGS_TITLE,title)
        startTo(mContext,WebviewActivity::class.java,bundle)
    }

    fun startTo(mContext: Context, mClas:Class<*>?){
        startTo(mContext,mClas,null)
    }

    fun startTo(mContext: Context, mClas:Class<*>?, bundle: Bundle?) {
       val intent=Intent(mContext,mClas)
       if (bundle!=null){
            intent.putExtras(bundle)
        }
        mContext.startActivity(intent)

    }
}
