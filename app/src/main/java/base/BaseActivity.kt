package base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

abstract class BaseActivity:AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var supportActionBar = getSupportActionBar()
        if (supportActionBar!=null){
            supportActionBar!!.hide()
        }
        setContentView(getLayoutId())
        var extras = intent.extras
        if (extras==null){
            extras=savedInstanceState;
        }
        initView()
        initData(extras)
    }

    abstract fun getLayoutId():Int
    abstract fun initView()
    abstract fun initData(bundle:Bundle?)
}