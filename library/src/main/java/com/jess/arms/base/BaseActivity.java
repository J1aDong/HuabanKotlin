package com.jess.arms.base;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.jess.arms.mvp.BasePresenter;
import com.jess.arms.widget.fragmention.SupportActivity;
import com.jess.arms.widget.fragmention.SupportFragment;
import com.jess.arms.widget.fragmention.helper.FragmentLifecycleCallbacks;
import com.zhy.autolayout.AutoFrameLayout;
import com.zhy.autolayout.AutoLinearLayout;
import com.zhy.autolayout.AutoRelativeLayout;

import org.simple.eventbus.EventBus;

import javax.inject.Inject;

public abstract class BaseActivity<P extends BasePresenter>
		extends SupportActivity
{
	protected final String TAG = this.getClass().getSimpleName();
	protected BaseApplication mApplication;
	@Inject
	protected P mPresenter;

	private static final String LAYOUT_LINEARLAYOUT = "LinearLayout";
	private static final String LAYOUT_FRAMELAYOUT = "FrameLayout";
	private static final String LAYOUT_RELATIVELAYOUT = "RelativeLayout";
	public static final String IS_NOT_ADD_ACTIVITY_LIST = "is_add_activity_list";// 是否加入到activity的list，管理

	@Override
	public View onCreateView(String name, Context context, AttributeSet attrs)
	{
		View view = null;
		if( name.equals(LAYOUT_FRAMELAYOUT) )
		{
			view = new AutoFrameLayout(context, attrs);
		}

		if( name.equals(LAYOUT_LINEARLAYOUT) )
		{
			view = new AutoLinearLayout(context, attrs);
		}

		if( name.equals(LAYOUT_RELATIVELAYOUT) )
		{
			view = new AutoRelativeLayout(context, attrs);
		}

		if( view != null )
			return view;

		return super.onCreateView(name, context, attrs);
	}

	@Override
	protected void onResume()
	{
		super.onResume();
	}

	@Override
	protected void onPause()
	{
		super.onPause();
	}

	@Nullable
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		mApplication = (BaseApplication) getApplication();
		// 如果intent包含了此字段,并且为true说明不加入到list
		// 默认为false,如果不需要管理(比如不需要在退出所有activity(killAll)时，退出此activity就在intent加此字段为true)
		boolean isNotAdd = false;
		if( getIntent() != null )
			isNotAdd = getIntent()
					.getBooleanExtra(IS_NOT_ADD_ACTIVITY_LIST, false);

		if( useEventBus() )// 如果要使用eventbus请将此方法返回true
			EventBus.getDefault().register(this);// 注册到事件主线
		setContentView(initView());
		loadFragment(savedInstanceState);

		// 可以监听该Activity下的所有Fragment的18个 生命周期方法
		registerFragmentLifecycleCallbacks(new FragmentLifecycleCallbacks() {

			@Override
			public void onFragmentSupportVisible(SupportFragment fragment) {
				Log.i("MainActivity", "onFragmentSupportVisible--->" + fragment.getClass().getSimpleName());
			}

			@Override
			public void onFragmentCreated(SupportFragment fragment, Bundle savedInstanceState) {
				super.onFragmentCreated(fragment, savedInstanceState);
			}
			// 省略其余生命周期方法
		});

		ComponentInject();// 依赖注入
		initData();
	}

	/**
	 * 根部局加载后，注意判断savedInstanceState ==null的时候加载fragment
	 * 
	 * @param savedInstanceState
	 */
	protected abstract void loadFragment(Bundle savedInstanceState);

	/**
	 * 依赖注入的入口
	 */
	protected abstract void ComponentInject();

	public void FullScreencall()
	{
		if( Build.VERSION.SDK_INT > 11 && Build.VERSION.SDK_INT < 19 )
		{ // lower api
			View v = this.getWindow().getDecorView();
			v.setSystemUiVisibility(View.GONE);
		}
		else if( Build.VERSION.SDK_INT >= 19 )
		{
			// for new api versions.
			View decorView = getWindow().getDecorView();
			int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
					| View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
			decorView.setSystemUiVisibility(uiOptions);
		}
	}

	@Override
	protected void onDestroy()
	{
		super.onDestroy();
		if( mPresenter != null )
			mPresenter.onDestroy();// 释放资源
		if( useEventBus() )// 如果要使用eventbus请将此方法返回true
			EventBus.getDefault().unregister(this);
		this.mPresenter = null;
		this.mApplication = null;
	}

	/**
	 * 是否使用eventBus,默认为使用(true)，
	 *
	 * @return
	 */
	protected boolean useEventBus()
	{
		return true;
	}

	protected abstract View initView();

	protected abstract void initData();

}
