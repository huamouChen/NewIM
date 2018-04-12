package info.huamouchen.newim.ui.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import info.huamouchen.newim.R


/**
 * Created by Rex on 2018/4/12.
 * Email chenhm4444@gmail.com
 */
class GuideActivity : Activity(), View.OnClickListener {

    /*
    * 点击事件
    * */
    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_login -> gotoLoginActivity()

            R.id.btn_register -> gotoRegisterActivity()
        }
    }

    /*
    * 跳转到登录界面
    * */
    private fun gotoLoginActivity() {
        var intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }

    /*
    * 跳转到注册界面
    * */
    private fun gotoRegisterActivity() {
        var intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)
    }


    /*
    * life cycler
    * */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guide)

        initView()
    }

    /*
    * 初始化控件
    * */
    private fun initView() {
        longin_btn = findViewById(R.id.btn_login) as Button
        longin_btn!!.setOnClickListener(this)
        register_btn = findViewById(R.id.btn_register)
        register_btn!!.setOnClickListener(this)

    }

    var longin_btn: Button? = null
    var register_btn: Button? = null
}



