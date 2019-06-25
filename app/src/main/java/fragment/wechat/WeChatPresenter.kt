package fragment.wechat

import base.BaseObserver
import bean.WxChaptersBean
import conn.RxClient
import mvp.BaseMvpPresenter

class WeChatPresenter:BaseMvpPresenter<WeChatView>(){
    fun  getListData(){
        RxClient.getWxCharList()!!.subscribe(object :BaseObserver<List<WxChaptersBean>>(){
            override fun onNext(value: List<WxChaptersBean>) {
                super.onNext(value)
                view!!.updataWxChatListData(value)
            }
        })
    }
}