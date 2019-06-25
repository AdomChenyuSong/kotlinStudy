package fragment.search

import bean.SearchBean
import mvp.BaseMvpView

interface SearchView:BaseMvpView{
   fun updateHotSearch(value:List<SearchBean>)
}