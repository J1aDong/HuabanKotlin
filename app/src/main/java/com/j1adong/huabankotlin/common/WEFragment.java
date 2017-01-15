package com.j1adong.huabankotlin.common;

import com.j1adong.huabankotlin.di.component.AppComponent;
import com.jess.arms.base.BaseFragment;
import com.jess.arms.mvp.BasePresenter;
import com.squareup.leakcanary.RefWatcher;

/**
 * Created by J1aDong on 2017/1/6.
 */

public abstract class WEFragment<P extends BasePresenter>
		extends BaseFragment<P>
{
	private WEApplication mWeApplication;

	@Override
	protected void ComponentInject()
	{
		mWeApplication = (WEApplication) mActivity.getApplication();
		setupFragmentComponent(mWeApplication.getAppComponent());
	}

	// 提供AppComponent(提供所有的单例对象)给子类，进行Component依赖
	protected abstract void setupFragmentComponent(AppComponent appComponent);

	@Override
	public void onDestroy()
	{
		super.onDestroy();
		RefWatcher watcher = WEApplication.getRefWatcher(getActivity());// 使用leakCanary检测fragment的内存泄漏
		if( watcher != null )
		{
			watcher.watch(this);
		}
		this.mWeApplication = null;
	}

}
