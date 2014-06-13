package com.example.p2;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class MenuFragment extends Fragment {
	private Button boton;
	private Context context;
	private OnMenuFragmentListener menufragmentCallback;
	
	
	public interface OnMenuFragmentListener{
		public void onMenuBoton1click();
		
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View layout = inflater.inflate(R.layout.fragment_menu, container, false);

		boton = (Button) layout.findViewById(R.id.menu_button);
		context = (Context) getActivity();
		boton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				menufragmentCallback.onMenuBoton1click();
			}
		});

		return layout;
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);

		// This makes sure that the container activity has implemented
		// the callback interface. If not, it throws an exception.
		try {
			menufragmentCallback = (OnMenuFragmentListener) activity;
		} catch (ClassCastException e) {
			throw new ClassCastException(activity.toString()
					+ " must implement OnMenuFragmentListener");
		}
	}
	
}
