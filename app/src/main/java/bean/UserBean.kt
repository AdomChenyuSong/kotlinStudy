package bean

/**
 * 描述：
 *
 * @author 周麟
 * @date 2018/7/24/024 22:09
 */
class UserBean {
    var id: Int = 0
    var username: String? = null
    var password: String? = null
    var email: String? = null
    var token: String? = null
    var icon: String? = null
    var type: Int = 0

    var collectIds: List<Int>? = null
    var chapterTops: List<Int>? = null
}
