package com.j1adong.huabankotlin.mvp.model;

import android.app.Application;

import com.google.gson.Gson;
import com.j1adong.huabankotlin.mvp.contract.HomeFragmentContract;
import com.j1adong.huabankotlin.mvp.entity.HttpPinsResult;
import com.j1adong.huabankotlin.mvp.model.cache.CacheManager;
import com.j1adong.huabankotlin.mvp.model.service.ServiceManager;
import com.jess.arms.di.scope.ActivityScope;
import com.jess.arms.mvp.BaseModel;

import javax.inject.Inject;

import io.rx_cache.DynamicKey;
import io.rx_cache.EvictDynamicKey;
import io.rx_cache.Reply;
import rx.Observable;
import rx.functions.Func1;

import static com.jess.arms.utils.Preconditions.checkNotNull;

/**
 * 通过Template生成对应页面的MVP和Dagger代码,请注意输入框中输入的名字必须相同
 * 由于每个项目包结构都不一定相同,所以每生成一个文件需要自己导入import包名,可以在设置中设置自动导入包名
 * 请在对应包下按以下顺序生成对应代码,Contract->Model->Presenter->TestActivity->Module->Component
 * 因为生成Activity时,Module和Component还没生成,但是Activity中有它们的引用,所以会报错,但是不用理会
 * 继续将Module和Component生成完后,编译一下项目再回到Activity,按提示修改一个方法名即可
 * 如果想生成Fragment的相关文件,则将上面构建顺序中的Activity换为Fragment,并将Component中inject方法的参数改为此Fragment
 */

/**
 * Created by J1aDong on 2017/1/7.
 */

@ActivityScope
public class HomeFragmentModel extends BaseModel<ServiceManager, CacheManager>
		implements HomeFragmentContract.Model
{
	private Gson mGson;
	private Application mApplication;

	@Inject
	public HomeFragmentModel(ServiceManager serviceManager,
			CacheManager cacheManager, Gson gson, Application application)
	{
		super(serviceManager, cacheManager);
		this.mGson = gson;
		this.mApplication = application;
	}

	@Override
	public void onDestory()
	{
		super.onDestory();
		this.mGson = null;
		this.mApplication = null;
	}

	@Override
	public Observable<HttpPinsResult> getAll(Integer limit, Integer max, boolean update)
	{
		Observable<HttpPinsResult> datas = mServiceManager.getCommonService()
				.getAllPins(limit, max);
		return mCacheManager.getCommonCache()
				.getAll(datas, new DynamicKey(max == null ? 0
						: max), new EvictDynamicKey(update))
				.flatMap(new Func1<Reply<HttpPinsResult>, Observable<HttpPinsResult>>()
				{
					@Override
					public Observable<HttpPinsResult> call(Reply<HttpPinsResult> stringReply)
					{
						return Observable.just(stringReply.getData());
					}
				});
	}
}
