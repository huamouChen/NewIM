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
 * 发现fragment，这个fragment的功能还没确定，暂时叫发现fragment
 */
class DiscoverFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val contentView : View = inflater.inflate(R.layout.fragment_discover, container, false)
        return contentView
    }
}