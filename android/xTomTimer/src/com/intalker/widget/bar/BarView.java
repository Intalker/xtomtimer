package com.intalker.widget.bar;

import com.intalker.util.ColorUtil;
import com.intalker.util.DensityAdaptor;
import com.intalker.widget.SpecTextView;
import com.intalker.widget.VerticalSpecTextView;
import com.intalker.xtomtimer.config.LayoutConfig;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

public class BarView extends RelativeLayout
{
	private RelativeLayout mDarkenView = null;
	private SpecTextView mLabel = null;
	public BarView(Context context)
	{
		super(context);
		createUI(context);
	}
	
	private void createUI(Context context)
	{
		ViewGroup.LayoutParams barWidth = new ViewGroup.LayoutParams(
				LayoutConfig.getBarWidth(), ViewGroup.LayoutParams.MATCH_PARENT);
		this.setLayoutParams(barWidth);
		
		mDarkenView = new RelativeLayout(context);
		//mDarkenView.setBackgroundResource(R.drawable.roundcorner_bg);
		mDarkenView.setBackgroundColor(ColorUtil.generateRandomColor());//Color.LTGRAY);
		RelativeLayout.LayoutParams darkenLP = new RelativeLayout.LayoutParams(
				LayoutConfig.getBarWidth(),
				DensityAdaptor.getDensityIndependentValue(100));//RelativeLayout.LayoutParams.WRAP_CONTENT);
		darkenLP.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
		this.addView(mDarkenView, darkenLP);
		
		mLabel = new VerticalSpecTextView(context);
//		mLabel.setBackgroundColor(ColorUtil.generateRandomColor());
		RelativeLayout.LayoutParams labelLP = new RelativeLayout.LayoutParams(
				RelativeLayout.LayoutParams.WRAP_CONTENT,
				RelativeLayout.LayoutParams.WRAP_CONTENT);
		labelLP.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
		labelLP.addRule(RelativeLayout.CENTER_HORIZONTAL);
		this.addView(mLabel, labelLP);
		mLabel.setTextSize(12f);
		mLabel.setText("12.3456789");
	}
}
