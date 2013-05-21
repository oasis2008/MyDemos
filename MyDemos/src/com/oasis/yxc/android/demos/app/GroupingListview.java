package com.oasis.yxc.android.demos.app;

import java.util.ArrayList;
import java.util.List;
import com.oasis.yxc.android.demos.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class GroupingListview extends Activity {
	
	private List<String> list = null;
	private List<String> groupkey = new ArrayList<String>();
	private List<String> aList = new ArrayList<String>();
	private List<String> bList = new ArrayList<String>();
	private ListView listview;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.groupinglistview_main_layout);

		listview = (ListView) findViewById(R.id.listView_list);
		initData();
		MyAdapter adapter = new MyAdapter();
		listview.setAdapter(adapter);

	}

	public void initData() {
		list = new ArrayList<String>();

		groupkey.add("A组");
		groupkey.add("B组");

		for (int i = 0; i < 5; i++) {
			aList.add("A组" + i);
		}
		list.add("A组");
		list.addAll(aList);

		for (int i = 0; i < 8; i++) {
			bList.add("B组" + i);
		}
		list.add("B组");
		list.addAll(bList);
	}

	private class MyAdapter extends BaseAdapter {

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return list.size();
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return list.get(position);
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}
		
		/**this is very important for GroupingListview to show the title
		 * and the title is enabled,can not selected.
		 * */
		@Override
		public boolean isEnabled(int position) {
			// TODO Auto-generated method stub
			if (groupkey.contains(getItem(position))) {
				return false;
			}
			return super.isEnabled(position);
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			View view = convertView;
			
			/**The title and the item have the differents layout
			 * */
			if (groupkey.contains(getItem(position))) {
				view = LayoutInflater.from(getApplicationContext()).inflate(
						R.layout.groupinglistview_list_item_tag, null);
			} else {
				view = LayoutInflater.from(getApplicationContext()).inflate(
						R.layout.groupinglistview_list_item, null);
			}
			TextView text = (TextView) view
					.findViewById(R.id.addexam_list_item_text);
			text.setText((CharSequence) getItem(position));
			return view;
		}

	}

}
