package com.example.p2.custom_views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.androidquery.AQuery;
import com.example.p2.R;



public class CustomElementContent extends LinearLayout {
	private AQuery aq;

	public CustomElementContent(Context context, AttributeSet attrs) {
		super(context, attrs);

		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View rootView = inflater.inflate(R.layout.custom_element, this, true);

		aq = new AQuery(rootView);
		parseAttributes(context,attrs);
	}

	public void setContents(String titleText, String subtitleText) {
		aq.id(R.id.Titulo).text(titleText);
		aq.id(R.id.Subtitulo).text(subtitleText);

	}
	
	private void parseAttributes(Context context, AttributeSet attrs) {
		//if (!isInEditMode()) {
			TypedArray values = context.obtainStyledAttributes(attrs, R.styleable.CustomElementContent);
			String background_color = values.getString(R.styleable.CustomElementContent_background_color);
			setBackgroundColor(Color.parseColor(background_color));
			
		//}
	}
	
}
