package com.intalker.xtomtimer.data;

import java.util.ArrayList;

public class SessionData
{
	private ArrayList<ScoreData> mScoreDataList = null;
	
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
}
