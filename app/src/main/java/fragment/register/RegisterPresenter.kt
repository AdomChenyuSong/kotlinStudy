package fragment.register

import base.BaseObserver
import bean.BaseDataBean
import bean.UserBean
import conn.RxClient
import mvp.BaseMvpPresenter
import java.util.HashMap

class RegisterPresenter : BaseMvpPresenter<RegisterView>() {
    fun userToResigter(username: String, password: String) {
        val request = HashMap<String, String>()
        request["username"] = username
        request["password"] = password
        request["repassword"] = password
        RxClient.userToRegister(request)!!.subscribe(object : BaseObserver<BaseDataBean<UserBean>>() {
            override fun onNext(value: BaseDataBean<UserBean>) {

            }
        })
    }
}
