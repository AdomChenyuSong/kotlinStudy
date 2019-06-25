package base

import android.util.Log
import android.widget.Toast
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

open class BaseObserver<T>:Observer<T>{
    private var disposable: Disposable? = null
    override fun onComplete() {
    }
    open fun onStart(){

    }
    override fun onSubscribe(d: Disposable?) {
        disposable=d
        onStart()
    }

    override fun onNext(value: T) {

    }

    override fun onError(e: Throwable?) {
        Log.e("SCY"," -BaseObserver - -onError- - --  "+e!!.message)
    }

}
