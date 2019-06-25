package activity

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.MenuItemCompat
import android.support.v7.widget.SearchView
import android.text.TextUtils
import android.view.Menu
import base.BaseToolbarActivity
import com.e.kotlinwanandroid.R
import fragment.search.SearchFragment
import fragment.search.SearchKeyFragment
import fragment.search.SearchKeyFragment.Companion.ARGS_SEARCH_KEYS

class SearchActivity:BaseToolbarActivity(){
   lateinit var mSearchView:SearchView
    override fun getToolsBarTitle(): String ="搜索"
    var fragment=Fragment()
    override fun getTransFragment(): Fragment =fragment

    override fun initData(bundle: Bundle?) {
        if (bundle!=null&&bundle!!.containsKey(ARGS_SEARCH_KEYS)){
            val searchKey= bundle!!.getString(ARGS_SEARCH_KEYS)
            if (TextUtils.isEmpty(searchKey)){
                fragment=SearchFragment()
            }else{
                fragment=SearchKeyFragment.newInstance(searchKey)
            }
        }else{
            fragment=SearchFragment()
        }
        super.initData(bundle)

    }


    /**
     * 重写此方法显示Menu Item
     */
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_search, menu)
        val menuItem = menu.findItem(R.id.item_searchview)
        mSearchView = MenuItemCompat.getActionView(menuItem) as SearchView
        //通过MenuItem得到SearchView
        mSearchView.setFocusable(false)
        mSearchView.setIconified(false)
        mSearchView.setQueryHint("请输入您要搜索的内容")
        mSearchView.setFocusableInTouchMode(true)
        mSearchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(s: String): Boolean {
               if (TextUtils.isEmpty(s)){
                   return false
               }
                var newInstance = SearchKeyFragment.newInstance(s)
                addFragment(newInstance)
                return false
            }

            override fun onQueryTextChange(s: String): Boolean {
                return false
            }
        })
        return true
    }

    override fun onBackPressed() {
        super.onBackPressed()

    }
}