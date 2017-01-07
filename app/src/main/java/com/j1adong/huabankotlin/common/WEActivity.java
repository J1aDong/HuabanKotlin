package com.j1adong.huabankotlin.common;

import com.j1adong.huabankotlin.di.component.AppComponent;
import com.jess.arms.base.BaseActivity;
import com.jess.arms.mvp.BasePresenter;

/**
 * Created by J1aDong on 2017/1/6.
 */

public abstract class WEActivity<P extends BasePresenter>
		extends BaseActivity<P>
{

	protected WEApplication mWeApplication;

	@Override
	protected void ComponentInject()
	{
		mWeApplication = (WEApplication) getApplication();
		setupActivityComponent(mWeApplication.getAppComponent());
	}

	// 提供AppComponent(提供所有的单例对象)给子类，进行Component依赖
	protected abstract void setupActivityComponent(AppComponent appComponent);

	@Override
	protected void onDestroy()
	{
		super.onDestroy();
		this.mWeApplication = null;
	}
}
