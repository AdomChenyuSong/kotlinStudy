package mvp

import okhttp3.Call
import java.lang.ref.WeakReference

abstract class BaseMvpPresenter<V>{
    private  var mView:WeakReference<V>?=null
    private var mCall: Call?=null;

    fun attachView(view:V){
        mView=WeakReference(view)
    }
   fun dettachView(){
       if (mView!=null){
           mView!!.clear()
           mView=null
       }
       mCall?.cancel()
   }
    val view: V?
        get() = mView!!.get()
}
