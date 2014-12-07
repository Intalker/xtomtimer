package com.intalker.xtomtimer.ui;

import com.intalker.util.ColorUtil;
import com.intalker.widget.SpecTextView;
import android.content.Context;
import android.widget.RelativeLayout;

public class BottomADPanel extends RelativeLayout
{
	private SpecTextView mTextView = null;

	public BottomADPanel(Context context)
	{
		super(context);
		createUI(context);
	}

	private void createUI(Context context)
	{
		this.setBackgroundColor(ColorUtil.generateRandomColor());
		
		mTextView = new SpecTextView(context);
		mTextView.setText("AD area");
		RelativeLayout.LayoutParams textLP = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
		textLP.addRule(RelativeLayout.CENTER_IN_PARENT);
		this.addView(mTextView, textLP);
	}
}
