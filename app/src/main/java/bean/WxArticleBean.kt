package bean

import base.BaseListDataBean

class WxArticleBean: BaseListDataBean() {

    var desc: String? = null
    var isFresh: Boolean = false
    var niceDate: String? = null
    var origin: String? = null
    var prefix: String? = null
    var projectLink: String? = null
    var superChapterId: Int = 0
    var superChapterName: String? = null
    var userId: Int = 0
    var zan: Int = 0
    var tags: List<TagsBean>? = null

    class TagsBean {
        /**
         * name : 公众号
         * url : /wxarticle/list/408/1
         */

        var name: String? = null
        var url: String? = null
    }
}
