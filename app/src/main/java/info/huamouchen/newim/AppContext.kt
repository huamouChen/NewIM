package info.huamouchen.newim

import io.rong.imlib.RongIMClient


/**
 * Created by Rex on 2018/4/12.
 * Email chenhm4444@gmail.com
 */
class AppContext  {





    class RongConnectCallback : RongIMClient.ConnectCallback() {
        override fun onTokenIncorrect() {
            println("-------------------onTokenIncorrect")
        }

        override fun onSuccess(p0: String?) {
            println("-------------------onSuccess")
        }

        override fun onError(p0: RongIMClient.ErrorCode?) {
            println("-------------------onError")
        }
    }
}