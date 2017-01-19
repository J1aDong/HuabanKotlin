package com.j1adong.huabankotlin.adapter;

import android.support.annotation.NonNull;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.j1adong.huabankotlin.R;
import com.j1adong.huabankotlin.event.EventGotoDetail;
import com.j1adong.huabankotlin.mvp.entity.PinEntity;
import com.jess.arms.utils.DeviceUtils;
import com.jess.arms.utils.EventBus;
import com.zhy.autolayout.utils.AutoUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.drakeet.multitype.ItemViewProvider;

/**
 * Created by J1aDong on 2017/1/9.
 */
public class PinsViewProvider
		extends ItemViewProvider<PinEntity, PinsViewProvider.ViewHolder>
{
	private float screenWidth;

	@NonNull
	@Override
	protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater,
			@NonNull ViewGroup parent)
	{
		View root = inflater.inflate(R.layout.item_pins, parent, false);

		screenWidth = DeviceUtils.getScreenWidth(parent.getContext());

		final ViewHolder holder = new ViewHolder(root);

		holder.mImgBackground.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				EventBus.getDefault()
						.post(new EventGotoDetail(getPosition(holder), v, holder));
			}
		});

		return holder;
	}

	@Override
	protected void onBindViewHolder(@NonNull final ViewHolder holder,
			@NonNull final PinEntity pins)
	{
		holder.pins = pins;
		String key = pins.getFile().getKey();
		final String imgUrl = "http://img.hb.aicdn.com/" + key
				+ "_/fw/486/gifto/true/progressive/true/format/webp";
		String avatarUrl = "http://img.hb.aicdn.com/"
				+ pins.getUser().getAvatar().getKey()
				+ "_/fw/486/gifto/true/progressive/true/format/webp";
		String userName = pins.getUser().getUsername().trim();
		String type = pins.getBoard().getTitle();
		String content = pins.getRaw_text();

		int height = pins.getFile().getHeight();
		int width = pins.getFile().getWidth();

		final ImageView imageView = holder.mImgBackground;
		ViewGroup.LayoutParams params = imageView.getLayoutParams();
		int resizeWidth = (int) (screenWidth / 2);
		int resizeHeight = (int) (screenWidth / 2 * height / (double) width);
		params.width = resizeWidth;
		params.height = resizeHeight;
		imageView.setLayoutParams(params);

		// 把每个图片视图设置不同的Transition名称, 防止在一个视图内有多个相同的名称, 在变换的时候造成混乱
		// Fragment支持多个View进行变换, 使用适配器时, 需要加以区分
		ViewCompat.setTransitionName(holder.mImgBackground, String
				.valueOf(getPosition(holder) + "_img"));

		holder.mImgBackground.setImageURI(imgUrl);
		holder.mImgAvatar.setImageURI(avatarUrl);
		holder.mTvUserName.setText(userName);
		holder.mTvType.setText(type);
		if( TextUtils.isEmpty(content) )
		{
			holder.mTvContent.setVisibility(View.GONE);
		}
		else
		{
			holder.mTvContent.setVisibility(View.VISIBLE);
			holder.mTvContent.setText(content);
		}
	}

	public static class ViewHolder extends RecyclerView.ViewHolder
	{
		@BindView(R.id.img_background)
		SimpleDraweeView mImgBackground;
		@BindView(R.id.tv_userName)
		TextView mTvUserName;
		@BindView(R.id.img_avatar)
		SimpleDraweeView mImgAvatar;
		@BindView(R.id.tv_type)
		TextView mTvType;
		@BindView(R.id.tv_content)
		TextView mTvContent;
		PinEntity pins;

		ViewHolder(View itemView)
		{
			super(itemView);
			ButterKnife.bind(this, itemView);
			AutoUtils.autoSize(itemView);
		}

		public SimpleDraweeView getmImgBackground()
		{
			return mImgBackground;
		}

		public TextView getmTvUserName()
		{
			return mTvUserName;
		}

		public SimpleDraweeView getmImgAvatar()
		{
			return mImgAvatar;
		}

		public PinEntity getPins()
		{
			return pins;
		}
	}
}