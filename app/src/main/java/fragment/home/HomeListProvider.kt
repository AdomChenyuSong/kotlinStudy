package fragment.home

import bean.HomeArticleBean
import conn.RxClient
import io.reactivex.Observable
import list.DefaultListProvider

class HomeListProvider:DefaultListProvider<HomeArticleBean>(){
    override fun makeObservable(page: Int): Observable<List<HomeArticleBean>> {
      return RxClient.getArticleList(page)!!
    }

}