package com.j1adong.huabankotlin.event;

import com.facebook.drawee.view.SimpleDraweeView;
import com.j1adong.huabankotlin.adapter.PinsViewProvider;
import com.j1adong.huabankotlin.mvp.entity.PinsEntity;

/**
 * Created by J1aDong on 2017/1/16.
 */

public class EventGotoDetail
{

	SimpleDraweeView draweeView;
	PinsEntity pins;

	public EventGotoDetail(SimpleDraweeView draweeView, PinsEntity pins)
	{
		this.draweeView = draweeView;
		this.pins = pins;
	}

	public PinsEntity getPins()
	{
		return pins;
	}

	public void setPins(PinsEntity pins)
	{
		this.pins = pins;
	}

	public SimpleDraweeView getDraweeView()
	{
		return draweeView;
	}

	public void setDraweeView(SimpleDraweeView draweeView)
	{
		this.draweeView = draweeView;
	}
}
