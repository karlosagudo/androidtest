package com.example.p2;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.androidquery.AQuery;
import com.androidquery.callback.AjaxCallback;
import com.androidquery.callback.AjaxStatus;

public class DetailActivity extends Activity {
	private Integer detail_id;
	public static String ARG_INTENT_KEY = "detail_id";
	private AQuery aq;
	private Context context;
	private TextView detailTitle ;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detail);
		if(getIntent().hasExtra(ARG_INTENT_KEY)){
			detail_id = getIntent().getExtras().getInt(ARG_INTENT_KEY, -1);
		}
		if(detail_id != -1){
			Toast.makeText(this, "ID:"+detail_id, Toast.LENGTH_SHORT).show();
		}
		context = this;
		aq = new AQuery(this);
		detailTitle = (TextView) findViewById(R.id.detailTitle);
		aq.ajax("http://www.vanityfair.fr/api/ios/getArticle?articleId=13873",
				JSONArray.class, 50000000, new AjaxCallback<JSONArray>() {
					@Override
					public void callback(String url, JSONArray object, AjaxStatus status) {
						try {
							JSONObject jo = object.getJSONObject(0);
							detailTitle.setText(jo.getString("title"));
							aq.id(R.id.detailDescription).text(jo.getString("subtitle"));
							aq.id(R.id.detailImage).image("http://lorempixel.com/300/300/fashion");
						} catch (JSONException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
				});
		
	}
}
