package com.intalker.widget.bar;

import android.content.Context;
import android.widget.LinearLayout;

public class BarSetView extends LinearLayout
{
	public BarSetView(Context context)
	{
		super(context);
		createUI(context);
		addTestData(context);
	}
	
	private void createUI(Context context)
	{
		this.setOrientation(LinearLayout.HORIZONTAL);
	}
	
	private void addTestData(Context context)
	{
		for (int i = 0; i < 30; ++i)
		{
			BarView barView = new BarView(context);
			this.addView(barView);
		}
	}
}