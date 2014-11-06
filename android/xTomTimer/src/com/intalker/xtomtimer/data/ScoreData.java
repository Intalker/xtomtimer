package com.intalker.xtomtimer.data;

import java.util.Date;

import com.intalker.util.DataUtil;

public class ScoreData
{
	private Date mTime = null;
	private float mScore = -1;
	private String mScramble = "";
	private String mUUID = "";
	
	public ScoreData(float score, String scramble)
	{
		mUUID = DataUtil.makeUUID();
		mScore = score;
		mScramble = scramble;
		mTime = new Date(System.currentTimeMillis());
	}
	
	public void setScore(float score)
	{
		mScore = score;
	}
	
	public void add2()
	{
		mScore += 2f;
	}
	
	public float getScore()
	{
		return mScore;
	}
	
	public String getScramble()
	{
		return mScramble;
	}
	
	public String getTime()
	{
		return mTime.toString();
	}
	
	public String getUUID()
	{
		return mUUID;
	}
}
