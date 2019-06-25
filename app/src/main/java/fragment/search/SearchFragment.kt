package fragment.search

import android.os.Bundle
import android.view.View
import bean.SearchBean
import co.lujun.androidtagview.TagContainerLayout
import co.lujun.androidtagview.TagView
import com.e.kotlinwanandroid.R
import mvp.BaseMvpFragment
import untils.IntentUntils

class SearchFragment :BaseMvpFragment<SearchView,SearchPresenter>(),SearchView{
    lateinit var layout_hotkey_search: TagContainerLayout
    override fun updateHotSearch(value: List<SearchBean>) {
           initSearchView(value)
    }
    private fun initSearchView(value: List<SearchBean>){
        layout_hotkey_search.removeAllTags()
        for (bean in value){
            layout_hotkey_search.addTag(bean.name)
            layout_hotkey_search.setOnTagClickListener(object :TagView.OnTagClickListener{
                override fun onTagLongClick(position: Int, text: String?) {
                }

                override fun onTagClick(position: Int, text: String?) {
                    IntentUntils.startToSearch(context,text!!)
                }

                override fun onTagCrossClick(position: Int) {
                }

            })
        }
    }

    override fun initView(views: View) {
        layout_hotkey_search=views.findViewById(R.id.layout_hotkey_search)
    }

    override fun initData(bundle: Bundle?) {
        searchPresenter.getHotKeyList()
    }

    override fun getLayoutId(): Int= R.layout.fragment_search
    var searchPresenter=SearchPresenter()
    override fun initPresenter(): SearchPresenter= searchPresenter

}