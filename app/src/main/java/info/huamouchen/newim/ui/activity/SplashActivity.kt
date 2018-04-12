package info.huamouchen.newim.ui.activity

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.Window
import info.huamouchen.newim.Constant
import info.huamouchen.newim.R
import io.rong.imlib.RongIMClient

/**
 * Created by Rex on 2018/4/11.
 * Email chenhm4444@gmail.com
 */
class SplashActivity : Activity() {

    val mHandler = Handler()

    // 延迟进入界面的时长
    val delayMillis: Long = 800


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_splash)

        switchRootActivity()
    }

    /*
    * 切换根activity
    * */
    private fun switchRootActivity() {
        // 从本地取 token，如果token不为空就是登陆过了，然后进入MainActivity，否则进入GuideActivity
        val sp = getSharedPreferences(Constant().SharedPreferencesName, Context.MODE_PRIVATE)
        sp.edit().putString(Constant().Rong_Token, "").apply()
        val rong_token = sp.getString(Constant().Rong_Token, "")
        if (rong_token.isEmpty()) { // token 为空
            mHandler.postDelayed({
                kotlin.run {
                    gotoGuideActivity()
                }
            }, delayMillis)
        } else {    // token 不为空，进入的时候，要连接融云的服务器
            // TODO("如果登录了，进入主界面的时候应该要连接融云的服务器，这里还没有连接")
            RongIMClient.connect(rong_token, null)
            mHandler.postDelayed({
                kotlin.run {
                    gotoMainActivity()
                }
            }, delayMillis)
        }
    }


    /*
    * 还没有登录，进入引导界面
    * */
    private fun gotoGuideActivity() {
        val intent = Intent(this, GuideActivity::class.java)
        startActivity(intent)
    }

    /*
    * 已经登录了，进入主界面
    * */
    private fun gotoMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

}