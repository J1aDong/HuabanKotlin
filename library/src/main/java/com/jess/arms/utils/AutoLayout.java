package com.jess.arms.utils;

import android.view.View;
import android.view.ViewGroup;

import com.zhy.autolayout.utils.AutoUtils;

/**
 * Created by J1aDong on 2017/1/19.
 */

public class AutoLayout
{

	public static void auto(View view)
	{
		if( view instanceof ViewGroup )
		{
			for( int i = 0; i < ((ViewGroup) view).getChildCount(); i++ )
			{
				AutoUtils.auto(view);
				auto(((ViewGroup) view).getChildAt(i));
			}
		}else {
            AutoUtils.auto(view);
        }
	}
}
