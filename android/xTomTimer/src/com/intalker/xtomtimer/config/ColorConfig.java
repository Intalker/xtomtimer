package com.intalker.xtomtimer.config;

import com.intalker.util.ColorUtil;

import android.graphics.Color;

public class ColorConfig
{
	private static int tickColorInactive = Color.DKGRAY;
	private static int tickColorReady = Color.GREEN;
	private static int tickColorRunning = Color.BLACK;
	private static int buttonPressDownColor = ColorUtil.argb(255, 183, 219, 255);
	
	public static int getTickColorInactive()
	{
		return tickColorInactive;
	}
	
	public static int getTickColorReady()
	{
		return tickColorReady;
	}
	
	public static int getTickColorRunning()
	{
		return tickColorRunning;
	}
	
	public static int getButtonPressDownColor()
	{
		return buttonPressDownColor;
	}
}
