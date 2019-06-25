package bean

import android.os.Parcel
import android.os.Parcelable

class HomeBannerBean() : Parcelable {

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest!!.writeString(desc)
        dest!!.writeInt(id)
        dest!!.writeString(imagePath)
        dest!!.writeInt(isVisible)
        dest!!.writeInt(order)
        dest!!.writeString(title)
        dest!!.writeInt(type)
        dest!!.writeString(url)
    }

    override fun describeContents(): Int {
      return 0
    }

    /**
     * desc : 一起来做个App吧
     * id : 10
     * imagePath : https://www.wanandroid.com/blogimgs/50c115c2-cf6c-4802-aa7b-a4334de444cd.png
     * isVisible : 1
     * order : 1
     * title : 一起来做个App吧
     * type : 0
     * url : http://www.wanandroid.com/blog/show/2
     */

    var desc: String? = null
    var id: Int = 0
    var imagePath: String? = null
    var isVisible: Int = 0
    var order: Int = 0
    var title: String? = null
    var type: Int = 0
    var url: String? = null

    constructor(parcel: Parcel) : this() {
        desc = parcel.readString()
        id = parcel.readInt()
        imagePath = parcel.readString()
        isVisible = parcel.readInt()
        order = parcel.readInt()
        title = parcel.readString()
        type = parcel.readInt()
        url = parcel.readString()
    }

    companion object CREATOR : Parcelable.Creator<HomeBannerBean> {
        override fun createFromParcel(parcel: Parcel): HomeBannerBean {
            return HomeBannerBean(parcel)
        }

        override fun newArray(size: Int): Array<HomeBannerBean?> {
            return arrayOfNulls(size)
        }
    }
}
