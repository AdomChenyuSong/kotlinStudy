package list
abstract class BaseListProvider<E>:BaseProvider<List<E>>(){
    companion object {
        const val PAGES:Int=1
    }
    abstract fun addData(e:E)
    abstract fun clearData()
    abstract fun removeData(index:Int)
    abstract fun removeData(data:E)
    abstract fun getIndexData(position:Int):E
    abstract fun getIntemCount():Int


}
