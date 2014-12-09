package com.intalker.widget.bar;

import com.intalker.xtomtimer.config.LayoutConfig;
import com.intalker.xtomtimer.data.ScoreData;
import com.intalker.xtomtimer.data.SessionData;

import android.content.Context;
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
	
	public void scrollToEnd()
	{
		this.post(new Runnable(){

			@Override
			public void run()
			{
				BarSetScrollView.this.scrollTo(mContent.getMeasuredWidth(), 0);
			}

		});
	}
	
	public void update(SessionData sessionData)
	{
		mContent.removeAllViews();
		sessionData.refreshStatistics();
		for(ScoreData scoreData : sessionData.getScoreList())
		{
			mContent.addView(new BarView(getContext(), sessionData.getMaxValue(), sessionData.getMinValue(), scoreData.getScore()));
		}
	}
}
