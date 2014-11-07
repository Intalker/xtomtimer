package com.intalker.xtomtimer.ui;

import java.util.ArrayList;

import com.intalker.widget.FlowLayout;
import com.intalker.xtomtimer.data.ScoreData;
import com.intalker.xtomtimer.data.SessionData;

import android.content.Context;
import android.graphics.Color;

public class SessionOverView extends FlowLayout
{
	public SessionOverView(Context context)
	{
		super(context);
	}
	
	public void updateView(SessionData sessionData)
	{
		this.removeAllViews();
		float min = Float.MAX_VALUE;
		float max = Float.MIN_VALUE;
		int minIndex = -1;
		int maxIndex = -1;
		
		ArrayList<ScoreData> scoreList = sessionData.getScoreList();
		if (scoreList.size() > 2)
		{
			for (int i = 0; i < scoreList.size(); ++i)
			{
				float score = scoreList.get(i).getScore();
				if (score < min)
				{
					min = score;
					minIndex = i;
				}
				if (score > max)
				{
					max = score;
					maxIndex = i;
				}
			}
		}
		//for(int x = 0; x < 100; ++x)
		for (int i = 0; i < scoreList.size(); ++i)
		{
			ScoreView scoreView = new ScoreView(getContext(), scoreList.get(i));
			if (i == minIndex)
			{
				scoreView.setTextColor(Color.GREEN);
			}
			if (i == maxIndex)
			{
				scoreView.setTextColor(Color.RED);
			}
			this.addView(scoreView);
		}
	}
	
	public void appendScore(ScoreData scoreData)
	{
		this.addView(new ScoreView(getContext(), scoreData));
	}
}
