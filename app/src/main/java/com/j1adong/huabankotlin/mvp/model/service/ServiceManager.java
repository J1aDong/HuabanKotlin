package com.j1adong.huabankotlin.mvp.model.service;

import com.jess.arms.http.BaseServiceManager;

import javax.inject.Inject;

/**
 * Created by J1aDong on 2017/1/6.
 */

public class ServiceManager implements BaseServiceManager
{
	private CommonService commonService;

	/**
	 * 如果需要添加service只需在构造方法中添加对应的service,在提供get方法返回出去,只要在ServiceModule提供了该service
	 * Dagger2会自行注入
	 * 
	 * @param commonService
	 */
	@Inject
	public ServiceManager(CommonService commonService)
	{
		this.commonService = commonService;
	}

	public CommonService getCommonService()
	{
		return commonService;
	}

	@Override
	public void onDestory()
	{

	}
}
