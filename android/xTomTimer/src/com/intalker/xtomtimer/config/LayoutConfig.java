package com.intalker.xtomtimer.config;

import com.intalker.util.DensityAdaptor;

public class LayoutConfig
{
	// General Parameters
	private static int smallMargin = -1;
	private static int mediumMargin = -1;
	private static int largeMargin = -1;

	// Score Content
	private static int scoreReadyTopMargin = -1;
	private static int scoreFinishTopMargin = -1;

	private static int finishButtonListBottomMargin = -1;

	private static int bottomADAreaHeight = -1;

	private static int barWidth = -1;
	private static int scorePanelHeight = -1;

	public static int getSmallMargin()
	{
		if (smallMargin < 0)
		{
			smallMargin = DensityAdaptor.getDensityIndependentValue(2);
		}
		return smallMargin;
	}

	public static int getMediumMargin()
	{
		if (mediumMargin < 0)
		{
			mediumMargin = DensityAdaptor.getDensityIndependentValue(6);
		}
		return mediumMargin;
	}

	public static int getLargeMargin()
	{
		if (largeMargin < 0)
		{
			largeMargin = DensityAdaptor.getDensityIndependentValue(12);
		}
		return largeMargin;
	}

	public static int getScoreReadyTopMargin()
	{
		if (scoreReadyTopMargin < 0)
		{
			scoreReadyTopMargin = DensityAdaptor.getScreenHeight() / 5 * 2;
		}
		return scoreReadyTopMargin;
	}

	public static int getScoreFinishTopMargin()
	{
		if (scoreFinishTopMargin < 0)
		{
			scoreFinishTopMargin = DensityAdaptor.getScreenHeight() / 5 * 2;// DensityAdaptor.getDensityIndependentValue(64);
		}
		return scoreFinishTopMargin;
	}

	public static int getFinishButtonListBottomMargin()
	{
		if (finishButtonListBottomMargin < 0)
		{
			finishButtonListBottomMargin = DensityAdaptor
					.getDensityIndependentValue(48);
		}
		return finishButtonListBottomMargin;
	}

	public static int getBottomADAreaHeight()
	{
		if (bottomADAreaHeight < 0)
		{
			bottomADAreaHeight = DensityAdaptor.getDensityIndependentValue(72);
		}
		return bottomADAreaHeight;
	}

	public static int getBarWidth()
	{
		if (barWidth < 0)
		{
			barWidth = DensityAdaptor.getDensityIndependentValue(24);
		}
		return barWidth;
	}
	
	public static int getScorePanelHeight()
	{
		if (scorePanelHeight < 0)
		{
			scorePanelHeight = DensityAdaptor.getScreenHeight() / 5;
		}
		return scorePanelHeight;
	}
}