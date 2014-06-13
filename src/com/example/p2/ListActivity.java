package com.example.p2;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

import com.androidquery.AQuery;
import com.androidquery.callback.AjaxCallback;
import com.androidquery.callback.AjaxStatus;
import com.example.P2.adapters.ApiAdapter;

public class ListActivity extends Activity {
	private ListView listView1;
	private AQuery aq;
	private Context context;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list);
		listView1 = (ListView) findViewById(R.id.listView1);
		context = this;

		aq = new AQuery(this);
		aq.ajax("http://www.kimonolabs.com/api/dipza09k?apikey=1795452f91c1ba2f06b0cdc1e7059c9d&stext=machete",
				JSONObject.class, 50000000, new AjaxCallback<JSONObject>() {
					@Override
					public void callback(String url, JSONObject object, AjaxStatus status) {
						JSONArray ja = null;
						try {
							ja = object.getJSONObject("results").getJSONArray("collection1");
							ApiAdapter apAdapter = new ApiAdapter(context, ja,
									R.layout.cell_layout, null, null);
							listView1.setAdapter(apAdapter);
						} catch (JSONException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				});
		listView1.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
				
				Intent intent = (Intent) new Intent(context, DetailActivity.class);
				intent.putExtra(DetailActivity.ARG_INTENT_KEY, arg2);
				context.startActivity(intent);
				
			}
			
		});
	}
}
