package bean

class BaseListPlusBean<T> : BaseBean() {

    var data: DataBean<T>? = null

    inner class DataBean<T> {
        var curPage: Int = 0
        var offset: Int = 0
        var isOver: Boolean = false
        var pageCount: Int = 0
        var size: Int = 0
        var total: Int = 0
        var datas: List<T>? = null

    }
}
