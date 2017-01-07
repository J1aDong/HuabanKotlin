package com.j1adong.huabankotlin.mvp.model.cache

import com.j1adong.huabankotlin.mvp.entity.User
import java.util.concurrent.TimeUnit

import io.rx_cache.DynamicKey
import io.rx_cache.EvictProvider
import io.rx_cache.LifeCache
import io.rx_cache.Reply
import rx.Observable

/**
 * Created by jess on 8/30/16 13:53
 * Contact with jess.yan.effort@gmail.com
 */
interface CommonCache {

    @LifeCache(duration = 2, timeUnit = TimeUnit.MINUTES)
    fun getUsers(oUsers: Observable<List<User>>, idLastUserQueried: DynamicKey, evictProvider: EvictProvider): Observable<Reply<List<User>>>

}
