package com.j1adong.huabankotlin.ui.fragment;

import com.j1adong.huabankotlin.R;
import com.j1adong.huabankotlin.common.WEMainFragment;
import com.j1adong.huabankotlin.di.component.AppComponent;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;

/**
 * Created by J1aDong on 2017/1/20.
 */

public class FirstFragemnt extends WEMainFragment
{

	public static FirstFragemnt newInstance()
	{

		Bundle args = new Bundle();

		FirstFragemnt fragment = new FirstFragemnt();
		fragment.setArguments(args);
		return fragment;
	}

	@Override
	protected void setupFragmentComponent(AppComponent appComponent)
	{

	}

	@Override
	protected void findViews(View mRootView)
	{

	}

	@Override
	protected View initView()
	{
		return LayoutInflater.from(getContext())
				.inflate(R.layout.fragment_first, null, false);
	}

	@Override
	public void onLazyInitView(@Nullable Bundle savedInstanceState)
	{
		super.onLazyInitView(savedInstanceState);
		if( savedInstanceState == null )
		{
			loadRootFragment(R.id.fl_first_container, HomeFragment.Companion
					.newInstance());
		}
	}

	@Override
	protected void initData()
	{

	}
}
