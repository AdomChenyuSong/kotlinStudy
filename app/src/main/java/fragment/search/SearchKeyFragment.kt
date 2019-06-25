package fragment.search

import android.os.Bundle
import android.text.Html
import bean.SearchKeysBean
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.e.kotlinwanandroid.R
import item.ListDeviderDecoration
import kotlinx.android.synthetic.main.item_list_card.*
import list.BaseListFragment
import list.BaseProvider
import list.DefaultListProvider

class SearchKeyFragment:BaseListFragment<SearchKeysBean>(){
   private lateinit var searchKey:String
    companion object {
        const val ARGS_SEARCH_KEYS:String="args_search_key"
        fun newInstance(keys:String):SearchKeyFragment{
            var searchKeyFragment=SearchKeyFragment()
            var bundle=Bundle()
            bundle.putString(ARGS_SEARCH_KEYS,keys)
            searchKeyFragment.arguments=bundle
            return searchKeyFragment
        }
    }


    override fun initData(bundle: Bundle?) {
        searchKey=bundle!!.getString(ARGS_SEARCH_KEYS)
        super.initData(bundle)
        getRecycleView().addItemDecoration(ListDeviderDecoration(context))

    }
    override fun createSubscriber(): BaseProvider<SearchKeysBean> {
      var searchKeyProvider = SearchKeyProvider(searchKey) as BaseProvider<SearchKeysBean>
      return  searchKeyProvider;
     }

    override fun createAdapter(): BaseQuickAdapter<SearchKeysBean, BaseViewHolder> {
        var defaultListProvider = getProvider() as DefaultListProvider<SearchKeysBean>
        return ChildenAdapter(R.layout.item_tree_name, defaultListProvider.data)
    }

    inner class ChildenAdapter(layoutResId: Int, data: List<SearchKeysBean>?) :
        BaseQuickAdapter<SearchKeysBean, BaseViewHolder>(layoutResId, data) {

        override fun convert(helper: BaseViewHolder, item: SearchKeysBean) {

            helper.setText(R.id.tv_tree_name, Html.fromHtml(item.title))
        }
    }

}