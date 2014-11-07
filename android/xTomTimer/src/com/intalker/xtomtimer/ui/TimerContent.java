package com.intalker.xtomtimer.ui;

import java.text.DecimalFormat;
import java.util.Timer;
import java.util.TimerTask;

import com.intalker.util.DensityAdaptor;
import com.intalker.widget.FlowLayout;
import com.intalker.widget.SpecTextView;
import com.intalker.xtomtimer.AnimationUtil;
import com.intalker.xtomtimer.R;
import com.intalker.xtomtimer.config.ColorConfig;
import com.intalker.xtomtimer.config.LayoutConfig;
import com.intalker.xtomtimer.config.TimeConfig;
import com.intalker.xtomtimer.data.ScoreData;
import com.intalker.xtomtimer.data.SessionData;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

@SuppressLint("ClickableViewAccessibility")
public class TimerContent extends RelativeLayout
{
	private static final int MSG_TICKINGTIMER = 1;
	private static final int MSG_READYTIMER = 2;

	private static final int STATUS_READY = 1;
	private static final int STATUS_RUNNING = 2;
	private static final int STATUS_FINISHED = 3;
	private static final int STATUS_RESET = 4;

	private int mCurrentStatus = STATUS_READY;

	private long mStartTime = -1;
	private Timer mTickTimer = null;
	private TimerTask mTimerTask = null;

	private Timer mReadyTimer = null;
	private Handler mHandler = null;
	private DecimalFormat tickFormat = new DecimalFormat("##0.000");

	private SpecTextView mTickTextView = null;

	private FinishButtonList mFinishButtonList = null;

	private ScramblePanel mScramblePanel = null;

	private boolean mHasPressedLongEnough = false;

	private SessionOverView mCurSessionPanel = null;

	private SessionData mCurSessionData = null;
	private ScoreData mCurScoreData = null;

	private float mCurTickingValue = 0f;

	public TimerContent(Context context)
	{
		super(context);
		createUI(context);
		createTimer();

		addListeners();

		mCurSessionData = new SessionData();
	}

	private void createUI(Context context)
	{
		mCurSessionPanel = new SessionOverView(context);
		RelativeLayout.LayoutParams sessionPanelLP = new RelativeLayout.LayoutParams(
				RelativeLayout.LayoutParams.MATCH_PARENT,
				RelativeLayout.LayoutParams.WRAP_CONTENT);
		sessionPanelLP.leftMargin = sessionPanelLP.rightMargin = sessionPanelLP.topMargin = LayoutConfig
				.getLargeMargin();
		this.addView(mCurSessionPanel, sessionPanelLP);
		mCurSessionPanel.setVisibility(View.GONE);

		mTickTextView = new SpecTextView(context);
		mTickTextView.setText(R.string.ready);
		mTickTextView.setTextSize(72.0f);
		RelativeLayout.LayoutParams tickLP = new RelativeLayout.LayoutParams(
				RelativeLayout.LayoutParams.WRAP_CONTENT,
				RelativeLayout.LayoutParams.WRAP_CONTENT);
		tickLP.addRule(RelativeLayout.CENTER_HORIZONTAL);
		tickLP.topMargin = LayoutConfig.getScoreReadyTopMargin();
		this.addView(mTickTextView, tickLP);

		mFinishButtonList = new FinishButtonList(context);
		RelativeLayout.LayoutParams finishButtonLP = new RelativeLayout.LayoutParams(
				RelativeLayout.LayoutParams.MATCH_PARENT,
				RelativeLayout.LayoutParams.WRAP_CONTENT);
		finishButtonLP.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
		finishButtonLP.bottomMargin = LayoutConfig
				.getFinishButtonListBottomMargin();
		this.addView(mFinishButtonList, finishButtonLP);
		mFinishButtonList.setVisibility(View.GONE);

		mScramblePanel = new ScramblePanel(context);
		RelativeLayout.LayoutParams scramblePanelLP = new RelativeLayout.LayoutParams(
				RelativeLayout.LayoutParams.MATCH_PARENT,
				RelativeLayout.LayoutParams.WRAP_CONTENT);
		scramblePanelLP.topMargin = LayoutConfig.getLargeMargin();
		this.addView(mScramblePanel, scramblePanelLP);
		
//		FlowLayout fl = new FlowLayout(context);
//		for(int i = 0; i < 50; ++i)
//		{
//			fl.addView(new ScoreView(context, new ScoreData(i, "")));
//		}
//		this.addView(fl);
	}

