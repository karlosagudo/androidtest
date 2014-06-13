package com.example.p2.utils;

import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;

import org.json.JSONObject;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.Spannable;
import android.text.style.URLSpan;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;

import com.example.p2.R;

public class Utils {
	/**
	 * Removes URL underlines in a string by replacing URLSpan occurrences by
	 * URLSpanNoUnderline objects.
	 * 
	 * @param p_Text
	 *            A Spannable object. For example, a TextView casted as
	 *            Spannable.
	 */
	public static void removeUnderlines(Spannable p_Text) {
		URLSpan[] spans = p_Text.getSpans(0, p_Text.length(), URLSpan.class);

		for (URLSpan span : spans) {
			int start = p_Text.getSpanStart(span);
			int end = p_Text.getSpanEnd(span);
			p_Text.removeSpan(span);
			// span = new URLSpanNoUnderline(span.getURL());
			p_Text.setSpan(span, start, end, 0);
		}
	}

	public static String uncapitalize(String s) {
		if (s != null && s.length() > 0) {
			return s.substring(0, 1).toLowerCase(Locale.FRENCH) + s.substring(1);
		} else
			return s;
	}

	public static int getDensity(WindowManager wm) {
		DisplayMetrics metrics = new DisplayMetrics();
		wm.getDefaultDisplay().getMetrics(metrics);
		return metrics.densityDpi;
	}

	@SuppressLint("NewApi")
	@SuppressWarnings("deprecation")
	public static int getScreenWidth(WindowManager wm) {
		int screenWidth = 0;
		Display display = wm.getDefaultDisplay();
		if (android.os.Build.VERSION.SDK_INT >= 13) {
			Point size = new Point();
			display.getSize(size);
			screenWidth = size.x;
		} else {
			screenWidth = display.getWidth();
		}
		return screenWidth;
	}

	public static int getWSImageWidth(WindowManager wm, double percentage) {
		int screenWidth = getScreenWidth(wm);
		int closestImageWidth = closestGreater(screenWidth, Constants.WS_IMAGE_SIZES);
		int WSImageWidth = (int) (closestImageWidth * percentage);
		return WSImageWidth;
	}

	public static int closest(int find, int... values) {
		int closest = values[0];
		int distance = Math.abs(closest - find);
		for (int i : values) {
			int distanceI = Math.abs(i - find);
			if (distance > distanceI) {
				closest = i;
				distance = distanceI;
			}
		}
		return closest;
	}

	public static int closestGreater(int find, int... values) {
		int closest = 0;

		for (int i : values) {
			if (i > find && closest == 0) {
				closest = i;
			}
		}
		return closest;
	}

	public static boolean isTablet(Context context) {
		try {
			// Compute screen size
			DisplayMetrics dm = context.getResources().getDisplayMetrics();
			float screenWidth = dm.widthPixels / dm.xdpi;
			float screenHeight = dm.heightPixels / dm.ydpi;
			double size = Math.sqrt(Math.pow(screenWidth, 2) + Math.pow(screenHeight, 2));
			// Log.d("isTablet", "width: " + screenWidth);
			// Log.d("isTablet", "height: " + screenHeight);
			// Log.d("isTablet", "size: " + size);
			// Tablet devices should have a screen size greater than 6 inches
			return size >= 6;
		} catch (Throwable t) {
			// Log.error(TAG_LOG, "Failed to compute screen size", t);
			return false;
		}

	}

	/**
	 * Checks if the application is being sent in the background (i.e behind
	 * another application's Activity).
	 * 
	 * @param context
	 *            the context
	 * @return <code>true</code> if another application will be above this one.
	 */
	public static boolean isApplicationSentToBackground(final Context context) {
		ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
		List<ActivityManager.RunningTaskInfo> tasks = am.getRunningTasks(1);
		if (!tasks.isEmpty()) {
			ComponentName topActivity = tasks.get(0).topActivity;
			if (!topActivity.getPackageName().equals(context.getPackageName())) {
				return true;
			}
		}

		return false;
	}

	public static String getImageUrl(String url) {
		if (url.contains("http://")) {
			return url;
		} else {
			return Constants.URL_HOST + url;
		}
	}

	public static Bitmap rotate(Bitmap src, float degree) {
		// create new matrix
		Matrix matrix = new Matrix();
		// setup rotation degree
		matrix.postRotate(degree);

		// return new bitmap rotated using matrix
		return Bitmap.createBitmap(src, 0, 0, src.getWidth(), src.getHeight(), matrix, true);
	}

	public static String toSlug(String input) {
		Pattern NONLATIN = Pattern.compile("[^\\w-]");
		Pattern WHITESPACE = Pattern.compile("[\\s]");
		String nowhitespace = WHITESPACE.matcher(input).replaceAll("-");
		String normalized = Normalizer.normalize(nowhitespace, Form.NFD);
		String slug = NONLATIN.matcher(normalized).replaceAll("");
		return slug.toLowerCase(Locale.ENGLISH);
	}

	public static Bitmap getCircledBitmap(Bitmap bitmap) {
		Bitmap output = Bitmap
				.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Config.ARGB_8888);
		Canvas canvas = new Canvas(output);

