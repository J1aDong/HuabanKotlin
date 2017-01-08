package com.j1adong.huabankotlin.mvp.presenter;

import android.app.Application;

import com.j1adong.huabankotlin.mvp.contract.HomeActivityContract;
import com.jess.arms.base.AppManager;
import com.jess.arms.di.scope.ActivityScope;
import com.jess.arms.mvp.BasePresenter;

import javax.inject.Inject;

import me.jessyan.rxerrorhandler.core.RxErrorHandler;

/**
 * Created by J1aDong on 2017/1/7.
 */
@ActivityScope
public class HomePresenter
		extends BasePresenter<HomeActivityContract.Model, HomeActivityContract.View>
{
	private RxErrorHandler mErrorHandler;
	private AppManager mAppManager;
	private Application mApplication;

    @Inject
	public HomePresenter(HomeActivityContract.Model model, HomeActivityContract.View rootView,
						 RxErrorHandler mErrorHandler, AppManager mAppManager,
						 Application mApplication)
	{
		super(model, rootView);
		this.mErrorHandler = mErrorHandler;
		this.mAppManager = mAppManager;
		this.mApplication = mApplication;
	}

	@Override
	public void onDestroy()
	{
		super.onDestroy();
	}
}
