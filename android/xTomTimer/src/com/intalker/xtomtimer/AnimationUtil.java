package com.intalker.xtomtimer;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.animation.Animator.AnimatorListener;
import android.view.View;

import com.intalker.xtomtimer.config.TimeConfig;

public class AnimationUtil
{
	public static void fadeInFinishButtons(final View view)
	{
		ValueAnimator alphaAnimation = ValueAnimator.ofFloat(0f, 1f);
		alphaAnimation.setDuration(TimeConfig.getFadeAnimDuration());
		alphaAnimation
				.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
				{
					@Override
					public void onAnimationUpdate(ValueAnimator animation)
					{
						view.setAlpha((Float) animation.getAnimatedValue());
					}
				});
		alphaAnimation.addListener(new AnimatorListener()
		{

			@Override
			public void onAnimationStart(Animator animation)
			{
				view.setVisibility(View.VISIBLE);
			}

			@Override
			public void onAnimationEnd(Animator animation)
			{
			}

			@Override
			public void onAnimationCancel(Animator animation)
			{
			}

			@Override
			public void onAnimationRepeat(Animator animation)
			{
			}
		});
		alphaAnimation.start();
	}

	public static void fadeOutFinishButtons(final View view)
	{
		ValueAnimator alphaAnimation = ValueAnimator.ofFloat(1f, 0f);
		alphaAnimation.setDuration(TimeConfig.getFadeAnimDuration());
		alphaAnimation
				.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
				{
					@Override
					public void onAnimationUpdate(ValueAnimator animation)
					{
						view.setAlpha((Float) animation.getAnimatedValue());
					}
				});
		alphaAnimation.addListener(new AnimatorListener()
		{

			@Override
			public void onAnimationStart(Animator animation)
			{
			}

			@Override
			public void onAnimationEnd(Animator animation)
			{
				view.setVisibility(View.GONE);
			}

			@Override
			public void onAnimationCancel(Animator animation)
			{
			}

			@Override
			public void onAnimationRepeat(Animator animation)
			{
			}

		});
		alphaAnimation.start();
	}
}
