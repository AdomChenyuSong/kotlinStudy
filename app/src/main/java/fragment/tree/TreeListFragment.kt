package fragment.tree

import android.os.Bundle
import bean.SystemTreeBean
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.e.kotlinwanandroid.R
import list.BaseListFragment
import list.BaseProvider
import list.DefaultListProvider

class TreeListFragment:BaseListFragment<SystemTreeBean>(){
    var isStart:Boolean=false
    var treeItemDecoration: TreeItemDecoration? = null
    override fun onStart() {
        super.onStart()
        isStart=true
    }

    override fun onPause() {
        super.onPause()
        isStart=false
    }

    override fun initData(bundle: Bundle?) {
        super.initData(bundle)
        val listData = getProvider() as DefaultListProvider<SystemTreeBean>
        var data = listData.data
        treeItemDecoration = TreeItemDecoration(context, object : TreeItemDecoration.DecorationCallback {
            override fun getGroupId(position: Int): Long {
                return Character.toUpperCase(data[position].name!![0]).toLong()
            }

            override fun getGroupFirstLine(position: Int): String {
                return data[position].name!!
            }
        })
        getRecycleView().addItemDecoration(treeItemDecoration!!)

    }
    override fun createAdapter(): BaseQuickAdapter<SystemTreeBean, BaseViewHolder> {
        val listData = getProvider() as DefaultListProvider<SystemTreeBean>
        var listAdapter = adapters.SystemTreeListAdapter(R.layout.item_systemtree, listData.data)
        return listAdapter
    }
    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        if (isVisibleToUser&&isStart){
            getRecycleView().addItemDecoration(treeItemDecoration!!)
        }else{
            getRecycleView().removeItemDecoration(treeItemDecoration!!)
        }
    }

    override fun createSubscriber(): BaseProvider<SystemTreeBean> {
        val systemProvider=TreeProvider() as BaseProvider<SystemTreeBean>
        return systemProvider
    }

}