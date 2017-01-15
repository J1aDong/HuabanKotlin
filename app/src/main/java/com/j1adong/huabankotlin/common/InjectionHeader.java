package com.j1adong.huabankotlin.common;

import com.j1adong.huabankotlin.di.component.AppComponent;
import com.j1adong.huabankotlin.di.component.DaggerExploreFragmentComponent;
import com.j1adong.huabankotlin.di.component.DaggerHomeComponent;
import com.j1adong.huabankotlin.di.component.DaggerHomeFragmentComponent;
import com.j1adong.huabankotlin.di.component.DaggerMainFragmentComponent;
import com.j1adong.huabankotlin.di.component.DaggerMineFragmentComponent;
import com.j1adong.huabankotlin.di.component.DaggerNewsFragmentComponent;
import com.j1adong.huabankotlin.di.module.ExploreFragmentModule;
import com.j1adong.huabankotlin.di.module.HomeFragmentModule;
import com.j1adong.huabankotlin.di.module.HomeModule;
import com.j1adong.huabankotlin.di.module.MainFragmentModule;
import com.j1adong.huabankotlin.di.module.MineFragmentModule;
import com.j1adong.huabankotlin.di.module.NewsFragmentModule;
import com.j1adong.huabankotlin.ui.activity.MainActivity;
import com.j1adong.huabankotlin.ui.fragment.ExploreFragment;
import com.j1adong.huabankotlin.ui.fragment.HomeFragment;
import com.j1adong.huabankotlin.ui.fragment.MainFragment;
import com.j1adong.huabankotlin.ui.fragment.MineFragment;
import com.j1adong.huabankotlin.ui.fragment.NewsFragment;

/**
 * kotlin不能直接使用dagger2生成的component，请在这个类中进行桥接
 * 
 * Created by J1aDong on 2017/1/7.
 */

public class InjectionHeader
{

	public static void inject(AppComponent appComponent,
			MainActivity mainActivity)
	{
		DaggerHomeComponent.builder().appComponent(appComponent)
				.homeModule(new HomeModule(mainActivity)).build()
				.inject(mainActivity);
	}

	public static void inject(AppComponent appComponent,
			HomeFragment homeFragment)
	{
		DaggerHomeFragmentComponent.builder().appComponent(appComponent)
				.homeFragmentModule(new HomeFragmentModule(homeFragment))// 请将HomeFragmentModule()第一个首字母改为小写
				.build().inject(homeFragment);
	}

	public static void inject(AppComponent appComponent,
			ExploreFragment exploreFragment)
	{
		DaggerExploreFragmentComponent.builder().appComponent(appComponent)
				.exploreFragmentModule(new ExploreFragmentModule(exploreFragment))
				.build().inject(exploreFragment);
	}

	public static void inject(AppComponent appComponent,
			MainFragment mainFragment)
	{
		DaggerMainFragmentComponent.builder().appComponent(appComponent)
				.mainFragmentModule(new MainFragmentModule(mainFragment))
				.build().inject(mainFragment);
	}

	public static void inject(AppComponent appComponent,
			NewsFragment newsFragment)
	{
		DaggerNewsFragmentComponent.builder().appComponent(appComponent)
				.newsFragmentModule(new NewsFragmentModule(newsFragment))// 请将NewsFragmentModule()第一个首字母改为小写
				.build().inject(newsFragment);
	}

	public static void inject(AppComponent appComponent,
			MineFragment mineFragment)
	{
		DaggerMineFragmentComponent.builder().appComponent(appComponent)
				.mineFragmentModule(new MineFragmentModule(mineFragment))// 请将MineFragmentModule()第一个首字母改为小写
				.build().inject(mineFragment);
	}
}
