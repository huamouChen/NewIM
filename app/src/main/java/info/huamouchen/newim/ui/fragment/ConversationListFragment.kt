package info.huamouchen.newim.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import info.huamouchen.newim.R

/**
 * Created by Rex on 2018/4/13.
 * Email chenhm4444@gmail.com
 * 会话列表fragment
 */
class ConversationListFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val contentView : View = inflater.inflate(R.layout.fragment_conversation_list, container, false)
        return contentView
    }
}