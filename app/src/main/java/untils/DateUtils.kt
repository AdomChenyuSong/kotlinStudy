package untils

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

/**
 * 描述：
 *
 * @author 周麟
 * @date 2018/5/27/027 14:09
 */
object DateUtils {
    private val formatDate = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    private val formatDateTime = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())

    /**
     * 格式化日期
     *
     * @param date date
     * @return 年-月-日
     */
    fun formatDate(date: Date): String {
        return formatDate.format(date)
    }

    /**
     * 格式化日期
     *
     * @param date date
     * @return 年-月-日 时:分:秒
     */
    fun formatDateTime(date: Date): String {
        return formatDateTime.format(date)
    }


    /**
     * 将时间戳解析成日期
     *
     * @param timeInMillis timeInMillis
     * @return 年-月-日 时:分:秒
     */
    fun parseDateTime(timeInMillis: Long): String {
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = timeInMillis
        val date = calendar.time
        return formatDateTime(date)
    }


    /**
     * 将年-月-日 时:分:秒 解析为Date
     *
     * @param datetime datetime
     * @return Date
     */
    private fun parseDateTime(datetime: String): Date? {
        var mDate: Date? = null
        try {
            mDate = formatDateTime.parse(datetime)
        } catch (e: ParseException) {
            e.printStackTrace()
        }

        return mDate
    }


    /**
     * 以友好的方式显示时间
     *
     * @param sdate sdate
     * @return String
     */
    fun friendlyTime(sdate: String): String {
        val time = parseDateTime(sdate) ?: return "Unknown"
        var ftime = ""
        val cal = Calendar.getInstance()

        // 判断是否是同一天
        val curDate = formatDate.format(cal.time)
        val paramDate = formatDate.format(time)
        if (curDate == paramDate) {
            val hour = ((cal.timeInMillis - time.time) / 3600000).toInt()
            if (hour == 0)
                ftime = Math.max(
                    (cal.timeInMillis - time.time) / 60000, 1
                ).toString() + "分钟前"
            else
                ftime = hour.toString() + "小时前"
            return ftime
        }

        val lt = time.time / 86400000
        val ct = cal.timeInMillis / 86400000
        val days = (ct - lt).toInt()
        if (days == 0) {
            val hour = ((cal.timeInMillis - time.time) / 3600000).toInt()
            if (hour == 0)
                ftime = Math.max(
                    (cal.timeInMillis - time.time) / 60000, 1
                ).toString() + "分钟前"
            else
                ftime = hour.toString() + "小时前"
        } else if (days == 1) {
            ftime = "昨天"
        } else if (days == 2) {
            ftime = "前天"
        } else if (days > 2 && days <= 10) {
            ftime = days.toString() + "天前"
        } else if (days > 10) {
            ftime = formatDate.format(time)
        }
        return ftime
    }

    /**
     * @param millis 要转化的毫秒数。
     * @return 返回时间字符串：小时/分/秒/毫秒的格式（如：24903600 --> 06小时55分钟）。
     */
    fun millisToStringShort(millis: Long): String {
        var h: String
        var m: String
        h = "00小时"
        m = "00分钟"
        var temp = millis
        val hper = (60 * 60 * 1000).toLong()
        val mper = (60 * 1000).toLong()
        if (temp / hper > 0) {
            h = if (temp / hper < 10) "0" + temp / hper else (temp / hper).toString() + ""
            h += "小时"
        }
        temp = temp % hper
        if (temp / mper > 0) {
            m = if (temp / mper < 10) "0" + temp / mper else (temp / mper).toString() + ""
            m += "分钟"
        }
        return h + m
    }
}