	private void addListeners()
	{
		this.setOnTouchListener(new View.OnTouchListener()
		{

			@Override
			public boolean onTouch(View v, MotionEvent event)
			{
				switch (event.getActionMasked())
				{
					case MotionEvent.ACTION_DOWN:
						switch (mCurrentStatus)
						{
							case STATUS_READY:
								startReadyTiming();
								break;
							case STATUS_RUNNING:
								// mCurrentStatus = STATUS_FINISHED;
								// mTickTimer.cancel();
								// animateScoreTextView(mTickTextView.getY(),
								// LayoutConfig.getScoreFinishTopMargin(),
								// 96f, false);
								finishCurTicking();
								break;
							case STATUS_FINISHED:
								// float fromY = mTickTextView.getY();
								// float toY = LayoutConfig
								// .getScoreReadyTopMargin();
								// animateScoreTextView(fromY, toY, 72f, true);
								// mCurrentStatus = STATUS_RESET;
								resetToReady();
								break;
							case STATUS_RESET:
								break;
							default:
								break;
						}
						break;
					case MotionEvent.ACTION_UP:
						if (null != mReadyTimer)
						{
							mReadyTimer.cancel();
						}
						switch (mCurrentStatus)
						{
							case STATUS_READY:
								if (mHasPressedLongEnough)
								{
									mHasPressedLongEnough = false;
									startTicking();
									mCurrentStatus = STATUS_RUNNING;
									mCurScoreData = null;
								}
								break;
							case STATUS_RUNNING:
								break;
							case STATUS_FINISHED:
								break;
							case STATUS_RESET:
								// mCurrentStatus = STATUS_READY;
								break;
							default:
								break;
						}
						break;
					default:
						break;
				}
				return true;
			}
		});
	}

	@SuppressLint("HandlerLeak")
	private void createTimer()
	{
		mHandler = new Handler()
		{
			@Override
			public void handleMessage(Message msg)
			{
				switch (msg.arg1)
				{
					case MSG_TICKINGTIMER:
						if (mCurrentStatus == STATUS_RUNNING)
						{
							long millisec = System.currentTimeMillis()
									- mStartTime;
							float timeInSec = millisec * 0.001f;
							// mTickTextView.setTextColor(ColorUtil.generateRandomColor());
							mTickTextView.setText(tickFormat.format(timeInSec));
							mCurTickingValue = timeInSec;
						}
						break;
					case MSG_READYTIMER:
						mTickTextView.setTextColor(ColorConfig
								.getTickColorReady());
						break;
					default:
						break;
				}
				// super.handleMessage(msg);
			}

		};
	}

	private void startTicking()
	{
		mTimerTask = new TimerTask()
		{
			@Override
			public void run()
			{
				Message msg = new Message();
				msg.arg1 = MSG_TICKINGTIMER;
				mHandler.sendMessage(msg);
			}
		};
		mTickTimer = new Timer();
		mStartTime = System.currentTimeMillis();
		mTickTimer.schedule(mTimerTask, 0, 1);
		mTickTextView.setTextColor(ColorConfig.getTickColorRunning());

		AnimationUtil.fadeOutFinishButtons(mScramblePanel);
	}

	private void startReadyTiming()
	{
		TimerTask readyTimerTask = new TimerTask()
		{
			@Override
			public void run()
			{
				mHasPressedLongEnough = true;
				Message msg = new Message();
				msg.arg1 = MSG_READYTIMER;
				mHandler.sendMessage(msg);
			}
		};

		mReadyTimer = new Timer();
		mReadyTimer.schedule(readyTimerTask, TimeConfig.getLongPressDuration());
	}

	private void animateScoreTextView(final float fromY, final float toY,
			final float fontSize, boolean reset)
	{
		ValueAnimator translateAnimation = ValueAnimator.ofFloat(fromY, toY);
		translateAnimation
				.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
				{
					@Override
					public void onAnimationUpdate(ValueAnimator valueAnimator)
					{
						mTickTextView.setY((Float) valueAnimator
								.getAnimatedValue());
					}
				});
		translateAnimation.setDuration(TimeConfig.getScaleAnimDuration());

