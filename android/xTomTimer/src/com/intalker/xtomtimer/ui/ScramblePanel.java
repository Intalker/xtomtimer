package com.intalker.xtomtimer.ui;

import com.intalker.util.DensityAdaptor;
import com.intalker.widget.SpecTextView;
import com.intalker.xtomtimer.config.LayoutConfig;

import android.content.Context;
import android.view.Gravity;
import android.widget.RelativeLayout;

public class ScramblePanel extends RelativeLayout
{
	private SpecTextView mCurScrambleTextView = null;
	public ScramblePanel(Context context)
	{
		super(context);
		createUI(context);
		setTestText();
	}
	
	private void createUI(Context context)
	{
		mCurScrambleTextView = new SpecTextView(context);
		mCurScrambleTextView.setTextSize(24f);
		mCurScrambleTextView.setGravity(Gravity.CENTER);
		RelativeLayout.LayoutParams curScrambleTextLP = new RelativeLayout.LayoutParams(
				RelativeLayout.LayoutParams.WRAP_CONTENT,
				RelativeLayout.LayoutParams.WRAP_CONTENT);
		curScrambleTextLP.topMargin = DensityAdaptor.getDensityIndependentValue(48);
		curScrambleTextLP.leftMargin = curScrambleTextLP.rightMargin = LayoutConfig.getMediumMargin();
		this.addView(mCurScrambleTextView, curScrambleTextLP);
	}
	
	private void setTestText()
	{
		mCurScrambleTextView.setText("R U' D' R2 D' R D B2 L B2 D' F B2 D2 R2 F' D2 F' L2");
	}
}
