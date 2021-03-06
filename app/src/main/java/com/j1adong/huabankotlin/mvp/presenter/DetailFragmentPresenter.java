package com.j1adong.huabankotlin.mvp.presenter;

import android.app.Application;

import com.j1adong.huabankotlin.mvp.contract.DetailFragmentContract;
import com.j1adong.huabankotlin.mvp.entity.HttpPinResult;
import com.jess.arms.di.scope.ActivityScope;
import com.jess.arms.mvp.BasePresenter;
import com.jess.arms.rx.rxerrorhandler.core.RxErrorHandler;
import com.jess.arms.widget.imageloader.ImageLoader;
import com.socks.library.KLog;

import javax.inject.Inject;

import retrofit2.http.Path;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

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

@ActivityScope
public class DetailFragmentPresenter extends
		BasePresenter<DetailFragmentContract.Model, DetailFragmentContract.View>
{
	private RxErrorHandler mErrorHandler;
	private Application mApplication;
	private ImageLoader mImageLoader;

	@Inject
	public DetailFragmentPresenter(DetailFragmentContract.Model model,
			DetailFragmentContract.View rootView, RxErrorHandler handler,
			Application application, ImageLoader imageLoader)
	{
		super(model, rootView);
		this.mErrorHandler = handler;
		this.mApplication = application;
		this.mImageLoader = imageLoader;
	}

	@Override
	public void onDestroy()
	{
		super.onDestroy();
		this.mErrorHandler = null;
		this.mImageLoader = null;
		this.mApplication = null;
	}

	public void getPinDetail(int pinId)
	{
		mModel.getPinDetail(pinId).subscribeOn(Schedulers.io())
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe(new Action1<HttpPinResult>()
				{
					@Override
					public void call(HttpPinResult httpPinResult)
					{
						KLog.w("获取Detail数据成功");
					}
				}, new Action1<Throwable>()
				{
					@Override
					public void call(Throwable throwable)
					{
						throwable.printStackTrace();
					}
				});
	}

}