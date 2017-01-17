package com.j1adong.huabankotlin.ui.fragment

import android.os.Build
import android.support.v4.view.ViewCompat
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.StaggeredGridLayoutManager
import android.transition.Fade
import android.transition.TransitionInflater
import android.util.Log
import android.view.View
import com.facebook.drawee.drawable.ScalingUtils
import com.facebook.drawee.view.DraweeTransition
import com.j1adong.huabankotlin.R
import com.j1adong.huabankotlin.common.InjectionHeader
import com.j1adong.huabankotlin.common.WEFragment
import com.j1adong.huabankotlin.di.component.AppComponent
import com.j1adong.huabankotlin.event.EventConstant
import com.j1adong.huabankotlin.event.EventGotoDetail
import com.j1adong.huabankotlin.event.EventString
import com.j1adong.huabankotlin.mvp.contract.HomeFragmentContract
import com.j1adong.huabankotlin.mvp.entity.PinsEntity
import com.j1adong.huabankotlin.mvp.presenter.HomeFragmentPresenter
import com.j1adong.huabankotlin.ui.fragment.HomeFragment.HomeFragmentUI.Factory.ID_RECYCLERVIEW
import com.j1adong.huabankotlin.ui.fragment.HomeFragment.HomeFragmentUI.Factory.ID_SWIPEREFRESHLAYOUT
import com.jess.arms.utils.EventBus
import com.jess.arms.utils.UiUtils
import com.jess.arms.widget.recyclerview.GridSpacingItemDecoration
import com.jess.arms.widget.recyclerview.HideScrollListener
import com.jess.arms.widget.recyclerview.OnLoadMoreListener
import com.jess.arms.widget.transition.DetailTransition
import com.squareup.otto.Subscribe
import me.drakeet.multitype.MultiTypeAdapter
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.support.v4.swipeRefreshLayout

/**
 * 通过Template生成对应页面的MVP和Dagger代码,请注意输入框中输入的名字必须相同
 * 由于每个项目包结构都不一定相同,所以每生成一个文件需要自己导入import包名,可以在设置中设置自动导入包名
 * 请在对应包下按以下顺序生成对应代码,Contract->Model->Presenter->TestActivity->Module->Component
 * 因为生成Activity时,Module和Component还没生成,但是Activity中有它们的引用,所以会报错,但是不用理会
 * 继续将Module和Component生成完后,编译一下项目再回到Activity,按提示修改一个方法名即可
 * 如果想生成Fragment的相关文件,则将上面构建顺序中的Activity换为Fragment,并将Component中inject方法的参数改为此Fragment
 */

/**
 * Created by J1aDong on 2017/1/7.
 */

class HomeFragment : WEFragment<HomeFragmentPresenter>(), HomeFragmentContract.View {

    var pinsEntityList: MutableList<PinsEntity>? = null

    override fun setPins(pinsEntityList: MutableList<PinsEntity>?) {
        this.pinsEntityList = pinsEntityList
    }

