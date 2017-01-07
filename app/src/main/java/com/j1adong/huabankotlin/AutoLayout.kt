package com.j1adong.huabankotlin

import android.view.View
import android.view.ViewGroup
import com.zhy.autolayout.utils.AutoUtils

/**
 * Created by J1aDong on 2017/1/6.
 */
class AutoLayout {
    companion object {
        fun auto(view: View): View {
            if (view is ViewGroup) {
                for (i in 0..view.childCount - 1) {
                    auto(view.getChildAt(i))
                }
            }
            AutoUtils.auto(view)
            return view
        }
    }
}