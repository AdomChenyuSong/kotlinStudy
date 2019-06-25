package imageloader

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.e.kotlinwanandroid.R

/**
 * ImageLoader
 *
 * @author 周麟
 * @created 2018/1/4 11:20
 */
object ImageLoader {
    fun displayImage(iv: ImageView, url: String) {
        val options = RequestOptions()
            .placeholder(R.color.md_grey_300)
            .error(R.color.md_grey_300)
            .diskCacheStrategy(DiskCacheStrategy.DATA)
        Glide.with(iv.context).load(url).apply(options).into(iv)
    }
}