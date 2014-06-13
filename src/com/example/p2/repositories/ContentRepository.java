package com.example.p2.repositories;

import java.sql.SQLException;
import java.util.ArrayList;

import android.content.Context;

import com.example.p2.db.DatabaseHelper;
import com.example.p2.db.DatabaseManager;
import com.example.p2.entities.Content;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.Dao.CreateOrUpdateStatus;
import com.j256.ormlite.stmt.QueryBuilder;

public class ContentRepository {
	private DatabaseHelper db;
	Dao<Content, Integer> dao;

	public ContentRepository(Context ctx) {
		try {
			DatabaseManager dbManager = new DatabaseManager();
			db = dbManager.getHelper(ctx);
			dao = db.getContentDao();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int create(Content content) {
		try {
			return dao.create(content);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public CreateOrUpdateStatus createOrUpdate(Content content) {
		try {
			return dao.createOrUpdate(content);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public int update(Content content) {
		try {
			return dao.update(content);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int delete(Content content) {
		try {
			return dao.delete(content);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public ArrayList<Content> getAll() {
		try {
			QueryBuilder<Content, Integer> qb = dao.queryBuilder();
			qb.orderBy("publishAt", true);
			return (ArrayList<Content>) qb.query();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
