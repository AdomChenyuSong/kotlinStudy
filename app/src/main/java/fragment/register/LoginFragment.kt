package fragment.register

import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.text.TextUtils
import android.view.View
import android.widget.*
import base.BaseActivity
import base.BaseFragment
import base.BaseObserver
import bean.BaseDataBean
import bean.UserBean
import com.e.kotlinwanandroid.R
import com.gs.keyboard.SecurityEditText
import conn.RxClient
import untils.IntentUntils
import java.util.*

/**
 * 登录界面
 */
class LoginFragment : BaseFragment(), View.OnClickListener {
    override fun getLayoutId(): Int=R.layout.activity_login

    override fun initView(views:View) {
        bg = views.findViewById(R.id.bg) as ImageView
        bg!!.setOnClickListener(this)
        appName =views. findViewById(R.id.appName) as TextView
        appName!!.setOnClickListener(this)
        et_account =views. findViewById(R.id.et_account) as EditText
        et_account!!.setOnClickListener(this)
        tv_password =views. findViewById(R.id.tv_password) as SecurityEditText
        tv_password!!.setOnClickListener(this)
        bt_login = views.findViewById(R.id.bt_login) as Button
        bt_login!!.setOnClickListener(this)
        tv_register = views.findViewById(R.id.tv_register) as TextView
        tv_register!!.setOnClickListener(this)
        ll_login = views.findViewById(R.id.ll_login) as LinearLayout
        ll_login!!.setOnClickListener(this)
        devide_line = views.findViewById(R.id.devide_line) as View
        devide_line!!.setOnClickListener(this)
        img_login_qq = views.findViewById(R.id.img_login_qq) as ImageView
        img_login_qq!!.setOnClickListener(this)
        img_login_wechat = views.findViewById(R.id.img_login_wechat) as ImageView
        img_login_wechat!!.setOnClickListener(this)
        img_login_sina = views.findViewById(R.id.img_login_sina) as ImageView
        img_login_sina!!.setOnClickListener(this)
        ll_other_login = views.findViewById(R.id.ll_other_login) as LinearLayout
        ll_other_login!!.setOnClickListener(this)
        root = views.findViewById(R.id.root) as ConstraintLayout
        root!!.setOnClickListener(this)
    }

    override fun initData(bundle: Bundle?) {
    }

    private var bg: ImageView? = null
    private var appName: TextView? = null
    private var et_account: EditText? = null
    private var tv_password: SecurityEditText? = null
    private var bt_login: Button? = null
    private var tv_register: TextView? = null
    private var ll_login: LinearLayout? = null
    private var devide_line: View? = null
    private var img_login_qq: ImageView? = null
    private var img_login_wechat: ImageView? = null
    private var img_login_sina: ImageView? = null
    private var ll_other_login: LinearLayout? = null
    private var root: ConstraintLayout? = null

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.bt_login -> submit()
            R.id.tv_register -> IntentUntils.startToRegister(context)
        }
    }

    private fun submit() {
        val account = et_account!!.text.toString().trim { it <= ' ' }
        if (!chargeSubmit("账号", account)) {
            return
        }

        val password = tv_password!!.getText().toString().trim()
        if (!chargeSubmit("密码", password)) {
            return
        }
        submit(account, password, false)
    }

    /**
     * 登录
     * @param account
     * @param password
     * @param isUserLogin 是否是自动登录
     */
    private fun submit(account: String, password: String, isUserLogin: Boolean) {
        val request = HashMap<String, String>()
        request.put("username",account)
        request.put("password",password)
        RxClient.Companion.userToLogin(request)!!.subscribe(object : BaseObserver<BaseDataBean<UserBean>>() {
            override fun onNext(value: BaseDataBean<UserBean>) {
                super.onNext(value)

            }
        })
    }

    /**
     * 判断是否符合标准
     * @param hint
     * @param value
     * @return
     */
    private fun chargeSubmit(hint: String, value: String): Boolean {
        if (TextUtils.isEmpty(value) || value.length < 6) {
            Toast.makeText(context, hint + "不能为空或小于6个有效字符", Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }

}
