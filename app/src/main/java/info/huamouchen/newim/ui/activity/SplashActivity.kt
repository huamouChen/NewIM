package info.huamouchen.newim.ui.activity

import android.app.Activity
import android.os.Bundle
import android.view.Window
import info.huamouchen.newim.R

/**
 * Created by Rex on 2018/4/11.
 * Email chenhm4444@gmail.com
 */
class SplashActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_splash)
    }
}