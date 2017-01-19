package com.j1adong.huabankotlin.common;

import com.j1adong.huabankotlin.di.component.AppComponent;
import com.j1adong.huabankotlin.ui.fragment.FirstFragemnt;
import com.j1adong.huabankotlin.ui.fragment.HomeFragment;
import com.jess.arms.base.BaseFragment;
import com.jess.arms.mvp.BasePresenter;
import com.squareup.leakcanary.RefWatcher;

import android.content.Context;

/**
 * Created by J1aDong on 2017/1/6.
 */

public abstract class WEMainFragment<P extends BasePresenter>
		extends BaseFragment<P>
{
	private WEApplication mWeApplication;
	protected OnBackToFirstListener _mBackToFirstListener;

	@Override
	public void onAttach(Context context)
	{
		super.onAttach(context);
		if( context instanceof OnBackToFirstListener )
		{
			_mBackToFirstListener = (OnBackToFirstListener) context;
		}
		else
		{
			throw new RuntimeException(context.toString()
					+ " must implement OnBackToFirstListener");
		}
	}

	@Override
	public void onDetach()
	{
		super.onDetach();
		_mBackToFirstListener = null;
	}

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

	/**
	 * 处理回退事件
	 *
	 * @return
	 */
	@Override
	public boolean onBackPressedSupport()
	{
		if( getChildFragmentManager().getBackStackEntryCount() > 1 )
		{
			popChild();
		}
		else
		{
			if( this instanceof FirstFragemnt )
			{ // 如果是 第一个Fragment 则退出app
				_mActivity.finish();
			}
			else
			{ // 如果不是,则回到第一个Fragment
				_mBackToFirstListener.onBackToFirstFragment();
			}
		}
		return true;
	}

	public interface OnBackToFirstListener
	{
		void onBackToFirstFragment();
	}

}
