package com.j1adong.huabankotlin.ui.activity

import android.os.Bundle
import android.view.View
import com.j1adong.huabankotlin.R
import com.j1adong.huabankotlin.common.InjectionHeader
import com.j1adong.huabankotlin.common.WEActivity
import com.j1adong.huabankotlin.di.component.AppComponent
import com.j1adong.huabankotlin.mvp.contract.HomeActivityContract
import com.j1adong.huabankotlin.mvp.presenter.HomePresenter
import com.j1adong.huabankotlin.ui.fragment.MainFragment
import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.frameLayout
import org.jetbrains.anko.setContentView

class MainActivity : WEActivity<HomePresenter>(), HomeActivityContract.View {
    override fun loadFragment(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            loadRootFragment(R.id.fl_container, MainFragment.newInstance())
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

    }

    class MainActivityUI : AnkoComponent<MainActivity> {

        override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
            frameLayout {
                id = R.id.fl_container
            }
        }

    }
}
