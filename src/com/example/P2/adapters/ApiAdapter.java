package com.example.P2.adapters;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.example.p2.R;

public class ApiAdapter extends SimpleAdapter {
	private int resource;
	private LayoutInflater inflater;
	private JSONArray ja;
	
	public ApiAdapter(Context context, JSONArray ja, int resource, String[] from, int[] to) {
		super(context, getListFromJsonArray(ja), resource, from, to);
		
		this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		this.resource = resource;
		this.ja = ja;
		
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view;
		if(convertView == null){
			view = inflater.inflate(resource, parent,false);
		}else{
			view = convertView;
		}
		
		try {
			JSONObject jo = ja.getJSONObject(position);
			TextView titulo = (TextView) view.findViewById(R.id.Titulo);
			JSONObject preText = jo.getJSONObject("property1");
			titulo.setText(preText.getString("text"));
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		return view;
	}

	// method converts JSONArray to List of Maps
	protected static List<Map<String, String>> getListFromJsonArray(JSONArray jsonArray) {
		ArrayList<Map<String, String>> list = new ArrayList<Map<String, String>>();
		Map<String, String> map;
		// fill the list
		for (int i = 0; i < jsonArray.length(); i++) {
			map = new HashMap<String, String>();
			try {
				JSONObject jo = (JSONObject) jsonArray.get(i);

				// fill map
				Iterator<?> iter = jo.keys();
				while (iter.hasNext()) {
					String currentKey = (String) iter.next();
					map.put(currentKey, jo.getString(currentKey));
				}
				// add map to list
				list.add(map);
			} catch (JSONException e) {
				Log.e("JSON", e.getLocalizedMessage());
			}

			// // Log.d("ListGeneric", "newsItemIds: " +
			// newsItemIds.toString());
		}
		return list;
	}

}
