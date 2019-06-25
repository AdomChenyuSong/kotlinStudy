package fragment.login

import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import bean.UserBean
import com.e.kotlinwanandroid.R
import com.gs.keyboard.SecurityEditText
import fragment.register.RegisterPresenter
import fragment.register.RegisterView
import mvp.BaseMvpFragment

class RegisterFragment : BaseMvpFragment<RegisterView, RegisterPresenter>(), View.OnClickListener, RegisterView {
    override fun updataView(userBean: UserBean) {
    }

    override fun initData(bundle: Bundle?) {
    }

    override fun initPresenter(): RegisterPresenter= RegisterPresenter()

    override fun getLayoutId(): Int = R.layout.activity_register



    private var img_account: ImageView? = null
    private var account_devide_line: View? = null
    private var et_account: EditText? = null
    private var cons_account: ConstraintLayout? = null
    private var img_password: ImageView? = null
    private var password_devide_line: View? = null
    private var et_password: SecurityEditText? = null
    private var cons_password: ConstraintLayout? = null
    private var img_repassword: ImageView? = null
    private var repassword_devide_line: View? = null
    private var et_repassword: SecurityEditText? = null
    private var cons_repassword: ConstraintLayout? = null
    private var bt_register: Button? = null
    private var root: ConstraintLayout? = null
    private var registerPresenter: RegisterPresenter? = null
    override fun initView(mView: View) {
        img_account = mView.findViewById(R.id.img_account) as ImageView
        account_devide_line = mView.findViewById(R.id.account_devide_line) as View
        et_account = mView.findViewById(R.id.et_account) as EditText
        cons_account = mView.findViewById(R.id.cons_account) as ConstraintLayout
        img_password = mView.findViewById(R.id.img_password) as ImageView
        password_devide_line = mView.findViewById(R.id.password_devide_line) as View
        et_password = mView.findViewById(R.id.et_password) as SecurityEditText
        cons_password = mView.findViewById(R.id.cons_password) as ConstraintLayout
        img_repassword = mView.findViewById(R.id.img_repassword) as ImageView
        repassword_devide_line = mView.findViewById(R.id.repassword_devide_line) as View
        et_repassword = mView.findViewById(R.id.et_repassword) as SecurityEditText
        cons_repassword = mView.findViewById(R.id.cons_repassword) as ConstraintLayout
        bt_register = mView.findViewById(R.id.bt_register) as Button
        root = mView.findViewById(R.id.root) as ConstraintLayout
        bt_register!!.setOnClickListener(this)
    }

    /**
     * 注册
     */
    private fun submit() {
        // validate
        val account = et_account!!.text.toString().trim { it <= ' ' }
        if (!chargeSubmit("账号", account)) {
            return
        }
        val password = et_password!!.text!!.toString().trim { it <= ' ' }
        if (!chargeSubmit("密码", password)) {
            return
        }

        val repassword = et_repassword!!.text!!.toString().trim { it <= ' ' }
        if (!chargeSubmit("确认密码", repassword)) {
            return
        }
        registerPresenter!!.userToResigter(account, password)

    }

    /**
     * 判断是否符合标准
     * @param hint
     * @param value
     * @return
     */
    private fun chargeSubmit(hint: String, value: String): Boolean {
        if (TextUtils.isEmpty(value) || value.length < 6) {
            Toast.makeText(getContext(), hint + "不能为空或小于6个有效字符", Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }


}
