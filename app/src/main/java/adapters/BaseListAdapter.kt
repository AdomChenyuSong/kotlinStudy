package adapters

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.view.View
import android.widget.ImageView
import base.BaseListDataBean
import bean.HomeArticleBean
import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseViewHolder
import com.e.kotlinwanandroid.R
import untils.DateUtils
import untils.StringUtils

class BaseListAdapter(context: Context, data: List<BaseListDataBean>?) :
    BaseQuickItemClickAdapter<BaseListDataBean, BaseViewHolder>(context, R.layout.item_home_title, data) {
    override fun convert(helper: BaseViewHolder, item: BaseListDataBean) {
        helper.setText(R.id.tv_name,item.title)
        helper.setText(R.id.chapterName, item.chapterName)
            .setText(R.id.tv_name, item.author)
            .setText(R.id.tv_times, DateUtils.friendlyTime(DateUtils.parseDateTime(item.publishTime)))
            .setText(R.id.tv_title, StringUtils.deal(item.title!!))
        var view = helper.getView(R.id.img_banner) as ImageView
        if (StringUtils.isNullOrEmpty(item.envelopePic)) {
            view.setVisibility(View.GONE)
        } else {
            view.setVisibility(View.VISIBLE)
            Glide.with(view.getContext()).load(item.envelopePic).into(view)
        }
        if (item.isCollect) {
            helper.setImageResource(R.id.star, R.mipmap.ic_collection)
        } else {
            helper.setImageResource(R.id.star, R.mipmap.ic_collection_gray)
        }
        helper.addOnClickListener(R.id.star)

    }

}