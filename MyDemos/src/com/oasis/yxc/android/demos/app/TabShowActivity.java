package com.oasis.yxc.android.demos.app;

import com.oasis.yxc.android.demos.R;
import com.oasis.yxc.android.demos.activity.TabFollowActivity;
import com.oasis.yxc.android.demos.activity.TabNewsActivity;
import com.oasis.yxc.android.demos.activity.TabPicActivity;
import com.oasis.yxc.android.demos.activity.TabTopicActivity;
import com.oasis.yxc.android.demos.activity.TabVoteActivity;
import com.oasis.yxc.android.demos.common.CommonUtils;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.RelativeLayout;
import android.widget.TabHost;

public class TabShowActivity extends TabActivity {

	private TabHost tabHost;
	private RadioGroup radioGroup;
	private RelativeLayout bottom;
	private ImageView slideview;
	private int startLeft;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.tabshow_main_layout);
		initViews();
		initTabs();

	}

	private void initViews() {
		radioGroup = (RadioGroup) findViewById(R.id.radiogroup);
		radioGroup.setOnCheckedChangeListener(checkedChangeListener);
		bottom = (RelativeLayout) findViewById(R.id.layout_bottom);
		slideview = new ImageView(this);
		slideview.setImageResource(R.drawable.tab_front_bg);
		bottom.addView(slideview);
	}

	private void initTabs() {
		tabHost = getTabHost();
		tabHost.addTab(tabHost.newTabSpec("news").setIndicator("NEWS")
				.setContent(new Intent(this, TabNewsActivity.class)));
		tabHost.addTab(tabHost.newTabSpec("topic").setIndicator("TOPIC")
				.setContent(new Intent(this, TabTopicActivity.class)));
		tabHost.addTab(tabHost.newTabSpec("picture").setIndicator("PICTURE")
				.setContent(new Intent(this, TabPicActivity.class)));
		tabHost.addTab(tabHost.newTabSpec("follow").setIndicator("FOLLOW")
				.setContent(new Intent(this, TabFollowActivity.class)));
		tabHost.addTab(tabHost.newTabSpec("vote").setIndicator("VOTE")
				.setContent(new Intent(this, TabVoteActivity.class)));

	}

	private OnCheckedChangeListener checkedChangeListener = new OnCheckedChangeListener() {

		@Override
		public void onCheckedChanged(RadioGroup group, int checkedId) {
			switch (checkedId) {
			case R.id.radio_news:
				tabHost.setCurrentTabByTag("news");
				CommonUtils.getInstance().slide(slideview, startLeft, 0, 0, 0);
				startLeft = 0;
				break;
			case R.id.radio_topic:
				tabHost.setCurrentTabByTag("topic");
				CommonUtils.getInstance().slide(slideview, startLeft,
						slideview.getWidth(), 0, 0);
				startLeft = slideview.getWidth();
				break;
			case R.id.radio_pic:
				tabHost.setCurrentTabByTag("picture");
				CommonUtils.getInstance().slide(slideview, startLeft,
						slideview.getWidth() * 2, 0, 0);
				startLeft = slideview.getWidth() * 2;
				break;
			case R.id.radio_follow:
				tabHost.setCurrentTabByTag("follow");
				CommonUtils.getInstance().slide(slideview, startLeft,
						slideview.getWidth() * 3, 0, 0);
				startLeft = slideview.getWidth() * 3;
				break;
			case R.id.radio_vote:
				tabHost.setCurrentTabByTag("vote");
				CommonUtils.getInstance().slide(slideview, startLeft,
						slideview.getWidth() * 4, 0, 0);
				startLeft = slideview.getWidth() * 4;
				break;
			default:
				break;
			}
		}
	};
}
