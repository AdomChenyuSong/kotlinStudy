package adapters

import android.content.Context
import android.view.View
import base.BaseListDataBean
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import untils.IntentUntils

abstract class BaseQuickItemClickAdapter<T, K : BaseViewHolder>(
    private val mContext: Context,
    layoutResId: Int,
    data: List<T>?
) : BaseQuickAdapter<T, BaseViewHolder>(layoutResId, data), BaseQuickAdapter.OnItemClickListener,
    BaseQuickAdapter.OnItemLongClickListener {
    init {
        init()
    }

    internal fun init() {
        onItemClickListener = this
        onItemLongClickListener = this
    }

    override fun onItemClick(adapter: BaseQuickAdapter<*, *>, view: View, position: Int) {
        var baseListDataBean = data[position] as BaseListDataBean

        IntentUntils.startToWebview(view.context,baseListDataBean.link!!,baseListDataBean.title!!)
    }

    override fun onItemLongClick(adapter: BaseQuickAdapter<*, *>, view: View, position: Int): Boolean {

        return false
    }
}
