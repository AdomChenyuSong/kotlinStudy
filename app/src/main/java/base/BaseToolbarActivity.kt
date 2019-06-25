package base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v7.widget.Toolbar
import com.e.kotlinwanandroid.R
import java.lang.NullPointerException

abstract class BaseToolbarActivity:BaseActivity(){
    private lateinit var include_toolbar: Toolbar
    private lateinit var mFragmentManager:FragmentManager
     override fun getLayoutId(): Int = R.layout.base_toolbar_activity
     override fun initView() {
         include_toolbar=findViewById(R.id.include_toolbdpar)
     }

     override fun initData(bundle: Bundle?) {

         include_toolbar.title=getToolsBarTitle()
         setSupportActionBar(include_toolbar)
         mFragmentManager=supportFragmentManager
         include_toolbar.setNavigationOnClickListener { finish() }
         if (mFragmentManager==null||getTransFragment()==null){
             throw NullPointerException(" getTransFragment()==null||mFragmentManager==null ")
         }
         mFragmentManager.beginTransaction()
             .add(R.id.base_toolbar_fl_container, getTransFragment())
             .commitAllowingStateLoss()
     }

    fun addFragment(fragment: Fragment) {
        mFragmentManager.beginTransaction().add(R.id.base_toolbar_fl_container, fragment).commitAllowingStateLoss()
    }

    fun removeTopFragment(fragment: Fragment) {
        mFragmentManager.beginTransaction().remove(fragment)
    }

    abstract fun getTransFragment(): Fragment
    abstract fun getToolsBarTitle():String
}