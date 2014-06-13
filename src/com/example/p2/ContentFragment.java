package com.example.p2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class ContentFragment extends Fragment {
	private View layout;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		layout = inflater.inflate(R.layout.fragment_content, container, false);
		return layout;
	}

	public void cambiate() {
		Toast.makeText(getActivity(), "hoola", Toast.LENGTH_LONG).show();
	}
}
