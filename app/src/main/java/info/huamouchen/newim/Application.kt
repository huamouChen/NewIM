package info.huamouchen.newim

import android.support.multidex.MultiDexApplication
import io.rong.imlib.RongIMClient


/**
 * Created by Rex on 2018/4/11.
 * Email chenhm4444@gmail.com
 */
class Application : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()

        initRongCloud()
    }

//    override fun attachBaseContext(base: Context?) {
//        super.attachBaseContext(base)
//        MultiDex.install(this)
//    }


    /*
    * 初始化融云SDK
    * */
    fun initRongCloud() {
        RongIMClient.init(this)
    }
}