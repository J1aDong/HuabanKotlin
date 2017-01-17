package com.j1adong.huabankotlin.ui.fragment

import android.os.Build
import android.os.Bundle
import android.support.v4.view.ViewCompat
import android.view.View
import android.widget.ImageView
import com.facebook.drawee.view.SimpleDraweeView
import com.j1adong.huabankotlin.R
import com.j1adong.huabankotlin.common.InjectionHeader
import com.j1adong.huabankotlin.common.WEFragment
import com.j1adong.huabankotlin.di.component.AppComponent
import com.j1adong.huabankotlin.mvp.contract.DetailFragmentContract
import com.j1adong.huabankotlin.mvp.entity.PinsEntity
import com.j1adong.huabankotlin.mvp.presenter.DetailFragmentPresenter
import com.j1adong.huabankotlin.ui.fragment.DetailFragment.DetailFragmentUI.Factory.ID_IMG
import com.j1adong.huabankotlin.ui.simpleDraweeView
import com.jess.arms.utils.DeviceUtils
import com.jess.arms.widget.fragmention.anim.FragmentAnimator
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
 * Created by J1aDong on 2017/1/15.
 */

class DetailFragment : WEFragment<DetailFragmentPresenter>(), DetailFragmentContract.View {

    private var mImg: SimpleDraweeView? = null

    override fun setupFragmentComponent(appComponent: AppComponent) {
        InjectionHeader.inject(appComponent, this)
    }

    override fun findViews(mRootView: View) {
        mImg = mRootView.find<SimpleDraweeView>(ID_IMG)
    }

    override fun initView(): View {
        return DetailFragmentUI().createView(AnkoContext.Companion.create(context, this))
    }

    override fun initData() {
        val bundle = arguments
        val imgUrl = bundle.getString(IMG_URL)

        mImg?.setImageURI(imgUrl)
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

    override fun showMessage(message: String) {}


    override fun killMyself() {

    }

    companion object {
        private val IMG_URL: String = "IMG_URL"

        fun newInstance(pins: PinsEntity): DetailFragment {
            val fragment = DetailFragment()
            val bundle = Bundle()
            val imgUrl = "http://img.hb.aicdn.com/" + pins.file.key + "_/fw/486/gifto/true/progressive/true/format/webp"
            bundle.putString(IMG_URL, imgUrl)
            fragment.arguments = bundle

            return fragment
        }
    }

    class DetailFragmentUI : AnkoComponent<DetailFragment> {
        override fun createView(ui: AnkoContext<DetailFragment>) = with(ui) {
            scrollView {
                relativeLayout {
                    simpleDraweeView {
                        id = ID_IMG

                        scaleType = ImageView.ScaleType.CENTER_CROP
                        adjustViewBounds = true
                        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
                            transitionName = ui.ctx.getString(R.string.image_transition)
                        }
                    }.lparams(width = 400, height = 500) {

                        centerInParent()
                    }
                }.lparams(width = matchParent, height = matchParent) {

                }
            }
        }

        companion object Factory {
            val ID_IMG = 3001
        }

    }

    override fun onBackPressedSupport(): Boolean {
        pop()
        return true
    }
}