    @Subscribe fun gotoDetailFragment(event: EventGotoDetail) {
        val fragment = DetailFragment.newInstance(event.holder.pins)
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
            exitTransition = Fade()

            fragment.enterTransition = Fade()
//            fragment.sharedElementReturnTransition = DraweeTransition.createTransitionSet(
//                    ScalingUtils.ScaleType.CENTER_CROP, ScalingUtils.ScaleType.CENTER_CROP)
//            fragment.sharedElementEnterTransition = DraweeTransition.createTransitionSet(
//                    ScalingUtils.ScaleType.CENTER_CROP, ScalingUtils.ScaleType.CENTER_CROP)
            fragment.sharedElementReturnTransition = TransitionInflater.from(context)
                    .inflateTransition(R.transition.change_image_trans)
            fragment.sharedElementEnterTransition = TransitionInflater.from(context)
                    .inflateTransition(R.transition.change_image_trans)

            // 25.1.0以下的support包,Material过渡动画只有在进栈时有,返回时没有;
            // 25.1.0+的support包，SharedElement正常
            fragment.transaction()
                    .addSharedElement(event.holder.getmImgBackground(), getString(R.string.image_transition))
                    .commit<DetailFragment>()
        }
        start(fragment)
    }

    private var mSwipeRefreshLayout: SwipeRefreshLayout? = null
    private var mRecyclerView: RecyclerView? = null

    override fun findViews(mRootView: View) {
        mRecyclerView = mRootView.find<RecyclerView>(ID_RECYCLERVIEW)
        mSwipeRefreshLayout = mRootView.find<SwipeRefreshLayout>(ID_SWIPEREFRESHLAYOUT)
    }

    override fun setAdapter(adapter: MultiTypeAdapter?) {
        mRecyclerView?.adapter = adapter
    }

    override fun setupFragmentComponent(appComponent: AppComponent) {
        InjectionHeader.inject(appComponent, this)
    }

    override fun initView(): View? {
        return HomeFragmentUI().createView(AnkoContext.create(context, this))
    }

    override fun initData() {
        mRecyclerView?.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        val deco = GridSpacingItemDecoration(2, UiUtils.dip2px(5f), true)
        mRecyclerView?.addItemDecoration(deco)
        mRecyclerView?.itemAnimator = DefaultItemAnimator()
        mPresenter.requestAll(false, false)
        mRecyclerView?.setOnScrollListener(object : OnLoadMoreListener() {
            override fun onBottom() {
                super.onBottom()
                mPresenter.requestAll(false, true)
            }
        })

        mSwipeRefreshLayout?.setOnRefreshListener {
            showLoading()
            mPresenter.requestAll(true, false)
        }
    }

    /**
     * 此方法是让外部调用使fragment做一些操作的,比如说外部的activity想让fragment对象执行一些方法,
     * 建议在有多个需要让外界调用的方法时,统一传bundle,里面存一个what字段,来区分不同的方法,在setData
     * 方法中就可以switch做不同的操作,这样就可以用统一的入口方法做不同的事,和message同理

     * 使用此方法时请注意调用时fragment的生命周期,如果调用此setData方法时onActivityCreated
     * 还没执行,setData里调用presenter的方法时,是会报空的,因为dagger注入是在onActivityCreated
     * 方法中执行的,如果要做一些初始化操作,可以不必让外部调setData,在内部onActivityCreated中 初始化就可以了

     * @param data
     */

    override fun setData(data: Any) {

    }

    override fun showLoading() {
        mSwipeRefreshLayout?.isRefreshing = true
    }

    override fun hideLoading() {
        mSwipeRefreshLayout?.isRefreshing = false
    }

    override fun showMessage(message: String) {
    }

    override fun killMyself() {

    }

    companion object {

        fun newInstance(): HomeFragment {
            val fragment = HomeFragment()
            return fragment
        }
    }

    @Subscribe fun receiveEvent(event: EventString) {
        Log.w(TAG, "结收到-->" + event.tag)
        if (event.tag == EventConstant.REFRESH_ALL_EVENT) {
            mPresenter.requestAll(true, false)
        }
    }

    class HomeFragmentUI : AnkoComponent<HomeFragment> {

        override fun createView(ui: AnkoContext<HomeFragment>) = with(ui) {
            verticalLayout {
                swipeRefreshLayout {
                    id = ID_SWIPEREFRESHLAYOUT

                    setProgressViewEndTarget(true, 300)

                    recyclerView {
                        id = ID_RECYCLERVIEW
                        backgroundColor = ui.ctx.resources.getColor(R.color.md_grey_200)
                        clipToPadding = false
                        topPadding = 200
                        addOnScrollListener(object : HideScrollListener() {
                            override fun hide() {
                                EventBus.getDefault().post(EventString(EventConstant.HIDE_TOOLBAR))
                            }

                            override fun show() {
                                EventBus.getDefault().post(EventString(EventConstant.SHOW_TOOLBAR))
                            }
                        })
                    }.lparams(width = matchParent, height = matchParent) {
                    }
                }.lparams(width = matchParent, height = matchParent)
            }
        }

        companion object Factory {
            val ID_RECYCLERVIEW = 2001
            val ID_SWIPEREFRESHLAYOUT = 2002
        }
    }

}