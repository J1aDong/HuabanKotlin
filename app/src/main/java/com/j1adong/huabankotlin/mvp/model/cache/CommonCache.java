package com.j1adong.huabankotlin.mvp.model.cache;

import com.j1adong.huabankotlin.mvp.entity.HttpPinResult;
import com.j1adong.huabankotlin.mvp.entity.HttpPinsResult;

import java.util.concurrent.TimeUnit;

import io.rx_cache.DynamicKey;
import io.rx_cache.EvictDynamicKey;
import io.rx_cache.EvictProvider;
import io.rx_cache.LifeCache;
import io.rx_cache.Reply;
import rx.Observable;

/**
 * Created by J1aDong on 2017/1/8.
 */

public interface CommonCache
{

	@LifeCache(duration = 2, timeUnit = TimeUnit.MINUTES)
	Observable<Reply<HttpPinsResult>> getAll(Observable<HttpPinsResult> stringObservable,
											 DynamicKey idLastUserQueried, EvictProvider evictProvider);

	@LifeCache(duration = 2, timeUnit = TimeUnit.MINUTES)
	Observable<Reply<HttpPinResult>> getPinDetail(Observable<HttpPinResult> datas, DynamicKey dynamicKey, EvictDynamicKey evictDynamicKey);
}
