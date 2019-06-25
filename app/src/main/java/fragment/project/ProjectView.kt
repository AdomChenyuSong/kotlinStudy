package fragment.project

import bean.ProjectTreeBean
import bean.ProjectsListBean
import mvp.BaseMvpView

interface ProjectView: BaseMvpView{
     fun updataChapterList(value: List<ProjectTreeBean>)
}