package com.intalker.xtomtimer.ui;

import android.content.Context;
import android.view.View;

import com.intalker.widget.AnimVertViewList;
import com.intalker.widget.SimpleButton;
import com.intalker.xtomtimer.MainActivity;
import com.intalker.xtomtimer.R;

public class FinishButtonList extends AnimVertViewList
{
	private SimpleButton mAdd2Button = null;
	private SimpleButton mTryAgainButton = null;
	private SimpleButton mDNFutton = null;
	private SimpleButton mDiscardButton = null;
	public FinishButtonList(Context context)
	{
		super(context);
		createButtons(context);
		addListeners();
	}

	private void createButtons(Context context)
	{
//		this.setBackgroundColor(ColorUtil.generateRandomColor());
//		mConfirmButton = new SimpleButton(context);
//		mConfirmButton.setText(R.string.confirm);
//		this.appendView(mConfirmButton, true);
		
		mAdd2Button = new SimpleButton(context);
		mAdd2Button.setText(R.string.add2);
		this.appendView(mAdd2Button, true);
		
		mTryAgainButton = new SimpleButton(context);
		mTryAgainButton.setText(R.string.tryagain);
		this.appendView(mTryAgainButton, true);
		
		mDNFutton = new SimpleButton(context);
		mDNFutton.setText(R.string.dnf);
		this.appendView(mDNFutton, true);
		
		mDiscardButton = new SimpleButton(context);
		mDiscardButton.setText(R.string.discard);
		this.appendView(mDiscardButton, false);
	}
	
	private void addListeners()
	{
//		mConfirmButton.setOnClickListener(new View.OnClickListener()
//		{
//			@Override
//			public void onClick(View v)
//			{
////				MainActivity.getInstance().getContent().recordScore(false);
//				MainActivity.getInstance().getContent().resetToReady();
//			}
//		});
		
		mAdd2Button.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				MainActivity.getInstance().getContent().markAsAdd2();
				MainActivity.getInstance().getContent().resetToReady();
			}
		});
		
		mTryAgainButton.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				MainActivity.getInstance().getContent().resetToReady();
			}
		});
		
		mDNFutton.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				MainActivity.getInstance().getContent().resetToReady();
			}
		});
		
		mDiscardButton.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				MainActivity.getInstance().getContent().resetToReady();
			}
		});
	}
}
