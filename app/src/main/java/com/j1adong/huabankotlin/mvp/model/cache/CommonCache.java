package com.j1adong.huabankotlin.mvp.model.cache;

import com.j1adong.huabankotlin.mvp.entity.HbData;

import java.util.concurrent.TimeUnit;

import io.rx_cache.DynamicKey;
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
	Observable<Reply<HbData>> getAll(Observable<HbData> stringObservable,
			DynamicKey idLastUserQueried, EvictProvider evictProvider);
}
