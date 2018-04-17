package info.huamouchen.newim.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import info.huamouchen.newim.R
import info.huamouchen.newim.ui.adapter.MyChatroomAdapter

/**
 * Created by Rex on 2018/4/13.
 * Email chenhm4444@gmail.com
 * 发现fragment，这个fragment的功能还没确定，暂时叫发现fragment
 */
class DiscoverFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val contentView : View = inflater.inflate(R.layout.fragment_discover, container, false)
        initView(contentView)
        return contentView
    }

    private fun initView(view : View) {
        mRecyclerView = view.findViewById(R.id.recycler_view_chatroom)
        var list : List<String> = listOf("聊天室Ⅰ","聊天室Ⅱ","聊天室Ⅲ","聊天室Ⅳ","聊天室Ⅴ","聊天室Ⅵ")
        mRecyclerView.layoutManager = LinearLayoutManager(context)
        mRecyclerView.adapter = MyChatroomAdapter(context!!, list)
    }


    lateinit var mRecyclerView : RecyclerView
}