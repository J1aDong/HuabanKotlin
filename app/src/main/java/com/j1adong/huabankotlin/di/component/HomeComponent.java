package com.j1adong.huabankotlin.di.component;

import com.j1adong.huabankotlin.ui.activity.MainActivity;
import com.j1adong.huabankotlin.di.module.HomeModule;
import com.jess.arms.di.scope.ActivityScope;

import dagger.Component;

/**
 * Created by J1aDong on 2017/1/6.
 */
@ActivityScope
@Component(modules = HomeModule.class, dependencies = AppComponent.class)
public interface HomeComponent
{
	void inject(MainActivity activity);
}
