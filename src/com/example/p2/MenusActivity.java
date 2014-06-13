package com.example.p2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

import com.example.p2.MenuFragment.OnMenuFragmentListener;

public class MenusActivity extends FragmentActivity implements OnMenuFragmentListener {
	ContentFragment fragment1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menus_activity);

		// if we're being restored from a previous state,
		// then we don't need to do anything and should return or else
		// we could end up with overlapping fragments.
		if (savedInstanceState == null) {
			if (findViewById(R.id.frame) != null) {
				fragment1 = new ContentFragment();
				FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
				ft.add(R.id.frame, fragment1);
				ft.commit();
			}
		}
		

	}

	@Override
	public void onMenuBoton1click() {
		
		fragment1.cambiate();
		
		
		
		Fragment current = getSupportFragmentManager().findFragmentById(R.id.frame);

		Content2Fragment fragment2 = new Content2Fragment();
		FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

		if (current == null) {
			ft.add(R.id.frame, fragment2);
		} else {
			//ft.remove(current).add(R.id.frame, fragment2);
			ft.replace(R.id.frame, fragment2);
		}

		ft.addToBackStack(null);
		ft.commit();
	}
}
