package com.j1adong.huabankotlin.di.component;

import android.app.Application;

import com.google.gson.Gson;
import com.j1adong.huabankotlin.di.module.CacheModule;
import com.j1adong.huabankotlin.di.module.ServiceModule;
import com.j1adong.huabankotlin.mvp.model.cache.CacheManager;
import com.j1adong.huabankotlin.mvp.model.service.ServiceManager;
import com.jess.arms.di.module.AppModule;
import com.jess.arms.di.module.ClientModule;
import com.jess.arms.di.module.GlobeConfigModule;
import com.jess.arms.di.module.ImageModule;
import com.jess.arms.rx.rxerrorhandler.core.RxErrorHandler;
import com.jess.arms.widget.imageloader.ImageLoader;

import javax.inject.Singleton;

import dagger.Component;
import okhttp3.OkHttpClient;

/**
 * Created by J1aDong on 2017/1/6.
 */
@Singleton
@Component(modules =
{ AppModule.class, ClientModule.class, ServiceModule.class, ImageModule.class,
		CacheModule.class, GlobeConfigModule.class })
public interface AppComponent
{
	Application Application();

	// 服务管理器,retrofitApi
	ServiceManager serviceManager();

	// 缓存管理器
	CacheManager cacheManager();

	// Rxjava错误处理管理类
	RxErrorHandler rxErrorHandler();

	OkHttpClient okHttpClient();

	// 图片管理器,用于加载图片的管理类,默认使用glide,使用策略模式,可替换框架
	ImageLoader imageLoader();

	// gson
	Gson gson();

}
