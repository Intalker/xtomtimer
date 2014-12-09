package com.intalker.xtomtimer.data;

import java.util.ArrayList;

public class SessionData
{
	private ArrayList<ScoreData> mScoreDataList = null;
	private float mMaxValue = Float.MIN_VALUE;
	private float mMinValue = Float.MAX_VALUE;
	
	public SessionData()
	{
		mScoreDataList = new ArrayList<ScoreData>();
	}
	
	public void addScore(ScoreData scoreData)
	{
		mScoreDataList.add(scoreData);
	}
	
	public ArrayList<ScoreData> getScoreList()
	{
		return mScoreDataList;
	}
	
	public void clearData()
	{
		mMinValue = Float.MAX_VALUE;
		mMaxValue = Float.MIN_VALUE;
		mScoreDataList.clear();
	}
	
	public void refreshStatistics()
	{
		mMinValue = Float.MAX_VALUE;
		mMaxValue = Float.MIN_VALUE;
		for(ScoreData scoreData : mScoreDataList)
		{
			float score = scoreData.getScore();
			if (mMinValue > score)
			{
				mMinValue = score;
			}
			if (mMaxValue < score)
			{
				mMaxValue = score;
			}
		}
	}
	
	public float getMaxValue()
	{
		return mMaxValue;
	}
	
	public float getMinValue()
	{
		return mMinValue;
	}
}
