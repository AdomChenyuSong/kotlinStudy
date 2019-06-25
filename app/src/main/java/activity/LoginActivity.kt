package activity

import android.support.v4.app.Fragment
import base.BaseToolbarActivity
import fragment.register.LoginFragment

class LoginActivity :BaseToolbarActivity(){
    override fun getToolsBarTitle(): String ="登录"

    override fun getTransFragment(): Fragment{
        var loginFragment=LoginFragment() as Fragment
        return loginFragment
    }
}