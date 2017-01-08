package com.j1adong.huabankotlin.di.module;

import com.j1adong.huabankotlin.mvp.contract.HomeActivityContract;
import com.j1adong.huabankotlin.mvp.model.HomeModel;
import com.jess.arms.di.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by J1aDong on 2017/1/6.
 */

@Module
public class HomeModule
{
	private HomeActivityContract.View view;

	/**
	 * 构建HomeModule将View的实现类传进来，这样就能提供View的实现类给presenter
	 * 
	 * @param view
	 */
	public HomeModule(HomeActivityContract.View view)
	{
		this.view = view;
	}

	@ActivityScope
	@Provides
	public HomeActivityContract.View provideHomeView()
	{
		return view;
	}

	@ActivityScope
	@Provides
	HomeActivityContract.Model provideHomeModel(HomeModel model)
	{
		return model;
	}
}
