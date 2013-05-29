package com.oasis.yxc.android.demos.app;

//Download by http://www.codefans.net
import java.util.ArrayList;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.oasis.yxc.android.demos.R;
import com.oasis.yxc.android.demos.customview.PullRefreshListView;
import com.oasis.yxc.android.demos.customview.PullRefreshListView.OnRefreshListener;

public class PullRefreshActivity extends Activity {

	private ArrayList<String> data;
	private BaseAdapter adapter;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pull_refresh_main_layout);

		data = new ArrayList<String>();
		for (int i = 0; i < 10; i++) {
			data.add(String.valueOf(i));
		}

		final PullRefreshListView listView = (PullRefreshListView) findViewById(R.id.listView);
		adapter = new BaseAdapter() {
			public View getView(int position, View convertView, ViewGroup parent) {
				convertView = LayoutInflater.from(getApplicationContext())
						.inflate(R.layout.pull_refresh_item, null);
				TextView textView = (TextView) convertView
						.findViewById(R.id.textView_item);
				textView.setText(data.get(position));
				return convertView;
			}

			public long getItemId(int position) {
				return position;
			}

			public Object getItem(int position) {
				return data.get(position);
			}

			public int getCount() {
				return data.size();
			}
		};
		listView.setAdapter(adapter);

		listView.setonRefreshListener(new OnRefreshListener() {
			public void onRefresh() {
				new AsyncTask<Void, Void, Void>() {
					protected Void doInBackground(Void... params) {
						try {
							Thread.sleep(1000);
						} catch (Exception e) {
							e.printStackTrace();
						}

						ArrayList<String> list = new ArrayList<String>();
						list.add("刷新后内容1");
						list.add("刷新后内容2");
						list.add("刷新后内容3");
						data.addAll(0, list);

						return null;
					}

					@Override
					protected void onPostExecute(Void result) {
						adapter.notifyDataSetChanged();
						listView.onRefreshComplete();
					}

				}.execute(null);
			}
		});
	}
}