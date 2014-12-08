package com.intalker.widget;

import android.content.Context;
import android.graphics.Canvas;

public class VerticalSpecTextView extends SpecTextView
{
	public VerticalSpecTextView(Context context)
	{
		super(context);
	}

	final boolean topDown = false;

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
	{
		super.onMeasure(heightMeasureSpec, widthMeasureSpec);
		setMeasuredDimension(getMeasuredHeight(), getMeasuredWidth());
	}

	@Override
	protected boolean setFrame(int l, int t, int r, int b)
	{
		return super.setFrame(l, t, l + (b - t), t + (r - l));
	}

//	@Override
//	protected void dispatchDraw(Canvas canvas)
//	{
//		// TODO Auto-generated method stub
//		super.dispatchDraw(canvas);
//		draw(canvas);
//	}

	
	@Override
	public void draw(Canvas canvas)
	{
		if (topDown)
		{
			canvas.translate(getHeight(), 0);
			canvas.rotate(90);
		}
		else
		{
			canvas.translate(0, getWidth());// - 30);
			canvas.rotate(-90);
		}
		canvas.clipRect(0, 0, getWidth(), getHeight(),
				android.graphics.Region.Op.REPLACE);
		super.draw(canvas);
	}

//	@Override
//	protected void onDraw(Canvas canvas)
//	{
//		if (topDown)
//		{
//			canvas.translate(getHeight(), 0);
//			canvas.rotate(90);
//		}
//		else
//		{
//			canvas.translate(0, getWidth());
//			canvas.rotate(-90);
//		}
//		canvas.clipRect(0, 0, getWidth(), getHeight(),
//				android.graphics.Region.Op.REPLACE);
//		super.onDraw(canvas);
//	}
}
