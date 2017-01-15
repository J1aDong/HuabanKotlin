package com.j1adong.huabankotlin.mvp.presenter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import com.j1adong.huabankotlin.adapter.Footer;
import com.j1adong.huabankotlin.adapter.FooterViewProvider;
import com.j1adong.huabankotlin.adapter.PinsViewProvider;
import com.j1adong.huabankotlin.mvp.contract.HomeFragmentContract;
import com.j1adong.huabankotlin.mvp.entity.HbData;
import com.j1adong.huabankotlin.mvp.entity.PinsEntity;
import com.jess.arms.di.scope.ActivityScope;
import com.jess.arms.mvp.BasePresenter;
import com.jess.arms.rx.rxerrorhandler.core.RxErrorHandler;
import com.jess.arms.rx.rxerrorhandler.handler.RetryWithDelay;
import com.jess.arms.utils.RxUtils;
import com.jess.arms.widget.imageloader.ImageLoader;
import com.socks.library.KLog;

import android.app.Application;

import me.drakeet.multitype.Items;
import me.drakeet.multitype.MultiTypeAdapter;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

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
public class HomeFragmentPresenter extends
		BasePresenter<HomeFragmentContract.Model, HomeFragmentContract.View>
{
	private RxErrorHandler mErrorHandler;
	private Application mApplication;
	private ImageLoader mImageLoader;

	Items items = new Items();
	List<PinsEntity> pinsEntityList = new ArrayList<>();
	MultiTypeAdapter mAdapter;

	@Inject
	public HomeFragmentPresenter(HomeFragmentContract.Model model,
			HomeFragmentContract.View rootView, RxErrorHandler handler,
			Application application, ImageLoader imageLoader)
	{
		super(model, rootView);
		this.mErrorHandler = handler;
		this.mApplication = application;
		this.mImageLoader = imageLoader;

		mAdapter = new MultiTypeAdapter(items);
		// 注册ViewType类型
		mAdapter.register(PinsEntity.class, new PinsViewProvider());
		mAdapter.register(Footer.class, new FooterViewProvider());
		mRootView.setAdapter(mAdapter);
	}

	public void requestAll(final boolean pullToRefresh, final boolean loadMore)
	{
		// 刷新就清空list数据
		if( pullToRefresh )
		{
			items.removeAll(pinsEntityList);
			pinsEntityList.clear();
		}

		if( loadMore )
		{
			items.add(new Footer(Footer.LoadMore));
			mAdapter.notifyItemRangeChanged(pinsEntityList
					.size(), pinsEntityList.size() + 1);
		}

		final Integer max = pinsEntityList.size() == 0 ? null
				: pinsEntityList.get(pinsEntityList.size() - 1).getPin_id();
		mModel.getAll(20, max, pullToRefresh).subscribeOn(Schedulers.io())
				.retryWhen(new RetryWithDelay(3, 2))
				.observeOn(AndroidSchedulers.mainThread())
				.compose(RxUtils.<HbData> bindToLifecycle(mRootView))
				.subscribe(new Action1<HbData>()
				{
					@Override
					public void call(HbData hbData)
					{
						int oldCount = pinsEntityList.size();
						mRootView.hideLoading();
						pinsEntityList.addAll(hbData.getPins());
						items.addAll(oldCount, hbData.getPins());

						int newCount = pinsEntityList.size();

						if( pullToRefresh )
						{
							mAdapter.notifyDataSetChanged();
						}
						else if( loadMore )
						{
							items.remove(items.size() - 1);
							mAdapter.notifyItemRangeChanged(oldCount, newCount
									- oldCount);
						}
						else
						{
							mAdapter.notifyItemRangeInserted(oldCount, newCount
									- oldCount);
						}
					}
				}, new Action1<Throwable>()
				{
					@Override
					public void call(Throwable throwable)
					{
						mRootView.hideLoading();
						if( loadMore )
						{
							items.remove(items.size() - 1);
							mAdapter.notifyDataSetChanged();
						}
						throwable.printStackTrace();
					}
				});
	}

	@Override
	public void onDestroy()
	{
		super.onDestroy();
		this.mErrorHandler = null;
		this.mImageLoader = null;
		this.mApplication = null;
	}

}