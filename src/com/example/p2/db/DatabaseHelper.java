package com.example.p2.db;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.nfc.Tag;
import android.os.Environment;
import android.util.Log;

import com.example.p2.R;
import com.example.p2.entities.Content;
import com.example.p2.utils.Utils;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

/**
 * Database helper class used to manage the creation and upgrading of your
 * database. This class also usually provides the DAOs used by the other
 * classes.
 */
public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

	// name of the database file for your application
	private static final String DATABASE_NAME = "P2db";
	// any time you make changes to your database objects, you may have to
	// increase the database version
	private static final int DATABASE_VERSION = 1;

	// the DAO object we use to access the table
	private Dao<Content, Integer> contentDao = null;
	private RuntimeExceptionDao<Content, Integer> contentRuntimeDao = null;
	
	public DatabaseHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION, R.raw.ormlite_config);
	}

	/**
	 * This is called when the database is first created. Usually you should
	 * call createTable statements here to create the tables that will store
	 * your data.
	 */
	@Override
	public void onCreate(SQLiteDatabase db, ConnectionSource connectionSource) {
		try {
			TableUtils.createTable(connectionSource, Content.class);
		} catch (SQLException e) {
			Log.e(DatabaseHelper.class.getName(), "Can't create database", e);
			throw new RuntimeException(e);
		}
	}

	/**
	 * This is called when your application is upgraded and it has a higher
	 * version number. This allows you to adjust the various data to match the
	 * new version number.
	 */
	@Override
	public void onUpgrade(SQLiteDatabase db, ConnectionSource connectionSource, int oldVersion,
			int newVersion) {
		try {
			TableUtils.dropTable(connectionSource, Content.class, true);
			// after we drop the old databases, we create the new ones
			onCreate(db, connectionSource);
		} catch (SQLException e) {
			Log.e(DatabaseHelper.class.getName(), "Can't drop databases", e);
			throw new RuntimeException(e);
		}
	}

	
	/**
	 * Returns the Database Access Object (DAO) for our Content class. It will
	 * create it or just give the cached value.
	 */
	public Dao<Content, Integer> getContentDao() throws SQLException {
		if (contentDao == null) {
			contentDao = getDao(Content.class);
		}
		return contentDao;
	}

	
	/**
	 * Returns the RuntimeExceptionDao (Database Access Object) version of a Dao
	 * for our Content class. It will create it or just give the cached value.
	 * RuntimeExceptionDao only through RuntimeExceptions.
	 */
	public RuntimeExceptionDao<Content, Integer> getContentRuntimeDao() {
		if (contentRuntimeDao == null) {
			contentRuntimeDao = getRuntimeExceptionDao(Content.class);
		}
		return contentRuntimeDao;
	}

	
	/**
	 * Close the database connections and clear any cached DAOs.
	 */
	@Override
	public void close() {
		super.close();
		contentDao = null;
	}

}