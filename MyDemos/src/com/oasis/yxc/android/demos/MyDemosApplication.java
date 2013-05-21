package com.oasis.yxc.android.demos;

import android.app.Application;

public class MyDemosApplication extends Application {

	@Override
	public void onCreate() {
		super.onCreate();
		
//		 PreferenceManager.setDefaultValues(this, R.xml.default_values, false);
	}

	@Override
	public void onTerminate() {
		// TODO Auto-generated method stub
		super.onTerminate();
	}
	
}
