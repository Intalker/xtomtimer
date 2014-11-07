package com.intalker.xtomtimer.ui;

import java.util.ArrayList;

import com.intalker.xtomtimer.data.ScoreData;
import com.intalker.xtomtimer.data.SessionData;

import android.content.Context;
import android.widget.RelativeLayout;

public class SessionOverlapView extends RelativeLayout
{
	public SessionOverlapView(Context context)
	{
		super(context);
	}
	
	public void updateView(SessionData sessionData)
	{
		this.removeAllViews();
		ArrayList<ScoreData> scoreList = sessionData.getScoreList();
		for (int i = 0; i < scoreList.size(); ++i)
		{
			RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
					RelativeLayout.LayoutParams.WRAP_CONTENT,
					RelativeLayout.LayoutParams.WRAP_CONTENT);
			lp.leftMargin = i * 30;
			lp.topMargin = i * 10;
			this.addView(new ScoreView(getContext(), scoreList.get(i)), lp);
		}
	}
}
