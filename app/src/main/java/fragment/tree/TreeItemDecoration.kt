package fragment.tree

import android.content.Context
import android.graphics.*
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.text.TextPaint
import android.text.TextUtils
import android.view.View
import com.e.kotlinwanandroid.R

class TreeItemDecoration(context: Context, private val callback: DecorationCallback) : RecyclerView.ItemDecoration() {
    private val textPaint: TextPaint
    private val paint: Paint
    private val topGap: Int
    private val fontMetrics: Paint.FontMetrics


    init {
        val res = context.resources
        paint = Paint()
        paint.color = ContextCompat.getColor(context, R.color.tag_bd_red)
        textPaint = TextPaint()
        textPaint.typeface = Typeface.DEFAULT_BOLD
        textPaint.isAntiAlias = true
        textPaint.textSize = context.resources.getDimensionPixelSize(R.dimen.text_size_16).toFloat()
        textPaint.color = Color.WHITE
        textPaint.textAlign = Paint.Align.LEFT
        fontMetrics = Paint.FontMetrics()
        textPaint.getFontMetrics(fontMetrics)
        topGap = res.getDimensionPixelSize(R.dimen.sectioned_top)
    }


    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        super.getItemOffsets(outRect, view, parent, state)
        val pos = parent.getChildAdapterPosition(view)
        val groupId = callback.getGroupId(pos)
        if (groupId < 0) {
            return
        }
        if (pos == 0 || isFirstInGroup(pos)) {
            outRect.top = topGap
        } else {
            outRect.top = 0
        }
    }

    override fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDrawOver(c, parent, state)
        val itemCount = state.itemCount
        val childCount = parent.childCount
        val left = parent.paddingLeft
        val right = parent.width - parent.paddingRight
        var preGroupId: Long
        var groupId: Long = -1
        for (i in 0 until childCount) {
            val view = parent.getChildAt(i)
            val position = parent.getChildAdapterPosition(view)
            preGroupId = groupId
            groupId = callback.getGroupId(position)
            if (groupId < 0 || groupId == preGroupId) {
                continue
            }

            val textLine = callback.getGroupFirstLine(position).toUpperCase()
            if (TextUtils.isEmpty(textLine)) {
                continue
            }
            val viewBottom = view.bottom
            var textY = Math.max(topGap, view.top).toFloat()
            if (position + 1 < itemCount) {
                //下一个和当前不一样移动当前
                val nextGroupId = callback.getGroupId(position + 1)
                if (nextGroupId != groupId && viewBottom < textY) {
                    //组内最后一个view进入了header
                    textY = viewBottom.toFloat()
                }
            }
            c.drawRect(left.toFloat(), textY - topGap, right.toFloat(), textY, paint)
            c.drawText(textLine, (left + 20).toFloat(), textY - 24, textPaint)
        }
    }

    private fun isFirstInGroup(pos: Int): Boolean {
        if (pos == 0) {
            return true
        } else {
            val prevGroupId = callback.getGroupId(pos - 1)
            val groupId = callback.getGroupId(pos)
            return prevGroupId != groupId
        }
    }

    interface DecorationCallback {

        fun getGroupId(position: Int): Long

        fun getGroupFirstLine(position: Int): String
    }
}
