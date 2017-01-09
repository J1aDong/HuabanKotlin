package com.j1adong.huabankotlin.mvp.presenter;

import android.app.Application;

import com.j1adong.huabankotlin.mvp.contract.HomeActivityContract;
import com.jess.arms.di.scope.ActivityScope;
import com.jess.arms.mvp.BasePresenter;
import com.jess.arms.rx.rxerrorhandler.core.RxErrorHandler;

import javax.inject.Inject;

/**
 * Created by J1aDong on 2017/1/7.
 */
@ActivityScope
public class HomePresenter extends
		BasePresenter<HomeActivityContract.Model, HomeActivityContract.View>
{
	private RxErrorHandler mErrorHandler;
	private Application mApplication;

	@Inject
	public HomePresenter(HomeActivityContract.Model model,
			HomeActivityContract.View rootView, RxErrorHandler mErrorHandler,
			Application mApplication)
	{
		super(model, rootView);
		this.mErrorHandler = mErrorHandler;
		this.mApplication = mApplication;
	}

	@Override
	public void onDestroy()
	{
		super.onDestroy();
	}
}
