package com.intalker.widget;

import java.util.ArrayList;


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class AnimVertViewList extends LinearLayout
{
	private ArrayList<View> mViewList = null;
	public AnimVertViewList(Context context)
	{
		super(context);
		mViewList = new ArrayList<View>();
		setupUI(context);
	}

	private void setupUI(Context context)
	{
		ViewGroup.LayoutParams listLP = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
		this.setLayoutParams(listLP);
		
		this.setOrientation(LinearLayout.VERTICAL);
	}
	
	public void appendView(View view, boolean appendSeparator)
	{
		this.addView(view);
		mViewList.add(view);
		if (appendSeparator)
		{
			this.addView(ControlFactory.createHoriSimpleSeparator(getContext()));
		}
	}
}
