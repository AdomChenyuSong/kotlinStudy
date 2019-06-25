package adapters

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import bean.SystemTreeBean
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.e.kotlinwanandroid.R

class SystemTreeListAdapter(layoutResId:Int ,data:List<SystemTreeBean>): BaseQuickAdapter<SystemTreeBean, BaseViewHolder>(layoutResId,data){
    override fun convert(helper: BaseViewHolder?, beans: SystemTreeBean?) {
        var recyclerView = helper!!.getView<View>(R.id.ll_treenames) as RecyclerView
        var children = beans!!.children
        var manager=LinearLayoutManager(recyclerView.context)
        recyclerView.layoutManager=manager
        var childrenList = beans.children
        val  childenAdapter=ChildenAdapter(R.layout.item_tree_name, childrenList!!)
        recyclerView.addItemDecoration(item.ListDeviderDecoration(recyclerView.context))
        recyclerView.adapter=childenAdapter

    }
    inner class ChildenAdapter(layoutResId:Int ,data:List<SystemTreeBean.ChildrenBean>) :BaseQuickAdapter<SystemTreeBean.ChildrenBean,BaseViewHolder>(layoutResId,data){
        override fun convert(helper: BaseViewHolder?, item: SystemTreeBean.ChildrenBean?) {
            helper!!.setText(R.id.tv_tree_name, item!!.name)
        }

    }

}