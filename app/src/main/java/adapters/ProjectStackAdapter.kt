package adapters

import android.content.Context
import android.graphics.PorterDuff
import android.support.v4.content.ContextCompat
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import base.BaseListDataBean
import base.BaseObserver
import bean.ProjectTreeBean
import bean.ProjectsListBean
import com.e.kotlinwanandroid.R
import com.loopeer.cardstack.CardStackView
import com.loopeer.cardstack.StackAdapter
import conn.RxClient
import item.ListDeviderDecoration

class ProjectStackAdapter: StackAdapter<ProjectTreeBean> {

    constructor(mContext:Context) : super(mContext)

    companion object {
        val COLOR_DATAS:IntArray= intArrayOf( R.color.color_1,
            R.color.color_2,
            R.color.color_3,
            R.color.color_4,
            R.color.color_5,
            R.color.color_6,
            R.color.color_7,
            R.color.color_8,
            R.color.color_9,
            R.color.color_10,
            R.color.color_11,
            R.color.color_12,
            R.color.color_13,
            R.color.color_14,
            R.color.color_15,
            R.color.color_16,
            R.color.color_17,
            R.color.color_18,
            R.color.color_19,
            R.color.color_20,
            R.color.color_21,
            R.color.color_22,
            R.color.color_23,
            R.color.color_24,
            R.color.color_25)
    }
    override fun bindView(data: ProjectTreeBean, position: Int, holder: CardStackView.ViewHolder) {
        if (holder is ColorItemViewHolder) {
            holder.onBind(getmData(), data, position)
        }
    }

    override fun onCreateView(parent: ViewGroup, viewType: Int): CardStackView.ViewHolder {
        val view = layoutInflater.inflate(R.layout.item_list_card, parent, false)
        return ColorItemViewHolder(view)
    }

    override fun getItemViewType(position: Int): Int {
        return R.layout.item_list_card
    }

    internal class ColorItemViewHolder(view: View) : CardStackView.ViewHolder(view) {
        var mLayout: View
        var wx_recycleview: RecyclerView
        var mTextTitle: TextView
        var listData: List<ProjectTreeBean>? = null

        init {
            mLayout = view.findViewById(R.id.frame_list_card_item)
            wx_recycleview = view.findViewById(R.id.wx_recycleview)
            mTextTitle = view.findViewById(R.id.text_list_card_title)
        }

        fun initSet(childrenList: List<ProjectsListBean>) {
            val manager = LinearLayoutManager(wx_recycleview.context)
            wx_recycleview.layoutManager = manager
            val childenAdapter = BaseListAdapter(wx_recycleview.context,childrenList as List<BaseListDataBean>)
            wx_recycleview.addItemDecoration(ListDeviderDecoration(wx_recycleview.context))
            wx_recycleview.adapter = childenAdapter
        }

        override fun onItemExpand(b: Boolean, position: Int) {
            if (b) {
                val bean = listData!![position]
                RxClient.getProjectTreeList( bean.id)!!.subscribe( object :BaseObserver<List<ProjectsListBean>>(){
                        override fun onNext(value: List<ProjectsListBean>) {
                            initSet(value)
                        }
                })
            }
            wx_recycleview.visibility = if (b) View.VISIBLE else View.GONE
        }

        fun onBind(beanList: List<ProjectTreeBean>, data: ProjectTreeBean, position: Int) {
            if (listData == null) {
                listData = beanList
            }
            if (position < 25) {
                mLayout.background.setColorFilter(
                    ContextCompat.getColor(context, COLOR_DATAS[position]),
                    PorterDuff.Mode.SRC_IN
                )
            } else {
                mLayout.background.setColorFilter(
                    ContextCompat.getColor(context, COLOR_DATAS[15]),
                    PorterDuff.Mode.SRC_IN
                )
            }
            val temp = position + 1
            mTextTitle.text = temp.toString() + "." + data.name
        }

    }

}