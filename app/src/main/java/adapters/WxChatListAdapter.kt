package adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import bean.WxChaptersBean
import fragment.wechat.WeChatDetailFragment

class WxChatListAdapter(fm: FragmentManager?,data:List<WxChaptersBean>) : FragmentStatePagerAdapter(fm) {
    val dataList=data
    override fun getItem(p0: Int): Fragment = WeChatDetailFragment.newInstance(dataList[p0].id)

    override fun getCount(): Int=dataList.size

    override fun getPageTitle(position: Int): CharSequence? {
        return dataList[position].name
    }
}