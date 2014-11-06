package com.intalker.widget;

import com.intalker.util.DensityAdaptor;
import com.intalker.xtomtimer.config.ColorConfig;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

@SuppressLint("ClickableViewAccessibility")
public class SimpleButton extends RelativeLayout
{
	public final static int mSpecHeight = DensityAdaptor.getDensityIndependentValue(48);
	private SpecTextView mTextView = null;
	
	public SimpleButton(Context context)
	{
		super(context);
		createUI(context);
		addListeners();
	}

	private void createUI(Context context)
	{
		ViewGroup.LayoutParams btnLP = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, mSpecHeight);
		this.setLayoutParams(btnLP);
		
		mTextView = new SpecTextView(context);
		mTextView.setTextSize(24f);
		RelativeLayout.LayoutParams textLP = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
		textLP.addRule(RelativeLayout.CENTER_IN_PARENT);
		this.addView(mTextView, textLP);
	}
	
	public void setText(int textResId)
	{
		mTextView.setText(textResId);
	}
	
	public void setTextSize(float size)
	{
		mTextView.setTextSize(size);
	}
	
	@SuppressLint("ClickableViewAccessibility")
	private void addListeners()
	{
		this.setOnTouchListener(new View.OnTouchListener()
		{
			@Override
			public boolean onTouch(View v, MotionEvent event)
			{
				switch (event.getActionMasked())
				{
					case MotionEvent.ACTION_DOWN:
						SimpleButton.this.setBackgroundColor(ColorConfig.getButtonPressDownColor());
						break;
					case MotionEvent.ACTION_OUTSIDE:
					case MotionEvent.ACTION_UP:
					case MotionEvent.ACTION_CANCEL:
						SimpleButton.this.setBackgroundColor(Color.TRANSPARENT);
						break;
					default:
						break;
				}
				return false;
			}
		});
	}
}
