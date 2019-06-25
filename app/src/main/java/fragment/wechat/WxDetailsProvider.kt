package fragment.wechat

import bean.WxArticleBean
import conn.RxClient
import io.reactivex.Observable
import list.DefaultListProvider

class WxDetailsProvider(ids:Int):DefaultListProvider<WxArticleBean>(){
    var idsTemp=ids
    override fun makeObservable(page: Int): Observable<List<WxArticleBean>> {
     return RxClient.getWxCharDetailsList(page,idsTemp)!!
    }

}