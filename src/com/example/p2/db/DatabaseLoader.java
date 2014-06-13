package com.example.p2.db;

import android.content.Context;

import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;

public class DatabaseLoader extends OrmLiteBaseActivity<DatabaseHelper> implements Runnable {

	public DatabaseLoader(Context context) {
		super();
	}

	@Override
	public void run() {
		// Moves the current Thread into the background
		android.os.Process.setThreadPriority(android.os.Process.THREAD_PRIORITY_BACKGROUND);

	}

}