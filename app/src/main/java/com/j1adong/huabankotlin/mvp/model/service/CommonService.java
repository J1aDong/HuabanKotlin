package com.j1adong.huabankotlin.mvp.model.service;

import com.j1adong.huabankotlin.mvp.entity.HbData;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by J1aDong on 2017/1/8.
 */

public interface CommonService
{

	@GET("all")
	Observable<HbData> getAll(@Query("limit") Integer limit);
}
