package info.huamouchen.newim

import android.app.Application
import android.content.Context
import io.rong.imlib.RongIMClient

/**
 * Created by Rex on 2018/4/11.
 * Email chenhm4444@gmail.com
 */
class Application : Application() {

    override fun onCreate() {
        super.onCreate()

        initRongCloud()
    }


    /*
    * 初始化融云SDK
    * */
    fun initRongCloud() {
        RongIMClient.init(applicationContext)
    }
}