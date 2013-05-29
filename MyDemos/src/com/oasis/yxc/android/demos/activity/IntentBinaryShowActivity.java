package com.oasis.yxc.android.demos.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.oasis.yxc.android.demos.R;
import com.oasis.yxc.android.demos.dao.Book;
import com.oasis.yxc.android.demos.dao.Person;

public class IntentBinaryShowActivity extends Activity {

	private static final String SERIALIZABLE_KEY = "Serializable";
	private static final String PARCELABLE_KEY = "Parcelable";

	private static final String ISSERIALIZABLE = "isSerializable";
	private TextView mBinaryShow;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);

		setContentView(R.layout.layout_binaryshow);

		setupViews();

		Intent intent = getIntent();
		if (intent.getBooleanExtra(ISSERIALIZABLE, false)) {

			Person person = (Person) intent
					.getSerializableExtra(SERIALIZABLE_KEY);
			mBinaryShow.setText(person.toString());
		} else {
			Book book = intent.getParcelableExtra(PARCELABLE_KEY);
			mBinaryShow.setText(book.toString());
		}

	}

	private void setupViews() {
		mBinaryShow = (TextView) findViewById(R.id.binary_show);

	}

}
