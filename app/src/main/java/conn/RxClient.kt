package conn

import bean.*
import io.reactivex.Observable

class RxClient{

    companion object {
        fun getBannerList(): Observable<List<HomeBannerBean>>?= RetfitMain.Companion.getInstance()!!.createClass(DataService::class.java).getBannerList()
                    .compose(RetfitMain.SchedulerTransFormer()).flatMap {
                        t->
                    var baseData = t.data
                    Observable.just(baseData)
                }
        fun getArticleList(pages:Int): Observable<List<HomeArticleBean>>?= RetfitMain.Companion.getInstance()!!.createClass(DataService::class.java).getArticleList(pages)
            .compose(RetfitMain.SchedulerTransFormer()).flatMap {
                    t->
                var basedata=t.data!!.datas as List<HomeArticleBean>
                Observable.just(basedata)
            }
        fun getProjectList(): Observable<List<ProjectTreeBean>>?= RetfitMain.Companion.getInstance()!!.createClass(DataService::class.java).getProjectTreeList()
            .compose(RetfitMain.SchedulerTransFormer()).flatMap {
                    t->
                var basedata=t.data as List<ProjectTreeBean>
                Observable.just(basedata)
            }
        fun getProjectTreeList(id:Int): Observable<List<ProjectsListBean>>?= RetfitMain.Companion.getInstance()!!.createClass(DataService::class.java).getProjectTreeList(1,id)
            .compose(RetfitMain.SchedulerTransFormer()).flatMap {
                    t->
                var basedata=t.data!!.datas as List<ProjectsListBean>
                Observable.just(basedata)
            }
        fun getWxCharList(): Observable<List<WxChaptersBean>>?= RetfitMain.Companion.getInstance()!!.createClass(DataService::class.java).getWXChaptersList()
            .compose(RetfitMain.SchedulerTransFormer()).flatMap {
                    t->
                var basedata=t.data!! as List<WxChaptersBean>
                Observable.just(basedata)
            }
        fun getWxCharDetailsList(pages:Int,ids:Int): Observable<List<WxArticleBean>>?= RetfitMain.Companion.getInstance()!!.createClass(DataService::class.java).getWxArticleList(pages,ids)
            .compose(RetfitMain.SchedulerTransFormer()).flatMap {
                    t->
                var basedata=t.data!!.datas as List<WxArticleBean>
                Observable.just(basedata)
            }
        fun getSystemTreeList(): Observable<List<SystemTreeBean>>?= RetfitMain.Companion.getInstance()!!.createClass(DataService::class.java).getSystemTreeList()
            .compose(RetfitMain.SchedulerTransFormer()).flatMap {
                    t->
                var basedata=t.data!! as List<SystemTreeBean>
                Observable.just(basedata)
            }
        fun userToRegister(pushData: Map<String,String>):Observable<BaseDataBean<UserBean>>?= RetfitMain.Companion.getInstance()!!.createClass(DataService::class.java).toRegister(pushData)

        fun userToLogin(pushData: Map<String,String>):Observable<BaseDataBean<UserBean>>?= RetfitMain.Companion.getInstance()!!.createClass(DataService::class.java).toLogin(pushData)

        fun getHotKeyList(): Observable<List<SearchBean>>?= RetfitMain.Companion.getInstance()!!.createClass(DataService::class.java).getHotKey()
            .compose(RetfitMain.SchedulerTransFormer()).flatMap { t ->
                var basedata = t.data as List<SearchBean>
                Observable.just(basedata)
            }
        fun getHotKeyList(pages:Int, data: Map<String, String>): Observable<List<SearchKeysBean>>?= RetfitMain.Companion.getInstance()!!.createClass(DataService::class.java).toSearchKey(pages,data)
            .compose(RetfitMain.SchedulerTransFormer()).flatMap { t ->
                var basedata = t!!.data!!.datas as List<SearchKeysBean>
                Observable.just(basedata)
            }

    }



}
