package com.intalker.widget.bar;

import com.intalker.xtomtimer.config.LayoutConfig;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;

public class BarSetScrollView extends HorizontalScrollView
{
	private BarSetView mContent = null;

	public BarSetScrollView(Context context)
	{
		super(context);
		createUI(context);
	}

	private void createUI(Context context)
	{
//		this.setScrollbarFadingEnabled(false);
		this.setHorizontalScrollBarEnabled(false);
		ViewGroup.LayoutParams panelLP = new ViewGroup.LayoutParams(
				ViewGroup.LayoutParams.MATCH_PARENT,
				LayoutConfig.getScorePanelHeight());
		mContent = new BarSetView(context);
		this.addView(mContent, panelLP);
	}
}
