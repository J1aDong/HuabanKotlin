package com.j1adong.huabankotlin.mvp.model.service;

import com.j1adong.huabankotlin.mvp.entity.HttpPinResult;
import com.j1adong.huabankotlin.mvp.entity.HttpPinsResult;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by J1aDong on 2017/1/8.
 */

public interface CommonService
{

	@GET("all")
	Observable<HttpPinsResult> getAllPins(@Query("limit") Integer limit,
			@Query("max") Integer max);

	@GET("pins/{pin_id}")
	Observable<HttpPinResult> getPinDetail(@Path("pin_id") int pinId);
}
