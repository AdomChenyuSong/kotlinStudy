package fragment.tree

import bean.SystemTreeBean
import conn.RxClient
import io.reactivex.Observable
import list.DefaultListProvider

class TreeProvider :DefaultListProvider<SystemTreeBean>(){
    override fun makeObservable(page: Int): Observable<List<SystemTreeBean>> {
        return RxClient.getSystemTreeList()!!
    }

}