		final int color = 0xff424242;
		final Paint paint = new Paint();
		final Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());

		paint.setAntiAlias(true);
		canvas.drawARGB(0, 0, 0, 0);
		paint.setColor(color);
		// canvas.drawRoundRect(rectF, roundPx, roundPx, paint);
		canvas.drawCircle(bitmap.getWidth() / 2, bitmap.getHeight() / 2, bitmap.getWidth() / 2,
				paint);
		paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
		canvas.drawBitmap(bitmap, rect, rect, paint);
		// Bitmap _bmp = Bitmap.createScaledBitmap(output, 60, 60, false);
		// return _bmp;
		return output;
	}

	public static Bitmap getRoundedCornerBitmap(Bitmap bitmap, int pixels) {

		Bitmap output = Bitmap
				.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Config.ARGB_8888);
		Canvas canvas = new Canvas(output);

		final int color = 0xff424242;
		final Paint paint = new Paint();
		final Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
		final RectF rectF = new RectF(rect);
		final float roundPx = pixels;

		paint.setAntiAlias(true);
		canvas.drawARGB(0, 0, 0, 0);
		paint.setColor(color);
		canvas.drawRoundRect(rectF, roundPx, roundPx, paint);

		paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
		canvas.drawBitmap(bitmap, rect, rect, paint);

		return output;
	}

	public static String getWSUrl(int sectionId, int tagId, Activity activity, int itemId,
			String dataString) {
		String wsUrl = "";
		if (sectionId != 0) {
			switch (sectionId) {
			case Constants.SECTION_LEMONDE_ID:
				wsUrl = Constants.WS_URL_SECTION_LEMONDE;
				break;
			case Constants.SECTION_POPCORN_ID:
				wsUrl = Constants.WS_URL_SECTION_POPCORN
						+ "&big_h_image=640x360&small_h_image=125x90";
				break;
			case Constants.SECTION_VOUSAVEZ_ID_5MIN:
				wsUrl = Constants.WS_URL_SECTION_VOUSAVEZ_5MIN + "&big_v_image=240x320";
				break;
			case Constants.SECTION_VOUSAVEZ_ID_10MIN:
				wsUrl = Constants.WS_URL_SECTION_VOUSAVEZ_10MIN + "&big_v_image=240x320";
				break;
			case Constants.SECTION_VOUSAVEZ_ID_15MIN:
				wsUrl = Constants.WS_URL_SECTION_VOUSAVEZ_15MIN + "&big_v_image=240x320";
				break;
			case Constants.SECTION_PERSONALITIES_ID:
				wsUrl = Constants.WS_URL_SECTION_PERSONALITIES
						+ "&big_square_image=200x200&big_h_image=200x267";
				break;
			case Constants.SECTION_PERSONALITY_ID:
				wsUrl = Constants.WS_URL_SECTION_PERSONALITY + itemId
						+ "&big_square_image=200x200&big_h_image=640x360";
				break;
			case Constants.SECTION_PLUSLUS_ID:
				wsUrl = Constants.WS_URL_SECTION_PLUSLUS + "&big_h_image=320x180";
				break;
			case Constants.SECTION_CHRONIQUES_ID:
				wsUrl = Constants.WS_URL_SECTION_CHRONIQUES
						+ "&big_h_image=320&small_v_image=90x105";
				break;
			case Constants.SECTION_ARTICLE_ID:
				wsUrl = Constants.WS_URL_SECTION_ARTICLE + itemId + "&big_h_image=640x360"
						+ dataString;
				break;
			case Constants.SECTION_GALLERY_ID:
				wsUrl = Constants.WS_URL_SECTION_GALLERY + itemId + "&big_h_image=640x360";
				break;
			case Constants.SECTION_GALLERY_IMAGES_ID:
				wsUrl = Constants.WS_URL_SECTION_GALLERY_IMAGES + itemId + "&big_h_image=640";
				break;
			case Constants.SECTION_AUTHOR_ID:
				wsUrl = Constants.WS_URL_SECTION_AUTHOR + itemId + "&big_square_image=200x200";
				break;
			case Constants.SECTION_AUTHOR_ARTICLES_ID:
				wsUrl = Constants.WS_URL_SECTION_AUTHOR_ARTICLES + itemId + "&big_h_image=640x360";
				break;
			case Constants.SECTION_SEARCH_ID:
				wsUrl = Constants.WS_URL_SECTION_SEARCH + dataString + "&big_h_image=640x360";
				break;
			default:
				wsUrl = Constants.WS_URL_SECTION + sectionId + "&big_h_image=640x360";
				break;
			}
		} else if (tagId != 0) {
			// get contents by tag
		}

		Log.d("UTILS getWSUrl", wsUrl);

		return wsUrl;
	}

	
	public static String getModelShort(String model) {
		String modelShort = "Content";
		if (model.equals(Constants.MODEL_ARTICLE)) {
			modelShort = "Article";
		} else if (model.equals(Constants.MODEL_GALLERY)) {
			modelShort = "Gallery";
		} else if (model.equals(Constants.MODEL_VIDEO)) {
			modelShort = "Video";
		}
		return modelShort;
	}

	public static int mapOptInt(Map<String, String> map, String key) {
		int intValue = 0;
		if (map.containsKey(key)) {
			String value = map.get(key);
			if (value != null && !value.equals("null") && !value.isEmpty()) {
				intValue = Integer.valueOf(value);
			}
		}
		return intValue;
	}

	public static String mapOptString(Map<String, String> map, String key) {
		if (!map.containsKey(key) || map.get(key) == "null" || map.get(key).isEmpty()) {
			return "";
		} else {
			return map.get(key);
		}
	}

	public static int jsonOptInt(JSONObject jo, String key) {
		int intValue = jo.optInt(key);
		if (Integer.valueOf(intValue) == null) {
			intValue = 0;
		}
		return intValue;
	}

	public static String jsonOptString(JSONObject jo, String key) {
		String stringValue = jo.optString(key);
		if (stringValue == "null") {
			stringValue = "";
		}
		return stringValue;
	}

}
