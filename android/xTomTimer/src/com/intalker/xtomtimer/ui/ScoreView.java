package com.intalker.xtomtimer.ui;

import java.text.DecimalFormat;

import android.content.Context;
import android.view.Gravity;

import com.intalker.widget.SpecTextView;
import com.intalker.xtomtimer.R;
import com.intalker.xtomtimer.data.ScoreData;

public class ScoreView extends SpecTextView
{
	private ScoreData mData = null;
	private DecimalFormat tickFormat = new DecimalFormat("##0.000");
	
	public ScoreView(Context context, ScoreData data)
	{
		super(context);
		this.setBackgroundResource(R.drawable.roundcorner_bg);
		this.setGravity(Gravity.CENTER);
		this.setTextSize(22f);
		mData = data;
		updateUI();
	}
	
	private void updateUI()
	{
		this.setText(tickFormat.format(mData.getScore()));
	}
}
