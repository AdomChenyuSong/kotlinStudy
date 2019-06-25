package activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.e.kotlinwanandroid.R
import io.reactivex.Observable
import untils.IntentUntils
import java.util.concurrent.TimeUnit

class SplashActivity :AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_splash)
        Observable.timer(2,TimeUnit.SECONDS).subscribe{
            IntentUntils.startToMain(this)
            finish()

        }

    }
}
