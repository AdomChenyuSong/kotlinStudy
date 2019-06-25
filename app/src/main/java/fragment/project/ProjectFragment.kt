package fragment.project

import adapters.ProjectStackAdapter
import android.os.Bundle
import android.view.View
import bean.ProjectTreeBean
import com.e.kotlinwanandroid.R
import com.loopeer.cardstack.CardStackView
import mvp.BaseMvpFragment

class ProjectFragment :BaseMvpFragment<ProjectView,ProjectPresenter>(),ProjectView,CardStackView.ItemExpendListener{
    var projectStackAdapter:ProjectStackAdapter?=null
    override fun onItemExpend(expend: Boolean) {
    }

    override fun updataChapterList(value: List<ProjectTreeBean>) {
        projectStackAdapter!!.updateData(value)
    }

    var projectPresenter=ProjectPresenter()
    lateinit var fragment_cardStackView: CardStackView
    override fun initPresenter(): ProjectPresenter=projectPresenter

    override fun initView(views: View) {
        fragment_cardStackView=views.findViewById(R.id.fragment_cardStackView)
        fragment_cardStackView.itemExpendListener=this
        projectStackAdapter= ProjectStackAdapter(context)
        fragment_cardStackView.setAdapter(projectStackAdapter)
    }

    override fun initData(bundle: Bundle?) {
        projectPresenter.getProjectListData()
    }

    override fun getLayoutId(): Int = R.layout.fragment_project

}