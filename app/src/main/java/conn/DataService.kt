package conn

import bean.*
import io.reactivex.Observable
import okhttp3.RequestBody
import retrofit2.http.*

interface DataService{
    @GET("article/list/{page}/json")
    fun getArticleList(@Path("page") pages: Int): Observable<BaseListPlusBean<HomeArticleBean>>

    @GET("banner/json")
    fun getBannerList(): Observable<BaseDataBean<List<HomeBannerBean>>>

    @POST("lg/collect/{id}/json")
    fun post_CollectArticle(@Path("id") id: Int): Observable<RequestBody>

    @POST("lg/uncollect_originId/{id}/json")
    fun post_UncollectArticle(@Path("id") id: Int): Observable<RequestBody>

    @GET("project/tree/json")
    fun getProjectTreeList(): Observable<BaseDataBean<List<ProjectTreeBean>>>

    @GET("project/list/{path}/json")
    fun getProjectTreeList(@Path("path") page: Int, @Query("cid") cid: Int): Observable<BaseListPlusBean<ProjectsListBean>>

    @GET("tree/json")
    fun getSystemTreeList(): Observable<BaseDataBean<List<SystemTreeBean>>>

    @GET("wxarticle/chapters/json")
    fun getWXChaptersList(): Observable<BaseDataBean<List<WxChaptersBean>>>

    @GET("wxarticle/list/{id}/{pages}/json")
    fun getWxArticleList(@Path("pages") pages: Int, @Path("id") id: Int): Observable<BaseListPlusBean<WxArticleBean>>

    @POST("user/register")
    fun toRegister(@QueryMap data: Map<String, Any>): Observable<BaseDataBean<UserBean>>

    @POST("user/login")
    fun toLogin(@QueryMap data: Map<String, Any>): Observable<BaseDataBean<UserBean>>

    @POST("hotkey/json")
    fun getHotKey(): Observable<BaseDataBean<List<SearchBean>>>

    @POST("article/query/{page}/json")
    fun toSearchKey(@Path("page") pages: Int, @QueryMap data: Map<String, String>): Observable<BaseListPlusBean<SearchKeysBean>>

}