package fragment.mine

import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.e.kotlinwanandroid.R
import mvp.BaseMvpFragment
import untils.IntentUntils

class MineFragment :BaseMvpFragment<MineView,MinePresenter>(),View.OnClickListener{
    var minePresenter=MinePresenter()
    private var tv_login: TextView? = null
    private var tv_mycollect: TextView? = null
    private var tv_logout: TextView? = null
    private var tv_mine: TextView? = null
    private val tv_browse_footprints: TextView? = null
    override fun initPresenter()=minePresenter

    override fun initView(mView: View) {
        tv_login = mView.findViewById(R.id.tv_login)
        tv_login!!.setOnClickListener(this)
        tv_logout = mView.findViewById(R.id.tv_logout)
        tv_logout!!.setOnClickListener(this)
        tv_mycollect = mView.findViewById(R.id.tv_mycollect)
        tv_mycollect!!.setOnClickListener(this)
        tv_mine = mView.findViewById(R.id.tv_mine)
        tv_mine!!.setOnClickListener(this)
    }

    override fun initData(bundle: Bundle?) {

    }

    override fun onClick(v: View?) {
        super.onClick(v)
        when(v!!.id){
            R.id.tv_login->IntentUntils.startToLogin(context)
        }
    }



    override fun getLayoutId(): Int= R.layout.fragment_mine

}