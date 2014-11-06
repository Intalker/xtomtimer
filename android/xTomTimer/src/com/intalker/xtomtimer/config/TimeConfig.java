package com.intalker.xtomtimer.config;

public class TimeConfig
{
	private static long longPressDuration = 500;
	private static long scaleAnimDuration = 600;
	private static long fadeAnimDuration = 200;
	
	public static long getLongPressDuration()
	{
		return longPressDuration;
	}
	
	public static long getScaleAnimDuration()
	{
		return scaleAnimDuration;
	}
	
	public static long getFadeAnimDuration()
	{
		return fadeAnimDuration;
	}
}
