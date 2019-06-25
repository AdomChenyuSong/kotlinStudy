package base

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewStub
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import com.e.kotlinwanandroid.R
import mvp.BaseMvpView

abstract class BaseFragment:Fragment(),BaseMvpView,View.OnClickListener{
    private var fl_container: FrameLayout? = null
    private var img_no_data: ImageView? = null
    private var iv_base_hint_page_icon: ImageView? = null
    private var viewstub_no_data: ViewStub? = null
    private var viewstub_error_page: ViewStub? = null
    /**
     * 设置无数据资源
     * @param img_no_data_rescoure
     */
    var img_no_data_rescoure: Int = 0
    /**
     * 设置错误资源
     * @return
     */
    var img_error_rescoure: Int = 0
    private var ll_base_error_content: LinearLayout? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val inflate = inflater.inflate(R.layout.base_fragment, null, false)
        initBaseView(inflate)
        addInfateContentView(inflater)
        initView(inflate)
        var bundle=arguments
        if (bundle==null){
            bundle=savedInstanceState
        }
        initData(bundle)
        return inflate
    }
    private fun addInfateContentView(inflate:LayoutInflater){
        val contentView=inflate.inflate(getLayoutId(),null,false)
        fl_container!!.addView(contentView)
    }
    abstract fun initView(views:View)
    abstract fun initData(bundle:Bundle?)
    abstract fun getLayoutId():Int
    /**
     * 初始化
     * @param mView
     */
    private fun initBaseView(mView: View) {
        ll_base_error_content = mView.findViewById(R.id.ll_base_error_content)
        fl_container = mView.findViewById(R.id.fl_container)
        img_no_data = mView.findViewById(R.id.img_no_data)
        iv_base_hint_page_icon = mView.findViewById(R.id.iv_base_hint_page_icon)
        viewstub_no_data = mView.findViewById(R.id.viewstub_no_data)
        viewstub_error_page = mView.findViewById(R.id.viewstub_error_page)
        viewstub_error_page!!.setOnClickListener(this)
        if (img_error_rescoure > 0) {
            iv_base_hint_page_icon!!.setImageResource(img_error_rescoure)
        }
        if (img_no_data_rescoure > 0) {
            img_no_data!!.setImageResource(img_no_data_rescoure)
        }
    }
    override fun dismissDialog() {
    }

    override fun showEmptyData() {
    }

    override fun showError(msg: String?) {
    }

    override fun showLoading() {
    }

    override fun getContext(): Context {
        return activity!!;
    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.viewstub_error_page -> Log.e("SCY"," - - - ")
        }
    }

}
