package com.j1adong.huabankotlin.adapter;

import com.facebook.drawee.view.SimpleDraweeView;
import com.j1adong.huabankotlin.R;
import com.j1adong.huabankotlin.event.EventGotoDetail;
import com.j1adong.huabankotlin.mvp.entity.PinsEntity;
import com.jess.arms.utils.DeviceUtils;
import com.jess.arms.utils.EventBus;
import com.zhy.autolayout.utils.AutoUtils;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.drakeet.multitype.ItemViewProvider;

/**
 * Created by J1aDong on 2017/1/9.
 */
public class PinsViewProvider
		extends ItemViewProvider<PinsEntity, PinsViewProvider.ViewHolder>
{

	private float screenWidth;

	@NonNull
	@Override
	protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater,
			@NonNull ViewGroup parent)
	{
		View root = inflater.inflate(R.layout.item_pins, parent, false);

		screenWidth = DeviceUtils.getScreenWidth(parent.getContext());

		return new ViewHolder(root);
	}

	@Override
	protected void onBindViewHolder(@NonNull final ViewHolder holder,
			@NonNull final PinsEntity pins)
	{
		holder.pins = pins;
		String key = pins.getFile().getKey();
		final String imgUrl = "http://img.hb.aicdn.com/" + key
				+ "_/fw/486/gifto/true/progressive/true/format/webp";
		String avatarUrl = "http://img.hb.aicdn.com/"
				+ pins.getUser().getAvatar().getKey()
				+ "_/fw/486/gifto/true/progressive/true/format/webp";
		String userName = pins.getUser().getUsername().trim();

		int height = pins.getFile().getHeight();
		int width = pins.getFile().getWidth();

		final ImageView imageView = holder.mImgBackground;
		ViewGroup.LayoutParams params = imageView.getLayoutParams();
		int resizeWidth = (int) (screenWidth / 2);
		int resizeHeight = (int) (screenWidth / 2 * height / (double) width);
		params.width = resizeWidth;
		params.height = resizeHeight;
		imageView.setLayoutParams(params);

		holder.mImgBackground.setImageURI(imgUrl);
		holder.mImgAvatar.setImageURI(avatarUrl);
		holder.mTvUserName.setText(userName);
	}

	public static class ViewHolder extends RecyclerView.ViewHolder
	{
		@BindView(R.id.img_background)
		SimpleDraweeView mImgBackground;
		@BindView(R.id.tv_userName)
		TextView mTvUserName;
		@BindView(R.id.img_avatar)
		SimpleDraweeView mImgAvatar;
		PinsEntity pins;

		ViewHolder(View itemView)
		{
			super(itemView);
			ButterKnife.bind(this, itemView);
			AutoUtils.autoSize(itemView);

			mImgBackground.setOnClickListener(new View.OnClickListener()
			{
				@Override
				public void onClick(View v)
				{
					EventBus.getDefault()
							.post(new EventGotoDetail(mImgBackground, pins));
				}
			});
		}
	}
}