package list

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import io.reactivex.Observer

abstract class BaseProvider<T>{
    private val LOAD_DATA_FROM_LAST_ITEM_COUNT = 2
    /**
     * 是否正在加载
     */
    var isLoading:Boolean=false
    /**
     * 是否是最后一页
     */
    var isEnd:Boolean=false

    /**
     *
     */
    abstract fun loadNext(isForce:Boolean)

    abstract fun refresh()

    lateinit var observer: Observer<T>


    fun bindRecyclerView(recyclerView: RecyclerView) {
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (recyclerView.layoutManager is LinearLayoutManager) {
                    val manager = recyclerView.layoutManager as LinearLayoutManager?
                    if (manager!!.findLastVisibleItemPosition() > manager.itemCount - LOAD_DATA_FROM_LAST_ITEM_COUNT
                        && !isEnd && !isLoading
                    ) {
                        loadNext(false)
                    }
                }
            }
        })
    }
}