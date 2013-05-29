package com.oasis.yxc.android.demos.app;

import com.oasis.yxc.android.demos.R;
import com.oasis.yxc.android.demos.activity.IntentBinaryShowActivity;
import com.oasis.yxc.android.demos.dao.Book;
import com.oasis.yxc.android.demos.dao.Person;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class IntentBinaryFlagActivity extends Activity implements
		OnClickListener {

	private static final String SERIALIZABLE_KEY = "Serializable";
	private static final String PARCELABLE_KEY = "Parcelable";
	private static final String ISSERIALIZABLE = "isSerializable";

	private Button mSerializableBtn;
	private Button mParcelableBtn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);

		setContentView(R.layout.layout_binaryflag);

		setupViews();
	}

	private void setupViews() {
		mSerializableBtn = (Button) findViewById(R.id.serializable_btn);
		mParcelableBtn = (Button) findViewById(R.id.parcelable_btn);

		mSerializableBtn.setOnClickListener(this);
		mParcelableBtn.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.serializable_btn:
			Person person = new Person();
			person.setAge(18);
			person.setName("oasis");

			Bundle serbundle = new Bundle();
			serbundle.putSerializable(SERIALIZABLE_KEY, person);

			Intent serintent = new Intent();
			serintent.putExtras(serbundle);
			serintent.putExtra(ISSERIALIZABLE, true);
			serintent.setClass(IntentBinaryFlagActivity.this,
					IntentBinaryShowActivity.class);
			startActivity(serintent);
			break;
		case R.id.parcelable_btn:
			Book book = new Book();
			book.setAuthor("oasis");
			book.setBookname("LoveForever");
			book.setPulishtime(2013);

			Bundle parbundle = new Bundle();
			parbundle.putParcelable(PARCELABLE_KEY, book);

			Intent parIntent = new Intent();
			parIntent.putExtras(parbundle);
			parIntent.putExtra(ISSERIALIZABLE, false);
			parIntent.setClass(IntentBinaryFlagActivity.this,
					IntentBinaryShowActivity.class);
			startActivity(parIntent);

			break;
		default:
			break;
		}

	}
}