		float fromSize = mTickTextView.getTextSize()
				/ DensityAdaptor.getFactor();
		ValueAnimator fontSizeAnimation = ValueAnimator.ofFloat(fromSize,
				fontSize);
		fontSizeAnimation
				.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
				{

					@Override
					public void onAnimationUpdate(ValueAnimator animation)
					{
						mTickTextView.setTextSize((Float) animation
								.getAnimatedValue());
					}
				});
		fontSizeAnimation.setDuration(TimeConfig.getScaleAnimDuration());

		AnimatorSet animationSet = new AnimatorSet();

		if (reset)
		{
			AnimationUtil.fadeOutFinishButtons(mFinishButtonList);
			AnimationUtil.fadeOutFinishButtons(mCurSessionPanel);
			animationSet.addListener(new AnimatorListener()
			{

				@Override
				public void onAnimationStart(Animator animation)
				{
				}

				@Override
				public void onAnimationEnd(Animator animation)
				{
					ValueAnimator alphaAnimation = ValueAnimator
							.ofFloat(1f, 0f);
					alphaAnimation.setDuration(TimeConfig.getFadeAnimDuration());
					alphaAnimation
							.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
							{
								@Override
								public void onAnimationUpdate(
										ValueAnimator animation)
								{
									mTickTextView.setAlpha((Float) animation
											.getAnimatedValue());
								}
							});
					alphaAnimation.addListener(new AnimatorListener()
					{

						@Override
						public void onAnimationStart(Animator animation)
						{
						}

						@Override
						public void onAnimationEnd(Animator animation)
						{
							AnimationUtil.fadeInFinishButtons(mScramblePanel);
							mTickTextView.setTextColor(ColorConfig
									.getTickColorInactive());
							mTickTextView.setText(R.string.ready);
							ValueAnimator alphaAnimation = ValueAnimator
									.ofFloat(0f, 1f);
							alphaAnimation.setDuration(TimeConfig
									.getFadeAnimDuration());
							alphaAnimation
									.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
									{
										@Override
										public void onAnimationUpdate(
												ValueAnimator animation)
										{
											mTickTextView.setAlpha((Float) animation
													.getAnimatedValue());
										}
									});
							alphaAnimation.start();
						}

						@Override
						public void onAnimationCancel(Animator animation)
						{
						}

						@Override
						public void onAnimationRepeat(Animator animation)
						{
						}

					});

					alphaAnimation.start();
				}

				@Override
				public void onAnimationCancel(Animator animation)
				{
				}

				@Override
				public void onAnimationRepeat(Animator animation)
				{
				}

			});
		}
		else
		{
			animationSet.addListener(new AnimatorListener()
			{

				@Override
				public void onAnimationStart(Animator animation)
				{
				}

				@Override
				public void onAnimationEnd(Animator animation)
				{
					AnimationUtil.fadeInFinishButtons(mFinishButtonList);
					AnimationUtil.fadeInFinishButtons(mCurSessionPanel);
				}

				@Override
				public void onAnimationCancel(Animator animation)
				{
				}

				@Override
				public void onAnimationRepeat(Animator animation)
				{
				}

			});
		}

		animationSet.playTogether(translateAnimation, fontSizeAnimation);
		animationSet.start();

	}

	public void resetToReady()
	{
		float fromY = mTickTextView.getY();
		float toY = LayoutConfig.getScoreReadyTopMargin();
		animateScoreTextView(fromY, toY, 72f, true);
		mCurrentStatus = STATUS_READY;
	}

	public void finishCurTicking()
	{
		// float score = Float.parseFloat(mTickTextView.getText().toString());
		String scramble = mScramblePanel.getScrambleStr();
		mCurScoreData = new ScoreData(mCurTickingValue, scramble);
		mCurrentStatus = STATUS_FINISHED;
		mTickTimer.cancel();
		animateScoreTextView(mTickTextView.getY(),
				LayoutConfig.getScoreFinishTopMargin(), 96f, false);
		recordScore();
		mCurSessionPanel.updateView(mCurSessionData);
	}
	
	public void markAsAdd2()
	{
		if (null != mCurScoreData)
		{
			mCurScoreData.add2();
		}
	}

	public void recordScore()
	{
		if (null != mCurScoreData)
		{
			mCurSessionData.addScore(mCurScoreData);
		}
	}
}
