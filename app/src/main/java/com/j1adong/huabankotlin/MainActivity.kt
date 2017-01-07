package com.j1adong.huabankotlin

import android.content.Intent
import android.view.View
import com.ashokvarma.bottomnavigation.BottomNavigationBar
import com.ashokvarma.bottomnavigation.BottomNavigationBar.*
import com.ashokvarma.bottomnavigation.BottomNavigationItem
import com.j1adong.huabankotlin.common.InjectionHeader
import com.j1adong.huabankotlin.common.WEActivity
import com.j1adong.huabankotlin.common.bottomNavigationBar
import com.j1adong.huabankotlin.common.kikkatStatusView
import com.j1adong.huabankotlin.di.component.AppComponent
import com.j1adong.huabankotlin.mvp.contract.HomeContract
import com.j1adong.huabankotlin.mvp.presenter.HomePresenter
import org.jetbrains.anko.*
import org.jetbrains.anko.support.v4.viewPager

class MainActivity : WEActivity<HomePresenter>(), HomeContract.View {
    override fun showLoading() {
    }

    override fun hideLoading() {
    }

    override fun showMessage(message: String?) {
    }

    override fun launchActivity(intent: Intent?) {
    }

    override fun killMyself() {
        finish()
    }

    override fun setupActivityComponent(appComponent: AppComponent?) {
        InjectionHeader.inject(appComponent, this, this)
    }

    override fun initView(): View {
        val view = MainActivityUI().setContentView(this)
        AutoLayout.auto(view)
        return view
    }

    override fun initData() {
    }

    class MainActivityUI : AnkoComponent<MainActivity> {

        override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
            verticalLayout {
                id = ID_ROOT
                kikkatStatusView {
                    backgroundColor = R.color.grey
                }

                viewPager {
                }.lparams(width = matchParent, height = 0, weight = 1f) {

                }

                bottomNavigationBar {
                    setMode(MODE_FIXED)
                    setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC)
                    addItem(BottomNavigationItem(R.mipmap.ic_tab_home_a, "").setInactiveIconResource(R.mipmap.ic_tab_home_b))
                    addItem(BottomNavigationItem(R.mipmap.ic_tab_explore_a, "").setInactiveIconResource(R.mipmap.ic_tab_explore_b))
                    addItem(BottomNavigationItem(R.mipmap.ic_tab_news_a, "").setInactiveIconResource(R.mipmap.ic_tab_news_b))
                    addItem(BottomNavigationItem(R.mipmap.ic_tab_mine_a, "").setInactiveIconResource(R.mipmap.ic_tab_mine_b))
                    initialise()
                }.lparams(width = matchParent, height = wrapContent) {
                }
            }
        }

        companion object Factory {
            val ID_ROOT = 101
            val ID_BOTTOMBAR = 102
        }

    }
}
