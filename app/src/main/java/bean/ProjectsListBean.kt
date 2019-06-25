package bean

import base.BaseListDataBean

class ProjectsListBean: BaseListDataBean() {
    /**
     * apkLink :
     * author : sunnnydaydev
     * chapterId : 294
     * chapterName : 完整项目
     * collect : false
     * courseId : 13
     * desc : 防电商app大部分功能的简单实现。
     * 文章发布：https://blog.csdn.net/qq_38350635/article/details/88830452
     * envelopePic : https://www.wanandroid.com/blogimgs/af1cb19d-bde0-434e-b6c6-79a28a75e3ad.png
     * fresh : false
     * id : 8145
     * link : http://www.wanandroid.com/blog/show/2540
     * niceDate : 2019-03-26
     * origin :
     * projectLink : https://github.com/sunnnydaydev/ModelMall
     * publishTime : 1553615560000
     * superChapterId : 294
     * superChapterName : 开源项目主Tab
     * tags : [{"name":"项目","url":"/project/list/1?cid=294"}]
     * title : 简单的电商app练习
     * type : 0
     * userId : -1
     * visible : 1
     * zan : 0
     */

    var desc: String? = null
    var isFresh: Boolean = false
    var niceDate: String? = null
    var origin: String? = null
    var projectLink: String? = null
    var superChapterId: Int = 0
    var superChapterName: String? = null
    var userId: Int = 0
    var zan: Int = 0
    var tags: List<TagsBean>? = null

    class TagsBean {
        /**
         * name : 项目
         * url : /project/list/1?cid=294
         */

        var name: String? = null
        var url: String? = null
    }
}
