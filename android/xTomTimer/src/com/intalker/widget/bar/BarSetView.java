package com.intalker.widget.bar;

import java.util.Random;

import com.intalker.util.DensityAdaptor;
import com.intalker.xtomtimer.config.LayoutConfig;

import android.content.Context;
import android.widget.LinearLayout;

public class BarSetView extends LinearLayout
{
	public BarSetView(Context context)
	{
		super(context);
		createUI(context);
//		addTestData(context);
	}
	
	private void createUI(Context context)
	{
		this.setOrientation(LinearLayout.HORIZONTAL);
		int horiPadding = (DensityAdaptor.getScreenWidth() - LayoutConfig.getBarWidth()) / 2;
		this.setPadding(horiPadding, 0, horiPadding, 0);
	}
	
//	private void addTestData(Context context)
//	{
//		Random rand = new Random();
//		for (int i = 0; i < 30; ++i)
//		{
//			BarView barView = new BarView(context);
//			this.addView(barView);
//			barView.setValue(0, 100, 50 + rand.nextInt(50));
//		}
//	}
}