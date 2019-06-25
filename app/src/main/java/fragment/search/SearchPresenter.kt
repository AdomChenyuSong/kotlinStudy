package fragment.search

import base.BaseObserver
import bean.SearchBean
import conn.RxClient
import mvp.BaseMvpPresenter

class SearchPresenter:BaseMvpPresenter<SearchView>(){
     fun getHotKeyList(){
         RxClient.getHotKeyList()!!.subscribe(object :BaseObserver<List<SearchBean>>(){
             override fun onNext(value: List<SearchBean>) {
                 super.onNext(value)
                view!!.updateHotSearch(value)
             }
         })
     }
}