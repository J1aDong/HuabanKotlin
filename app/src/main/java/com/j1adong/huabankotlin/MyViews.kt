package com.j1adong.huabankotlin

import android.view.ViewManager
import com.jess.arms.widget.KikkatStatusView
import org.jetbrains.anko.custom.ankoView

/**
 * Created by J1aDong on 2017/1/5.
 */
inline fun ViewManager.kikkatStatusView(theme: Int = 0) = kikkatStatusView(theme) {}
inline fun ViewManager.kikkatStatusView(theme: Int = 0, init: KikkatStatusView.() -> Unit) = ankoView({ KikkatStatusView(it) }, theme, init)