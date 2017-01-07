package com.j1adong.huabankotlin.common

import android.view.ViewManager
import com.ashokvarma.bottomnavigation.BottomNavigationBar
import com.jess.arms.widget.KikkatStatusView
import org.jetbrains.anko.custom.ankoView

/**
 * anko中不能直接使用自定义的view，请在此类中进行声明
 *
 * Created by J1aDong on 2017/1/5.
 */
inline fun ViewManager.kikkatStatusView(theme: Int = 0) = kikkatStatusView(theme) {}

inline fun ViewManager.kikkatStatusView(theme: Int = 0, init: KikkatStatusView.() -> Unit) = ankoView({ KikkatStatusView(it) }, theme, init)

inline fun ViewManager.bottomNavigationBar(theme: Int = 0) = bottomNavigationBar(theme) {}

inline fun ViewManager.bottomNavigationBar(theme: Int = 0, init: BottomNavigationBar.() -> Unit) = ankoView({ BottomNavigationBar(it) }, theme, init)