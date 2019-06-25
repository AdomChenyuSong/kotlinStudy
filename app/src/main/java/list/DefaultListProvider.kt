package list

import conn.RetfitMain
import io.reactivex.Observable
import java.lang.NullPointerException


abstract class DefaultListProvider<T>:BaseListProvider<T>(){
    var data=ArrayList<T>()
    var page:Int=1
    val PAGE_SIZE:Int=20;
    override fun addData(e: T) {
        data.add(e)
    }

    override fun getIndexData(position: Int): T {
      return data!![position]
    }

    override fun getIntemCount():Int {
        return data!!.size
    }

    override fun clearData() {
        data.clear()
    }

    override fun removeData(index: Int) {
        data.removeAt(index)
    }

    override fun removeData(da: T) {
        data.remove(da)
    }

    override fun loadNext(isForce: Boolean) {
        if (observer==null){
            throw NullPointerException("oberver must be not null")
        }
        if (isLoading){
            return
        }
        isLoading=true
        makeObservable(page).compose(RetfitMain.SchedulerTransFormer())
            .doOnNext{
            list->if (page==0){
            data.clear()
          }
          if (list!!.size<PAGE_SIZE||list.size%10!=0){
                isEnd=true
          }
          ++page
          data.addAll(list)
        }.doOnError{
            if (page>1) page=page--
            isLoading=false
        }.doOnComplete{
            isLoading=false
        }.subscribe(observer)

    }

    /**
     * 生成数据源
     */
    abstract fun makeObservable(page: Int): Observable<List<T>>
    override fun refresh() {
        data.clear()
        page=1
        loadNext(false)
    }

}