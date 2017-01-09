package com.j1adong.huabankotlin.ui.fragment

import android.content.Intent
import android.support.v4.view.ViewPager
import android.view.View
import com.ashokvarma.bottomnavigation.BottomNavigationBar
import com.ashokvarma.bottomnavigation.BottomNavigationItem
import com.j1adong.huabankotlin.common.AutoLayout
import com.j1adong.huabankotlin.R
import com.j1adong.huabankotlin.common.InjectionHeader
import com.j1adong.huabankotlin.common.WEFragment
import com.j1adong.huabankotlin.di.component.AppComponent
import com.j1adong.huabankotlin.mvp.contract.MainFragmentContract
import com.j1adong.huabankotlin.mvp.presenter.MainFragmentPresenter
import com.j1adong.huabankotlin.ui.bottomNavigationBar
import com.j1adong.huabankotlin.ui.customViewPager
import com.j1adong.huabankotlin.ui.fragment.MainFragment.MainFragmentUI.Factory.ID_BOTTOMBAR
import com.j1adong.huabankotlin.ui.fragment.MainFragment.MainFragmentUI.Factory.ID_VIEWPAGER
import com.j1adong.huabankotlin.ui.kikkatStatusView
import com.jess.arms.base.AdapterViewPager
import com.jess.arms.base.BaseFragment
import com.jess.arms.utils.UiUtils
import com.jess.arms.utils.Preconditions.checkNotNull
import com.jess.arms.widget.CustomViewPager
import org.jetbrains.anko.*
import org.jetbrains.anko.support.v4.find
import java.util.*

/**
 * 通过Template生成对应页面的MVP和Dagger代码,请注意输入框中输入的名字必须相同
 * 由于每个项目包结构都不一定相同,所以每生成一个文件需要自己导入import包名,可以在设置中设置自动导入包名
 * 请在对应包下按以下顺序生成对应代码,Contract->Model->Presenter->Activity->Module->Component
 * 因为生成Activity时,Module和Component还没生成,但是Activity中有它们的引用,所以会报错,但是不用理会
 * 继续将Module和Component生成完后,编译一下项目再回到Activity,按提示修改一个方法名即可
 * 如果想生成Fragment的相关文件,则将上面构建顺序中的Activity换为Fragment,并将Component中inject方法的参数改为此Fragment
 */

/**
 * Created by J1aDong on 2017/1/8.
 */

class MainFragment : WEFragment<MainFragmentPresenter>(), MainFragmentContract.View {
    var mViewPager: ViewPager? = null
    var mBottomBar: BottomNavigationBar? = null
    internal val listFragments: MutableList<BaseFragment<*>> = ArrayList()

    override fun setupFragmentComponent(appComponent: AppComponent) {
        InjectionHeader.inject(appComponent, this)
    }

    override fun initView(): View {
        val view = MainFragmentUI().createView(AnkoContext.Companion.create(context, this))
        return view
    }

    override fun initData() {
        mViewPager = find<CustomViewPager>(id = ID_VIEWPAGER)
        mBottomBar = find<BottomNavigationBar>(id = ID_BOTTOMBAR)

        listFragments.add(HomeFragment.newInstance())
        listFragments.add(ExploreFragment.newInstance())
        listFragments.add(HomeFragment.newInstance())
        listFragments.add(HomeFragment.newInstance())

        val adapter = AdapterViewPager(activity?.supportFragmentManager)
        adapter.bindData(listFragments)
        mViewPager?.adapter = adapter

        mBottomBar?.setTabSelectedListener(object : BottomNavigationBar.OnTabSelectedListener {
            override fun onTabReselected(position: Int) {
            }

            override fun onTabUnselected(position: Int) {
            }

            override fun onTabSelected(position: Int) {
                mViewPager?.currentItem = position
            }
        })
    }

    /**
     * 此方法是让外部调用使fragment做一些操作的,比如说外部的activity想让fragment对象执行一些方法,
     * 建议在有多个需要让外界调用的方法时,统一传bundle,里面存一个what字段,来区分不同的方法,在setData
     * 方法中就可以switch做不同的操作,这样就可以用统一的入口方法做不同的事,和message同理

     * 使用此方法时请注意调用时fragment的生命周期,如果调用此setData方法时onActivityCreated
     * 还没执行,setData里调用presenter的方法时,是会报空的,因为dagger注入是在onActivityCreated
     * 方法中执行的,如果要做一些初始化操作,可以不必让外部调setData,在内部onActivityCreated中
     * 初始化就可以了

     * @param data
     */
    override fun setData(data: Any) {

    }


    override fun showLoading() {

    }

    override fun hideLoading() {

    }

    override fun showMessage(message: String) {
    }

    override fun killMyself() {

    }

    companion object {

        fun newInstance(): MainFragment {
            val fragment = MainFragment()
            return fragment
        }
    }

    //布局文件
    class MainFragmentUI : AnkoComponent<MainFragment> {
        override fun createView(ui: AnkoContext<MainFragment>) = with(ui) {
            verticalLayout {
                id = ID_ROOT

                customViewPager {
                    id = ID_VIEWPAGER
                }.lparams(width = matchParent, height = 0, weight = 1f) {

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