package com.intalker.widget;

import com.intalker.xtomtimer.R;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

public class ControlFactory
{
	public static View createHoriSimpleSeparator(Context context)
	{
		View v = new View(context);
		ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(
				ViewGroup.LayoutParams.MATCH_PARENT, 1);
		v.setBackgroundColor(Color.LTGRAY);
		v.setLayoutParams(lp);
		return v;
	}
	
	public static View createHoriImageSeparator(Context context)
	{
		ImageView v = new ImageView(context);
		v.setImageResource(R.drawable.hori_separator);
		v.setScaleType(ScaleType.FIT_XY);
		ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(
				ViewGroup.LayoutParams.MATCH_PARENT,
				ViewGroup.LayoutParams.WRAP_CONTENT);

		v.setLayoutParams(lp);
		return v;
	}

	public static View createVertImageSeparator(Context context)
	{
		ImageView v = new ImageView(context);
		v.setImageResource(R.drawable.vert_separator);
		v.setScaleType(ScaleType.FIT_XY);
		ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(
				ViewGroup.LayoutParams.WRAP_CONTENT,
				ViewGroup.LayoutParams.MATCH_PARENT);

		v.setLayoutParams(lp);
		return v;
	}
}
