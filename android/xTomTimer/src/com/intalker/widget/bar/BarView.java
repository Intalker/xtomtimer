package com.intalker.widget.bar;

import java.text.DecimalFormat;

import com.intalker.widget.SpecTextView;
import com.intalker.widget.VerticalSpecTextView;
import com.intalker.xtomtimer.R;
import com.intalker.xtomtimer.config.LayoutConfig;
import android.content.Context;
import android.graphics.Color;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

public class BarView extends RelativeLayout
{
	private RelativeLayout mDarkenView = null;
	private SpecTextView mLabel = null;
	
	private DecimalFormat valueFormat = new DecimalFormat("##0.000");
	
	private final static int maxHeight = LayoutConfig.getMaxBarHeight();
	private float mMin = -1f;
	private float mMax = -1f;
	private float mValue = -1f;
	
	public BarView(Context context, float max, float min, float value)
	{
		super(context);
		createUI(context);
		setValue(max, min, value);
	}
	
	private void createUI(Context context)
	{
		ViewGroup.LayoutParams barWidth = new ViewGroup.LayoutParams(
				LayoutConfig.getBarWidth(), ViewGroup.LayoutParams.MATCH_PARENT);
		this.setLayoutParams(barWidth);
		
		mDarkenView = new RelativeLayout(context);
		//mDarkenView.setBackgroundResource(R.drawable.roundcorner_bg);
		//mDarkenView.setBackgroundColor(Color.LTGRAY);
		mDarkenView.setBackgroundResource(R.drawable.bar_bg);
		RelativeLayout.LayoutParams darkenLP = new RelativeLayout.LayoutParams(
				LayoutConfig.getBarWidth(), 0);//RelativeLayout.LayoutParams.WRAP_CONTENT);
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
//		mLabel.setText("12.3456789");
	}
	
	private void setValue(float max, float min, float value)
	{
		mMax = max;
		mMin = min;
		mValue = value;
		
		RelativeLayout.LayoutParams barLP = (LayoutParams) mDarkenView.getLayoutParams();
		barLP.height = (int) (maxHeight * mValue / mMax);
		mLabel.setText(valueFormat.format(value));
	}
	
	
}
