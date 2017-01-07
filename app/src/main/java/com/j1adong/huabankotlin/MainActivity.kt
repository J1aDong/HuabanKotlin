package com.j1adong.huabankotlin

import android.content.Intent
import android.view.View
import com.j1adong.huabankotlin.common.WEActivity
import com.j1adong.huabankotlin.di.component.AppComponent
import com.j1adong.huabankotlin.mvp.contract.HomeContract
import com.j1adong.huabankotlin.mvp.presenter.HomePresenter
import org.jetbrains.anko.*

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
        Injection.inject(appComponent, this, this)
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
                kikkatStatusView()

                relativeLayout {

                    textView {
                        textResource = R.string.hello
                    }
                    button {
                        id = R.id.btn_next
                        hintResource = R.string.hello
                    }
                }
            }
        }

        companion object Factory {
            val ID_ROOT = 101
        }

    }
}
