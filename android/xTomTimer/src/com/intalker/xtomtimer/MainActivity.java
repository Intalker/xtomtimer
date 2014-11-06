package com.intalker.xtomtimer;

import com.intalker.xtomtimer.ui.TimerContent;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends Activity {

	private static MainActivity instance = null;
	public static MainActivity getInstance()
	{
		return instance;
	}
	
	private TimerContent mContent = null;
	
	public TimerContent getContent()
	{
		return mContent;
	}
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setWindowStyle();
        instance = this;
        mContent = new TimerContent(this);
        this.setContentView(mContent);
    }
    
	@SuppressLint("InlinedApi")
	private void setWindowStyle()
	{
		getWindow().requestFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);

		if (com.intalker.util.DeviceUtility.getOsVersion() > 13)
		{
			// Android 3.x will not enable HA.
			getWindow().setFlags(
					WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED,
					WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED);
		}
		com.intalker.util.DensityAdaptor.init(this);
	}
}
