package mvp

import android.content.Context

interface BaseMvpView{
    /**
     * 显示弹窗
     */
    fun showLoading()

    /**
     * 关闭弹窗
     */
    fun dismissDialog()

    /**
     * 获取context
     */
    fun getContext():Context

    /**
     * 提示错误信息
     */
    fun showError(msg:String?)

    /**
     * 无数据界面
     */
    fun showEmptyData()

}