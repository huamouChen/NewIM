package info.huamouchen.newim.server.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import java.util.*

/**
 * Created by Rex on 2018/4/13.
 * Email chenhm4444@gmail.com
 */
class BroadcastManager {






    /*
    * 构造方法
    * */
    private fun BroadcastManager(context: Context) {
        mContext = context
        receiverMap = HashMap<String, BroadcastReceiver>()
    }

    lateinit var mContext : Context
    lateinit var instance : BroadcastManager
    lateinit var receiverMap: Map<String, BroadcastReceiver>
}