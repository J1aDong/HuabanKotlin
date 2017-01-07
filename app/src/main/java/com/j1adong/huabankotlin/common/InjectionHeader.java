package com.j1adong.huabankotlin.common;

import com.j1adong.huabankotlin.MainActivity;
import com.j1adong.huabankotlin.di.component.AppComponent;
import com.j1adong.huabankotlin.di.component.DaggerHomeComponent;
import com.j1adong.huabankotlin.di.module.HomeModule;
import com.j1adong.huabankotlin.mvp.contract.HomeContract;

import org.jetbrains.annotations.Nullable;

/**
 * kotlin不能直接使用dagger2生成的component，请在这个类中进行桥接
 * 
 * Created by J1aDong on 2017/1/7.
 */

public class InjectionHeader
{

	public static void inject(@Nullable AppComponent appComponent,
			HomeContract.View view, MainActivity mainActivity)
	{
		DaggerHomeComponent.builder().appComponent(appComponent)
				.homeModule(new HomeModule(view)).build().inject(mainActivity);
	}
}
