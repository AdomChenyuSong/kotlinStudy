package fragment.search

import bean.SearchKeysBean
import conn.RxClient
import io.reactivex.Observable
import list.DefaultListProvider
import java.util.*

class SearchKeyProvider(keys:String):DefaultListProvider<SearchKeysBean>(){
    var key=keys
    override fun makeObservable(page: Int): Observable<List<SearchKeysBean>> {
        val request = HashMap<String, String>()
        request.put("k",key)
        return RxClient.getHotKeyList(page,request)!!
    }

}