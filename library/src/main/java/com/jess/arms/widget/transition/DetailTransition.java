package com.jess.arms.widget.transition;

import android.annotation.TargetApi;
import android.os.Build;
import android.transition.ChangeBounds;
import android.transition.ChangeImageTransform;
import android.transition.ChangeTransform;
import android.transition.TransitionSet;
import android.view.animation.AnticipateOvershootInterpolator;

@TargetApi(Build.VERSION_CODES.LOLLIPOP)
public class DetailTransition extends TransitionSet
{
	public DetailTransition(int duration, int delay)
	{
		setOrdering(ORDERING_TOGETHER);
		addTransition(new ChangeBounds()).addTransition(new ChangeTransform())
				.addTransition(new ChangeImageTransform()).setDuration(duration)
				.setStartDelay(delay)
				.setInterpolator(new AnticipateOvershootInterpolator());
	}
}