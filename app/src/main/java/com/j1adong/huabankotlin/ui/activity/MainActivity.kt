package com.j1adong.huabankotlin.ui.activity

import android.os.Bundle
import android.view.View
import com.ashokvarma.bottomnavigation.BottomNavigationBar
import com.ashokvarma.bottomnavigation.BottomNavigationItem
import com.j1adong.huabankotlin.R
import com.j1adong.huabankotlin.common.InjectionHeader
import com.j1adong.huabankotlin.common.WEActivity
import com.j1adong.huabankotlin.di.component.AppComponent
import com.j1adong.huabankotlin.event.EventConstant
import com.j1adong.huabankotlin.event.EventString
import com.j1adong.huabankotlin.mvp.contract.HomeActivityContract
import com.j1adong.huabankotlin.mvp.presenter.HomePresenter
import com.j1adong.huabankotlin.ui.activity.MainActivity.MainActivityUI.Factory.ID_BOTTOMBAR
import com.j1adong.huabankotlin.ui.bottomNavigationBar
import com.j1adong.huabankotlin.ui.fragment.ExploreFragment
import com.j1adong.huabankotlin.ui.fragment.HomeFragment
import com.j1adong.huabankotlin.ui.fragment.MineFragment
import com.j1adong.huabankotlin.ui.fragment.NewsFragment
import com.jess.arms.utils.EventBus
import com.jess.arms.widget.fragmention.SupportFragment
import com.socks.library.KLog
import com.squareup.otto.Subscribe
import org.jetbrains.anko.*

class MainActivity : WEActivity<HomePresenter>(), HomeActivityContract.View {
    val FIRST = 0

    val SECOND = 1
    val THIRD = 2
    val FOURTH = 3
    private val mFragments = arrayOfNulls<SupportFragment>(4)
    var isShow: Boolean = true
    var mBottomBar: BottomNavigationBar? = null

    private var prePosition: Int = 0

    override fun findViews() {
        mBottomBar = find<BottomNavigationBar>(id = ID_BOTTOMBAR)
    }

    @Subscribe
    fun receiveEvent(event: EventString) {
        if (event.tag == EventConstant.HIDE_TOOLBAR) {
            if (isShow) {
                mBottomBar?.hide(true)
                isShow = false
            }
        } else if (event.tag == EventConstant.SHOW_TOOLBAR) {
            if (!isShow) {
                mBottomBar?.show(true)
                isShow = true
            }
        }
    }

    override fun loadFragment(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            mFragments[FIRST] = HomeFragment.newInstance()
            mFragments[SECOND] = ExploreFragment.newInstance()
            mFragments[THIRD] = NewsFragment.newInstance()
            mFragments[FOURTH] = MineFragment.newInstance()

            loadMultipleRootFragment(R.id.fl_container, FIRST,
                    mFragments[FIRST],
                    mFragments[SECOND],
                    mFragments[THIRD],
                    mFragments[FOURTH])
        } else {
            // 这里库已经做了Fragment恢复,所有不需要额外的处理了, 不会出现重叠问题

            // 这里我们需要拿到mFragments的引用,也可以通过getSupportFragmentManager.getFragments()自行进行判断查找(效率更高些),用下面的方法查找更方便些
            mFragments[FIRST] = findFragment(HomeFragment::class.java)
            mFragments[SECOND] = findFragment(ExploreFragment::class.java)
            mFragments[THIRD] = findFragment(NewsFragment::class.java)
            mFragments[FOURTH] = findFragment(MineFragment::class.java)
        }

    }

    override fun showLoading() {
    }

    override fun hideLoading() {
    }

    override fun showMessage(message: String?) {

    }

    override fun killMyself() {
        finish()
    }

    override fun setupActivityComponent(appComponent: AppComponent?) {
        InjectionHeader.inject(appComponent, this)
    }

    override fun initView(): View {
        val view = MainActivityUI().setContentView(this)
        return view
    }

    override fun initData() {

        mBottomBar?.setTabSelectedListener(object : BottomNavigationBar.OnTabSelectedListener {
            override fun onTabReselected(position: Int) {
                KLog.w(position)
                if (position == 0) {
                    EventBus.getDefault().post(EventString(EventConstant.REFRESH_ALL_EVENT))
                }
            }

            override fun onTabUnselected(position: Int) {
            }

            override fun onTabSelected(position: Int) {
                showHideFragment(mFragments[position], mFragments[prePosition])
                prePosition = position
            }
        })
    }

    class MainActivityUI : AnkoComponent<MainActivity> {

        override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
            relativeLayout {
                id = ID_ROOT

                frameLayout {
                    id = R.id.fl_container
                }

                bottomNavigationBar {
                    id = ID_BOTTOMBAR
                    setMode(BottomNavigationBar.MODE_FIXED)
                    setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC)
                    addItem(BottomNavigationItem(R.mipmap.ic_tab_home_a, "").setInactiveIconResource(R.mipmap.ic_tab_home_b))
                    addItem(BottomNavigationItem(R.mipmap.ic_tab_explore_a, "").setInactiveIconResource(R.mipmap.ic_tab_explore_b))
                    addItem(BottomNavigationItem(R.mipmap.ic_tab_news_a, "").setInactiveIconResource(R.mipmap.ic_tab_news_b))
                    addItem(BottomNavigationItem(R.mipmap.ic_tab_mine_a, "").setInactiveIconResource(R.mipmap.ic_tab_mine_b))
                    initialise()
                }.lparams(width = matchParent, height = wrapContent) {
                    bottomMargin = -30
                    alignParentBottom()
                }
            }
        }

        companion object Factory {
            val ID_ROOT = 101
            val ID_BOTTOMBAR = 102
            val ID_VIEWPAGER = 103
        }
    }

}
