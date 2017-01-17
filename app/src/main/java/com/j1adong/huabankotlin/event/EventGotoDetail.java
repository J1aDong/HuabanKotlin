package com.j1adong.huabankotlin.event;

import android.view.View;

import com.facebook.drawee.view.SimpleDraweeView;
import com.j1adong.huabankotlin.adapter.PinsViewProvider;

/**
 * Created by J1aDong on 2017/1/16.
 */

public class EventGotoDetail
{
	int position;
	View v;
	PinsViewProvider.ViewHolder holder;

	public EventGotoDetail(int position, View v,
			PinsViewProvider.ViewHolder holder)
	{
		this.position = position;
		this.v = v;
		this.holder = holder;
	}

	public int getPosition()
	{
		return position;
	}

	public void setPosition(int position)
	{
		this.position = position;
	}

	public View getV()
	{
		return v;
	}

	public void setV(View v)
	{
		this.v = v;
	}

	public PinsViewProvider.ViewHolder getHolder()
	{
		return holder;
	}

	public void setHolder(PinsViewProvider.ViewHolder holder)
	{
		this.holder = holder;
	}
}
