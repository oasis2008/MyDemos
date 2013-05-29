package com.oasis.yxc.android.demos.app;

import com.oasis.yxc.android.demos.R;
import com.oasis.yxc.android.demos.customview.SlipButton;
import com.oasis.yxc.android.demos.customview.SlipButton.OnChangedListener;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;

public class SlipButtonActivity extends Activity {

	private SlipButton sb = null;
	private Button btn = null;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.slip_button_layout);

		findView();
		setListener();
	}

	private void setListener() {
		sb.SetOnChangedListener(new OnChangedListener() {

			public void OnChanged(boolean CheckState) {
				btn.setText(CheckState ? "True" : "False");
			}
		});
	}

	private void findView() {
		sb = (SlipButton) findViewById(R.id.splitbutton);
		btn = (Button) findViewById(R.id.ringagain);
		sb.setCheck(true);
	}
}