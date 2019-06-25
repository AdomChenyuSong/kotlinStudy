package bean

open class BaseBean {
    var errorCode: Int=0
    lateinit var errorMsg: String
    var isSuccess: Boolean = false
        get() = errorCode==0

}
