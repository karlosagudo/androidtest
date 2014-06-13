package com.example.p2;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.Callable;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

import com.androidquery.AQuery;
import com.androidquery.callback.AjaxCallback;
import com.androidquery.callback.AjaxStatus;
import com.example.P2.adapters.ContentAdapter;
import com.example.p2.db.DatabaseHelper;
import com.example.p2.entities.Content;
import com.example.p2.repositories.ContentRepository;
import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;
import com.j256.ormlite.dao.RuntimeExceptionDao;

public class LoaderActivity extends OrmLiteBaseActivity<DatabaseHelper> {
	private AQuery aq;

	private HashMap<String, Boolean> preloads = new HashMap<String, Boolean>();
	private String cacheKeyPreload = "preload";
	private String cacheKeySoftPreload = "soft-preload";
	private ListView listView;

	private Context ctx;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	
		setContentView(R.layout.listdb);

		aq = new AQuery(this);
		preloadContents("http://gq.preprod.digital.condenast.fr:8080/mobileapi/index/1",-1);
		listView = aq.id(R.id.listView1).getListView();
		ctx = this;
	}

	@Override
	protected void onResume() {
		super.onResume();
	}
	
	private void preloadContents(String url, long expire) {
		

		aq.ajax(url, JSONArray.class, expire, new AjaxCallback<JSONArray>() {
			@Override
			public void callback(String url, JSONArray json, AjaxStatus status) {
				if (json != null) {
					loadDBContents(json);
				
				}
				
			}
		});
	}
	
	private void loadDBContents(final JSONArray jsonArray) {
		// get our dao
		final RuntimeExceptionDao<Content, Integer> contentDao = getHelper().getContentRuntimeDao();
		

		contentDao.callBatchTasks(new Callable<Void>() {
			public Void call() throws SQLException {
				for (int i = 0; i < jsonArray.length(); i++) {
					try {
						JSONObject jo = (JSONObject) jsonArray.get(i);
						Content content = new Content(jo);
						contentDao.createOrUpdate(content);
						Log.i("ORMLite loadDBContents", "created new content: " + content.getId());
					} catch (JSONException e) {
						Log.e("JSON", e.getLocalizedMessage());
					}
				}
				loadList();
				return null;
			}
		});
	}
	
	public void loadList(){
		ContentRepository cr =  new ContentRepository(this);
		final ArrayList<Content> list = cr.getAll();
		ContentAdapter contentad = new ContentAdapter(this, list);
		listView.setAdapter(contentad);
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
				Content element = list.get(position);
				// TODO Auto-generated method stub
				 Toast.makeText(ctx, element.getTitle(), Toast.LENGTH_SHORT).show();
				 
			}
		});
		
		
	}
	
