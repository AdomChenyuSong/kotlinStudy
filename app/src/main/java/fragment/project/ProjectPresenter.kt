package fragment.project

import android.util.Log
import base.BaseObserver
import bean.ProjectTreeBean
import bean.ProjectsListBean
import conn.RxClient
import mvp.BaseMvpPresenter

class ProjectPresenter : BaseMvpPresenter<ProjectView>() {
    fun getProjectListData(){
        RxClient.getProjectList()!!.subscribe(object : BaseObserver<List<ProjectTreeBean>>() {
            override fun onNext(value: List<ProjectTreeBean>) {
                super.onNext(value)
                view!!.updataChapterList(value)
            }
        })
    }
}