package com.j1adong.huabankotlin.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.j1adong.huabankotlin.R;
import com.j1adong.huabankotlin.mvp.entity.PinsEntity;
import com.jess.arms.utils.DeviceUtils;
import com.zhy.autolayout.utils.AutoUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import jp.wasabeef.glide.transformations.CropCircleTransformation;
import me.drakeet.multitype.ItemViewProvider;

/**
 * Created by J1aDong on 2017/1/9.
 */
public class PinsViewProvider
        extends ItemViewProvider<PinsEntity, PinsViewProvider.ViewHolder> {

    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater,
                                            @NonNull ViewGroup parent) {
        View root = inflater.inflate(R.layout.item_pins, parent, false);
        return new ViewHolder(root);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder,
                                    @NonNull PinsEntity pins) {
        String key = pins.getFile().getKey();
        String imgUrl = "http://img.hb.aicdn.com/" + key
                + "_/fw/486/gifto/true/progressive/true/format/webp";
        String avatarUrl = "http://img.hb.aicdn.com/" + pins.getUser().getAvatar().getKey()
                + "_/fw/486/gifto/true/progressive/true/format/webp";
        String userName = pins.getUser().getUsername().trim();

        int height = pins.getFile().getHeight();
        int width = pins.getFile().getWidth();

        ImageView imageView = holder.mImgBackground;
        ViewGroup.LayoutParams params = imageView.getLayoutParams();
        float screenWidth = DeviceUtils.getScreenWidth(holder.itemView.getContext());
        params.width = (int) (screenWidth / 2);
        params.height = (int) (screenWidth / 2 * height / (double) width);
        imageView.setLayoutParams(params);

        Glide.with(holder.itemView.getContext()).load(imgUrl)
                .into(holder.mImgBackground);
        Glide.with(holder.itemView.getContext()).load(avatarUrl)
                .bitmapTransform(new CropCircleTransformation(holder.itemView.getContext()))
                .into(holder.mImgAvatar);
        holder.mTvUserName.setText(userName);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.img_background)
        ImageView mImgBackground;
        @BindView(R.id.tv_userName)
        TextView mTvUserName;
        @BindView(R.id.img_avatar)
        ImageView mImgAvatar;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            AutoUtils.autoSize(itemView);
        }
    }
}