package com.j1adong.huabankotlin

import com.j1adong.huabankotlin.common.WEApplication
import com.zhy.autolayout.config.AutoLayoutConifg

/**
 * Created by J1aDong on 2017/1/6.
 */
class MyApplication : WEApplication() {

    override fun onCreate() {
        super.onCreate()
        AutoLayoutConifg.getInstance().useDeviceSize()
    }
}