/**
	private void preloadOrStart() {
		boolean isEnoughtBDItems;
		boolean isExpiredCacheRefreshTimeJson;
		long preloadDiff = System.currentTimeMillis()
				- app.getAjaxCacheLastAccess(this, cacheKeyPreload);
		long softPreloadDiff = System.currentTimeMillis()
				- app.getAjaxCacheLastAccess(this, cacheKeySoftPreload);

		contentRepository = new ContentRepository(this);
		categoryRepository = new CategoryRepository(this);
		districtRepository = new DistrictRepository(this);

		if (districtRepository.getCount() == 0) {
			preloadDistricts();
		}

		if (contentRepository.getCount() < 20 || categoryRepository.getCount() == 0) {
			isEnoughtBDItems = false;
		} else {
			isEnoughtBDItems = true;
		}

		if (preloadDiff > Const.CACHE_REFRESH_TIME_JSON) {
			isExpiredCacheRefreshTimeJson = true;
		} else {
			isExpiredCacheRefreshTimeJson = false;
		}

		if (!isEnoughtBDItems || isExpiredCacheRefreshTimeJson) {
			preloads.put(Const.WS_URL_CATEGORIES, false);
			preloads.put(Const.WS_URL_CONTENTS, false);

			preloadCategories(Const.WS_URL_CATEGORIES, Const.CACHE_REFRESH_TIME_JSON);
			preloadContents(Const.WS_URL_CONTENTS, Const.CACHE_REFRESH_TIME_JSON);

			app.setAjaxCacheLastAccess(this, cacheKeyPreload, System.currentTimeMillis());
			app.setAjaxCacheLastAccess(this, cacheKeySoftPreload, System.currentTimeMillis());
		} else {
			start();

			if (softPreloadDiff > Const.CACHE_SOFT_REFRESH_TIME_JSON) {
				MLog.d("DatabaseLoader", "Let's do a soft reload");
				new DatabaseLoader(this).run();
				app.setAjaxCacheLastAccess(this, cacheKeyPreload, System.currentTimeMillis());
				app.setAjaxCacheLastAccess(this, cacheKeySoftPreload, System.currentTimeMillis());
			}
		}

		new DatabaseCleaner(this).run();
	}

	private void start() {
		startActivity(new Intent(this, HomeActivity.class));
		overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		// clean the file cache when root activity exit
		// the resulting total cache size will be less than 3M
		if (isTaskRoot()) {
			AQUtility.cleanCacheAsync(this);
		}
	}

	private void checkPreloads() {
		if (!preloads.containsValue(false)) {
			start();
		}
	}

	private void preloadDistricts() {
		ArrayList<District> districts = new ArrayList<District>();

		for (int i = 1; i < Const.NUM_OF_DISTRICTS + 1; i++) {
			String zipcode = String.valueOf(75000 + i);
			District district = new District(i, zipcode, true);
			districts.add(district);
		}

		loadDBDistricts(districts);
	}

	private void preloadCategories(String url, long expire) {
		MLog.d("LOADER", url);

		aq.ajax(url, JSONArray.class, expire, new AjaxCallback<JSONArray>() {
			@Override
			public void callback(String url, JSONArray json, AjaxStatus status) {
				if (json != null) {
					loadDBCategories(json);
					preloads.put(url, true);
				}
				checkPreloads();
			}
		});
	}

	private void preloadContents(String url, long expire) {
		MLog.d("LOADER", url);

		aq.ajax(url, JSONArray.class, expire, new AjaxCallback<JSONArray>() {
			@Override
			public void callback(String url, JSONArray json, AjaxStatus status) {
				if (json != null) {
					loadDBContents(json);
					preloads.put(url, true);
				}
				checkPreloads();
			}
		});
	}

	private void loadDBCategories(final JSONArray jsonArray) {
		// get our dao
		final RuntimeExceptionDao<Category, Integer> categoryDao = getHelper()
				.getCategoryRuntimeDao();

		categoryDao.callBatchTasks(new Callable<Void>() {
			public Void call() throws SQLException {

				// delete all rows
				try {
					DeleteBuilder<Category, Integer> deleteBuilder = categoryDao.deleteBuilder();
					deleteBuilder.delete();
				} catch (java.sql.SQLException e1) {
					e1.printStackTrace();
				}

				for (int i = 0; i < jsonArray.length(); i++) {
					try {
						JSONObject jo = (JSONObject) jsonArray.get(i);

						Category category = new Category(jo);

						categoryDao.createOrUpdate(category);
						MLog.i("ORMLite loadDBCategories",
								"created new category: " + category.getId());
					} catch (JSONException e) {
						MLog.e("JSON", e.getLocalizedMessage());
					}
				}
				return null;
			}
		});
	}

	private void loadDBContents(final JSONArray jsonArray) {
		// get our dao
		final RuntimeExceptionDao<Content, Integer> contentDao = getHelper().getContentRuntimeDao();
		final RuntimeExceptionDao<Tag, Integer> tagDao = getHelper().getTagRuntimeDao();
		final RuntimeExceptionDao<ContentTag, Integer> contentTagDao = getHelper()
				.getContentTagRuntimeDao();
		final RuntimeExceptionDao<CategoryTag, Integer> categoryTagDao = getHelper()
				.getCategoryTagRuntimeDao();

		contentDao.callBatchTasks(new Callable<Void>() {
			public Void call() throws SQLException {
				for (int i = 0; i < jsonArray.length(); i++) {
					try {
						JSONObject jo = (JSONObject) jsonArray.get(i);

						Content content = new Content(jo, categoryRepository.get(jo
								.optInt("appbackendcategory_id")));

						JSONArray tags = jo.optJSONArray("attributes");
						for (int j = 0; j < tags.length(); j++) {
							Tag tag = new Tag(tags.optJSONObject(j));
							tagDao.createOrUpdate(tag);
							MLog.i("ORMLite loadDBContents", "created new tag: " + tag.toString());

							ContentTag contentTag = new ContentTag(content, tag);
							contentTagDao.createOrUpdate(contentTag);
							MLog.i("ORMLite loadDBContents", "created new contentTag: "
									+ contentTag.toString());

							Category category = categoryRepository.get(tags.optJSONObject(j)
									.optInt("category_id"));
							if (category != null) {
								CategoryTag categoryTag = new CategoryTag(category, tag);
								categoryTagDao.createOrUpdate(categoryTag);
								MLog.i("ORMLite loadDBContents", "created new categoryTag: "
										+ categoryTag.toString());
							}
						}

						contentDao.createOrUpdate(content);
						MLog.i("ORMLite loadDBContents", "created new content: " + content.getId());
					} catch (JSONException e) {
						MLog.e("JSON", e.getLocalizedMessage());
					}
				}
				return null;
			}
		});
	}

	private void loadDBDistricts(final ArrayList<District> districts) {
		// get our dao
		final RuntimeExceptionDao<District, Integer> districtDao = getHelper()
				.getDistrictRuntimeDao();

		districtDao.callBatchTasks(new Callable<Void>() {
			public Void call() throws SQLException {
				for (District district : districts) {
					districtDao.createOrUpdate(district);
					MLog.i("ORMLite loadDBDistricts", "created new district: " + district.getId());
				}
				return null;
			}
		});
	}
**/
}
