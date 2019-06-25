package untils

import android.graphics.Color
import android.text.SpannableString
import android.text.style.ForegroundColorSpan

/**
 * StringUtils
 *
 * @author 周麟
 * @created 2018/1/4 11:23
 */
object StringUtils {

    fun isNullOrEmpty(s: String?): Boolean {
        return s == null || s.length == 0
    }

    /**
     * 使用java正则表达式去掉多余的.与0
     */
    fun subZeroAndDot(s: String): String {
        var s = s
        if (s.indexOf(".") > 0) {
            //去掉多余的0
            s = s.replace("0+?$".toRegex(), "")
            //如最后一位是.则去掉
            s = s.replace("[.]$".toRegex(), "")
        }
        return s
    }

    fun deal(title: String): SpannableString {
        var title = title
        val keyStart = "<em class='highlight'>"
        val keyEnd = "</em>"
        if (!title.contains(keyStart) && !title.contains(keyEnd)) {
            return SpannableString(title)
        }
        val start = title.indexOf(keyStart)
        val end = title.indexOf(keyEnd) - keyStart.length
        title = title.replace(keyStart, "")
        title = title.replace(keyEnd, "")
        val sb = SpannableString(title)
        sb.setSpan(
            ForegroundColorSpan(Color.parseColor("#F44336")),
            start,
            end,
            SpannableString.SPAN_INCLUSIVE_INCLUSIVE
        )
        return sb
    }
}
