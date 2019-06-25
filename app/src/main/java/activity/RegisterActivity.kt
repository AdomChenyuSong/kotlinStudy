package activity

import android.support.v4.app.Fragment
import base.BaseToolbarActivity
import fragment.login.RegisterFragment

class RegisterActivity:BaseToolbarActivity(){
    override fun getTransFragment(): Fragment =RegisterFragment()

    override fun getToolsBarTitle(): String ="注册"

}