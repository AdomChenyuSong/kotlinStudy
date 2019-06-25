package fragment.wechat

import adapters.BaseListAdapter
import android.os.Bundle
import base.BaseListDataBean
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import list.BaseListFragment
import list.BaseProvider
import list.DefaultListProvider

class WeChatDetailFragment :BaseListFragment<BaseListDataBean>(){
    var ids:Int=0
    companion object {
        const val ARGS_CID="args_cid";
        fun newInstance(ids:Int):WeChatDetailFragment{
            var weChatFragment= WeChatDetailFragment()
            var bundle=Bundle();
            bundle.putInt(ARGS_CID,ids)
            weChatFragment.arguments=bundle
            return weChatFragment
        }
    }

    override fun initData(bundle: Bundle?) {
        ids=bundle!!.getInt(ARGS_CID)
        super.initData(bundle)

    }
    override fun createAdapter(): BaseQuickAdapter<BaseListDataBean, BaseViewHolder> {
        var defaultListProvider = getProvider() as DefaultListProvider<BaseListDataBean>
        val wxDetailsListAdapter= BaseListAdapter(context, defaultListProvider.data)
        return wxDetailsListAdapter
    }

    override fun createSubscriber(): BaseProvider<BaseListDataBean>{
        val wxDetailsProvider= WxDetailsProvider(ids) as BaseProvider<BaseListDataBean>
        return wxDetailsProvider
    }

}