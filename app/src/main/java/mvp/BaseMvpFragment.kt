package mvp

import android.os.Bundle
import base.BaseFragment

abstract class BaseMvpFragment<V,P :BaseMvpPresenter<V> >:BaseFragment() {
    private var mvpPresenter:P?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mvpPresenter=initPresenter()
        if (mvpPresenter!=null){
            mvpPresenter!!.attachView(this as V)
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        if (mvpPresenter!=null){
            mvpPresenter!!.dettachView()
        }
    }

    abstract fun initPresenter():P

}

