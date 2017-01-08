package com.jess.arms.widget;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by J1aDong on 2016/12/7.
 */

public class CustomViewPager extends ViewPager
{
	private boolean scrollble = false;

	/******* public method **********/
	public void setScrollble(boolean isCanScroll)
	{
		this.scrollble = isCanScroll;
	}

	/******* public method **********/

	public CustomViewPager(Context context)
	{
		super(context);
	}

	public CustomViewPager(Context context, AttributeSet attrs)
	{
		super(context, attrs);
	}

	@Override
	public boolean onTouchEvent(MotionEvent ev)
	{
		return this.scrollble && super.onTouchEvent(ev);
	}

	@Override
	public boolean onInterceptTouchEvent(MotionEvent ev)
	{
		return this.scrollble && super.onInterceptTouchEvent(ev);
	}
}
