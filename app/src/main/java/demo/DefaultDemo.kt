package demo

import bean.HomeBannerBean
import conn.RxClient
import io.reactivex.Observable
import list.DefaultListProvider

class DefaultDemo: DefaultListProvider<HomeBannerBean>() {
    override fun makeObservable(page: Int): Observable<List<HomeBannerBean>> {
         return RxClient.getBannerList()!!
    }

}