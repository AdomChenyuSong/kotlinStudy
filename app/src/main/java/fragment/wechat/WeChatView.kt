package fragment.wechat

import bean.WxChaptersBean
import mvp.BaseMvpView

interface WeChatView :BaseMvpView{
    fun updataWxChatListData(value: List<WxChaptersBean>)
}