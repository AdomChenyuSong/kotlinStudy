package fragment.register


import bean.UserBean
import mvp.BaseMvpView

interface RegisterView : BaseMvpView {
    fun updataView(userBean: UserBean)
}

