package com.intalker.xtomtimer.config;

import com.intalker.util.DensityAdaptor;

public class LayoutConfig {
	//General Parameters
	private static int smallMargin = -1;
	private static int mediumMargin = -1;
	private static int largeMargin = -1;
	
	//Score Content
	private static int scoreReadyTopMargin = -1;
	private static int scoreFinishTopMargin = -1;
	
	private static int finishButtonListBottomMargin = -1;
	
	public static int getSmallMargin() {
		if(smallMargin < 0) {
			smallMargin = DensityAdaptor.getDensityIndependentValue(2);
		}
		return smallMargin;
	}
	
	public static int getMediumMargin() {
		if(mediumMargin < 0) {
			mediumMargin = DensityAdaptor.getDensityIndependentValue(6);
		}
		return mediumMargin;
	}
	
	public static int getLargeMargin() {
		if(largeMargin < 0) {
			largeMargin = DensityAdaptor.getDensityIndependentValue(12);
		}
		return largeMargin;
	}
	
	public static int getScoreReadyTopMargin() {
		if(scoreReadyTopMargin < 0) {
			scoreReadyTopMargin = DensityAdaptor.getScreenHeight() / 5 * 2;
		}
		return scoreReadyTopMargin;
	}
	
	public static int getScoreFinishTopMargin() {
		if(scoreFinishTopMargin < 0) {
			scoreFinishTopMargin = DensityAdaptor.getDensityIndependentValue(64);
		}
		return scoreFinishTopMargin;
	}
	
	public static int getFinishButtonListBottomMargin() {
		if(finishButtonListBottomMargin < 0) {
			finishButtonListBottomMargin = DensityAdaptor.getDensityIndependentValue(48);
		}
		return finishButtonListBottomMargin;
	}
}