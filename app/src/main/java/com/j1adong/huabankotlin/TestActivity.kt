package com.j1adong.huabankotlin

import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity

import com.j1adong.huabankotlin.ui.fragment.HomeFragment
import com.jess.arms.base.BaseFragment

import java.util.ArrayList

/**
 * Created by J1aDong on 2017/1/7.
 */

class TestActivity
// internal var list: List<BaseFragment<*>> = ArrayList()

(list: MutableList<BaseFragment<*>>) : AppCompatActivity() {

    internal var list: List<BaseFragment<*>> = ArrayList()

    init {
        this.list = list

        list.add(HomeFragment.newInstance())

        val vp = ViewPager(this)
        vp.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(position: Int, positionOffset: Float,
                                        positionOffsetPixels: Int) {

            }

            override fun onPageSelected(position: Int) {

            }

            override fun onPageScrollStateChanged(state: Int) {

            }
        })
    }
}
