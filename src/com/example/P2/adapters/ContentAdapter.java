package com.example.P2.adapters;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.p2.R;
import com.example.p2.custom_views.CustomElementContent;
import com.example.p2.entities.Content;

public class ContentAdapter extends ArrayAdapter<Content> {
	private LayoutInflater inflater;
	private static int resource = R.layout.cell_layout;
	private ArrayList<Content> contents;

	public ContentAdapter(Context context, ArrayList<Content> contents) {
		super(context, resource, contents);
		this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		this.contents = contents;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view;

		if (convertView == null) {
			view = inflater.inflate(resource, parent, false);
		} else {
			view = convertView;
		}

		Content content = contents.get(position);
		CustomElementContent customEl = (CustomElementContent) view.findViewById(R.id.customElementContent1);
		customEl.setContents(content.getTitle(), content.getSubtitle());
		
		return view;
	}
}