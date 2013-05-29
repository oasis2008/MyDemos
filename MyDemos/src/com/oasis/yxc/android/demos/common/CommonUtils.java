package com.oasis.yxc.android.demos.common;

import android.view.View;
import android.view.animation.TranslateAnimation;

public class CommonUtils {
	private CommonUtils() { 
	}

	private static CommonUtils commonUtils;

	public static synchronized CommonUtils getInstance() {
		if (commonUtils == null)
			commonUtils = new CommonUtils();
		return commonUtils;
	}

	public void slide(View v, int startX, int toX, int startY, int toY) {
		TranslateAnimation anim = new TranslateAnimation(startX, toX, startY,
				toY);
		anim.setDuration(200);
		anim.setFillAfter(true);
		v.startAnimation(anim);
	}
}
