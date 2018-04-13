package info.huamouchen.newim.ui.activity

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import android.view.View
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import info.huamouchen.newim.Constants
import info.huamouchen.newim.R
import info.huamouchen.newim.ui.fragment.ContactsFragment
import info.huamouchen.newim.ui.fragment.ConversationListFragment
import info.huamouchen.newim.ui.fragment.DiscoverFragment
import info.huamouchen.newim.ui.fragment.MineFragment
import info.huamouchen.newim.ui.widget.DragPointView
import java.util.*

/**
 * Created by Rex on 2018/4/12.
 * Email chenhm4444@gmail.com
 */
class MainActivity : FragmentActivity(), View.OnClickListener, ViewPager.OnPageChangeListener {

    /*
    * viewPager 滑动状态改变监听
    * */
    override fun onPageScrollStateChanged(state: Int) {}
    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}
    override fun onPageSelected(position: Int) {
        changeTextViewColor()
        changeSelectedTabState(position)
    }

    /*
    * 点击事件
    * */
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.seal_chat ->
                mViewPager?.setCurrentItem(0, false)
            R.id.seal_contact_list ->
                mViewPager?.setCurrentItem(1, false)
            R.id.seal_find ->
                mViewPager?.setCurrentItem(2, false)
            R.id.seal_me -> {
                mViewPager?.setCurrentItem(3, false)
                mRedImg?.visibility = View.GONE
            }
            R.id.seal_more -> {
            }
            R.id.ac_iv_search -> {
            }
        }
    }

    /*
    * 绑定控件
    * */
    private fun initViews() {
        // tabBar 根布局
        var chatRLayout = findViewById<RelativeLayout>(R.id.seal_chat)
        var contactRLayout = findViewById<RelativeLayout>(R.id.seal_contact_list)
        var discoverRLayout = findViewById<RelativeLayout>(R.id.seal_find)
        var mineRLayout = findViewById<RelativeLayout>(R.id.seal_me)
        chatRLayout.setOnClickListener(this)
        contactRLayout.setOnClickListener(this)
        discoverRLayout.setOnClickListener(this)
        mineRLayout.setOnClickListener(this)

        // tabBar item
        mChatsImg = findViewById(R.id.tab_img_chats)
        mContactsImg = findViewById(R.id.tab_img_contact)
        mDiscoverImg = findViewById(R.id.tab_img_find)
        mMineImg = findViewById(R.id.tab_img_me)
        mChatsText = findViewById(R.id.tab_text_chats)
        mContatsText = findViewById(R.id.tab_text_contact)
        mDiscoverText = findViewById(R.id.tab_text_find)
        mMineText = findViewById(R.id.tab_text_me)


        mRedImg = findViewById(R.id.mine_red)
        mMoreImg = findViewById(R.id.seal_more)
        mSearchImg = findViewById(R.id.ac_iv_search)
    }

    /*
    * 点击 tab item 更换字体颜色
    * */
    private fun changeTextViewColor() {
        mChatsImg?.setBackgroundDrawable(getDrawable(R.mipmap.tab_chat))
        mContactsImg?.setBackgroundDrawable(getDrawable(R.mipmap.tab_contacts))
        mDiscoverImg?.setBackgroundDrawable(getDrawable(R.mipmap.tab_found))
        mMineImg?.setBackgroundDrawable(getDrawable(R.mipmap.tab_me))
        mChatsText?.setTextColor(resources.getColor(R.color.tab_item_normal))
        mContatsText?.setTextColor(resources.getColor(R.color.tab_item_normal))
        mDiscoverText?.setTextColor(resources.getColor(R.color.tab_item_normal))
        mMineText?.setTextColor(resources.getColor(R.color.tab_item_normal))
    }

    /*
    * 点击 tab item 更换图标
    * */
    private fun changeSelectedTabState(position: Int) {
        when (position) {
            0 -> {
                mChatsImg?.setBackgroundResource(R.mipmap.tab_chat_hover)
                mChatsText?.setTextColor(resources.getColor(R.color.tab_item_selected))
            }
            1 -> {
                mContactsImg?.setBackgroundResource(R.mipmap.tab_contacts_hover)
                mContatsText?.setTextColor(resources.getColor(R.color.tab_item_selected))
            }
            2 -> {
                mDiscoverImg?.setBackgroundResource(R.mipmap.tab_found_hover)
                mDiscoverText?.setTextColor(resources.getColor(R.color.tab_item_selected))
            }
            3 -> {
                mMineImg?.setBackgroundResource(R.mipmap.tab_me_hover)
                mMineText?.setTextColor(resources.getColor(R.color.tab_item_selected))
            }

        }
    }

    /*
    * 初始化 viewPager
    * */
    private fun initMainViewPager() {
        mViewPager = findViewById(R.id.main_viewpager)
        val fragmentList = listOf(ConversationListFragment(), ContactsFragment(), DiscoverFragment(), MineFragment())

        mViewPager?.adapter = ViewPagerAdapter(supportFragmentManager, fragmentList)
        mViewPager?.offscreenPageLimit = fragmentList.size
        mViewPager?.setOnPageChangeListener(this)
    }

    //继承 FragmentPagerAdapter 创建适配器
    class ViewPagerAdapter(fm: FragmentManager?, var list: List<Fragment>) : FragmentPagerAdapter(fm) {
        override fun getItem(position: Int): Fragment {
            return list.get(position)
        }

        override fun getCount(): Int {
            return list.size
        }
    }

    /*
    * liffe cycler
    * */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mContext = this
        isDebug = getSharedPreferences(Constants().SharedPreferencesName, Context.MODE_PRIVATE).getBoolean(Constants().IsDebug, false)
        initViews()
        changeTextViewColor()
        changeSelectedTabState(0)
        initMainViewPager()
    }


    lateinit var mContext: Context
    var isDebug = false

     var mViewPager: ViewPager? = null
     var mChatsImg: ImageView? = null
     var mContactsImg: ImageView? = null
     var mDiscoverImg: ImageView? = null
     var mMineImg: ImageView? = null
     var mMoreImg: ImageView? = null       // 加号Img
     var mRedImg: ImageView? = null        // 我的红点

     var mChatsText: TextView? = null
     var mContatsText: TextView? = null
     var mDiscoverText: TextView? = null
     var mMineText: TextView? = null
     var mSearchImg: ImageView? = null         // 搜索image
     var mUnreadNumView: DragPointView? = null // 未读消息红点

}