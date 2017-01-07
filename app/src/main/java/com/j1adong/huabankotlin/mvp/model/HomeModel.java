package com.j1adong.huabankotlin.mvp.model;

import com.j1adong.huabankotlin.mvp.contract.HomeContract;
import com.j1adong.huabankotlin.mvp.model.cache.CacheManager;
import com.j1adong.huabankotlin.mvp.model.service.ServiceManager;
import com.jess.arms.di.scope.ActivityScope;
import com.jess.arms.mvp.BaseModel;

import javax.inject.Inject;

/**
 * Created by J1aDong on 2017/1/6.
 */
@ActivityScope
public class HomeModel extends BaseModel<ServiceManager, CacheManager>
		implements HomeContract.Model
{

	@Inject
	public HomeModel(ServiceManager serviceManager, CacheManager cacheManager)
	{
		super(serviceManager, cacheManager);
	}
}
