package com.jess.arms.widget.recyclerview;

import android.support.v7.widget.RecyclerView;

/**
 * Created by J1aDong on 2017/1/15.
 */

public abstract class HideScrollListener extends RecyclerView.OnScrollListener
{

	abstract public void hide();

	abstract public void show();

	boolean isIdle;
	int scrollY;

	@Override
	public void onScrollStateChanged(RecyclerView recyclerView, int newState)
	{
		super.onScrollStateChanged(recyclerView, newState);
		isIdle = newState == RecyclerView.SCROLL_STATE_DRAGGING;
		if( isIdle )
		{
			scrollY = 0;
		}
	}

	@Override
	public void onScrolled(RecyclerView recyclerView, int dx, int dy)
	{
		super.onScrolled(recyclerView, dx, dy);
		scrollY += dy;
		// show or hide header view
		if( scrollY > 2 )
		{
			hide();
		}
		else
		{
			show();
		}
	}
}
