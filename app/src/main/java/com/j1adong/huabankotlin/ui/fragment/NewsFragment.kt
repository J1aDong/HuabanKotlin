package com.j1adong.huabankotlin.ui.fragment

import com.jess.arms.utils.Preconditions.checkNotNull

import com.j1adong.huabankotlin.common.WEFragment
import com.j1adong.huabankotlin.di.component.AppComponent
import com.j1adong.huabankotlin.di.module.NewsFragmentModule
import com.j1adong.huabankotlin.mvp.contract.NewsFragmentContract
import com.j1adong.huabankotlin.mvp.presenter.NewsFragmentPresenter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.j1adong.huabankotlin.common.InjectionHeader
import com.j1adong.huabankotlin.event.EventString
import org.jetbrains.anko.*

/**
 * 通过Template生成对应页面的MVP和Dagger代码,请注意输入框中输入的名字必须相同
 * 由于每个项目包结构都不一定相同,所以每生成一个文件需要自己导入import包名,可以在设置中设置自动导入包名
 * 请在对应包下按以下顺序生成对应代码,Contract->Model->Presenter->Activity->Module->Component
 * 因为生成Activity时,Module和Component还没生成,但是Activity中有它们的引用,所以会报错,但是不用理会
 * 继续将Module和Component生成完后,编译一下项目再回到Activity,按提示修改一个方法名即可
 * 如果想生成Fragment的相关文件,则将上面构建顺序中的Activity换为Fragment,并将Component中inject方法的参数改为此Fragment
 */

/**
 * Created by J1aDong on 2017/1/9.
 */

class NewsFragment : WEFragment<NewsFragmentPresenter>(), NewsFragmentContract.View {

    override fun findViews(mRootView: View) {
    }

    override fun setupFragmentComponent(appComponent: AppComponent) {
        InjectionHeader.inject(appComponent, this)
    }

    override fun initView(): View? {
        val view = NewsFragmentUI().createView(AnkoContext.Companion.create(context, this))
        return view
    }

    override fun initData() {

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
        checkNotNull(message)
    }

    override fun killMyself() {

    }

    companion object {
        fun newInstance(): NewsFragment {
            val fragment = NewsFragment()
            return fragment
        }
    }

    class NewsFragmentUI : AnkoComponent<NewsFragment> {
        override fun createView(ui: AnkoContext<NewsFragment>) = with(ui) {
            relativeLayout {
                textView {
                    text = "NewsFragment"
                }.lparams {
                    centerInParent()
                }
            }
        }

    }

}