package com.example.p2.utils;

public class Constants {
	// return a cached copy if the data is recently fetched within 8 hours
	public static long CACHE_EXPIRE_TIME_JSON = Long.MAX_VALUE;
	public static long CACHE_REFRESH_TIME_JSON = 4 * 60 * 60 * 1000;
	public static boolean CACHE_IS_SUPERCACHE_ENABLED = true;

	public static final String URL_HOST_PROD = "http://www.vanityfair.fr";
	public static final String URL_HOST_PREPROD = "http://vanity.preprod.digital.condenast.fr:8080";
	public static final String URL_HOST = URL_HOST_PROD;
	public static final String WS_URL_BASE = URL_HOST + "/api/ios";

	public static final String WS_URL_SECTIONS_LIST = WS_URL_BASE + "/getSections?limit=20";
	public static final String WS_URL_SECTION = WS_URL_BASE
			+ "/getContent?limit=20&exc_chroniq_navs=1&navigation=";
	public static final String WS_URL_SECTION_LEMONDE = WS_URL_BASE + "/getLemonde?limit=20";
	public static final String WS_URL_SECTION_POPCORN = WS_URL_BASE + "/getPopcorn?limit=20";
	public static final String WS_URL_SECTION_VOUSAVEZ_5MIN = WS_URL_BASE + "/getVousavez?tag=113";
	public static final String WS_URL_SECTION_VOUSAVEZ_10MIN = WS_URL_BASE + "/getVousavez?tag=112";
	public static final String WS_URL_SECTION_VOUSAVEZ_15MIN = WS_URL_BASE + "/getVousavez?tag=114";
	public static final String WS_URL_SECTION_PERSONALITIES = WS_URL_BASE + "/getPeople?limit=20";
	public static final String WS_URL_SECTION_PERSONALITY = WS_URL_BASE
			+ "/getPeopleContent?limit=20&personId=";
	public static final String WS_URL_SECTION_CHRONIQUES = WS_URL_BASE + "/getChroniques?limit=20";
	public static final String WS_URL_SECTION_PLUSLUS = WS_URL_BASE
			+ "/getMostSeenContent?limit=20";
	public static final String WS_URL_SECTION_ARTICLE = WS_URL_BASE + "/getArticle?articleId=";
	public static final String WS_URL_SECTION_GALLERY = WS_URL_BASE + "/getGallery?galleryId=";
	public static final String WS_URL_SECTION_GALLERY_IMAGES = WS_URL_BASE
			+ "/getGalleryImages?galleryId=";
	public static final String WS_URL_SECTION_VIDEO = WS_URL_BASE + "/getVideo?videoId=";
	public static final String WS_URL_SECTION_AUTHOR = WS_URL_BASE + "/getAuthor?authorId=";
	public static final String WS_URL_SECTION_AUTHOR_ARTICLES = WS_URL_BASE + "/getContent?author=";
	public static final String WS_URL_SECTION_SEARCH = WS_URL_BASE + "/getContent?limit=23&search=";

	public static final String SECTION_HOME_NAME = "HOME";
	public static final int SECTION_HOME_ID = 23;
	public static final String SECTION_LEMONDE_NAME = "Le Monde de Vanity Fair";
	public static final int SECTION_LEMONDE_ID = 1;
	public static final String SECTION_POPCORN_NAME = "PopCorn";
	public static final int SECTION_POPCORN_ID = 2;
	public static final String SECTION_VOUSAVEZ_NAME = "Vous Avez";
	public static final int SECTION_VOUSAVEZ_ID_5MIN = 3;
	public static final int SECTION_VOUSAVEZ_ID_10MIN = 4;
	public static final int SECTION_VOUSAVEZ_ID_15MIN = 5;
	public static final String SECTION_PERSONALITIES_NAME = "Personnalités";
	public static final int SECTION_PERSONALITIES_ID = 6;
	public static final String SECTION_CHRONIQUES_NAME = "Chroniques";
	public static final int SECTION_CHRONIQUES_ID = 7;
	public static final String SECTION_PLUSLUS_NAME = "Articles les plus lus";
	public static final int SECTION_PLUSLUS_ID = 8;
	public static final String SECTION_PERSONALITY_NAME = "Personnalités";
	public static final int SECTION_PERSONALITY_ID = 9;
	public static final String SECTION_ARTICLE_NAME = "Article";
	public static final int SECTION_ARTICLE_ID = 10;
	public static final String SECTION_GALLERY_NAME = "Gallery";
	public static final int SECTION_GALLERY_ID = 11;
	public static final String SECTION_GALLERY_IMAGES_NAME = "Gallery images";
	public static final int SECTION_GALLERY_IMAGES_ID = 12;
	public static final String SECTION_AUTHOR_NAME = "Author";
	public static final int SECTION_AUTHOR_ID = 13;
	public static final String SECTION_AUTHOR_ARTICLES_NAME = "Author articles";
	public static final int SECTION_AUTHOR_ARTICLES_ID = 14;
	public static final String SECTION_VIDEO_NAME = "Video";
	public static final int SECTION_VIDEO_ID = 15;
	public static final String SECTION_SEARCH_NAME = "Search";
	public static final int SECTION_SEARCH_ID = 16;

	public static final int[] SECTIONS_WITH_SPECIAL_WS_URL = new int[] { SECTION_LEMONDE_ID,
			SECTION_POPCORN_ID, SECTION_VOUSAVEZ_ID_5MIN, SECTION_VOUSAVEZ_ID_10MIN,
			SECTION_VOUSAVEZ_ID_15MIN, SECTION_PERSONALITIES_ID, SECTION_CHRONIQUES_ID,
			SECTION_PLUSLUS_ID };

	// Sections with a special block inside
	public static final int SECTION_ACTUALITES_ID = 52;
	public static final int SECTION_CULTURE_ID = 30;

	// Home configuration
	public static int HOME_NUM_FEATURE_ELEMENTS = 3;
	public static int HOME_NUM_LASTARTICLES_ELEMENTS = 4;

	// models
	public static String MODEL_ARTICLE = "Merlin\\BackendBundle\\Entity\\Articles";
	public static String MODEL_GALLERY = "Merlin\\BackendBundle\\Entity\\Galleries";
	public static String MODEL_VIDEO = "Merlin\\BackendBundle\\Entity\\Videos";

	// Fonts for Typefaces
	public static final String FONT_FUTURA_BOLD = "fonts/FuturaStd-Bold.ttf";
	public static final String FONT_FUTURA_HEAVY = "fonts/FuturaStd-Heavy.ttf";
	public static final String FONT_FUTURA_MEDIUM = "fonts/FuturaStd-Medium.ttf";
	public static final String FONT_VANITE_BOLD = "fonts/vaniteweb-bold.ttf";
	public static final String FONT_VANITE_LIGHT = "fonts/vaniteweb-light.ttf";
	public static final String FONT_VANITE_REGULAR = "fonts/vaniteweb-regular.ttf";
	public static final String FONT_VF_ICONS = "fonts/VFIcons.ttf";
	public static final String FONT_VFDIDOT3_REGULAR = "fonts/vfdidot3-regular.ttf";
	public static final String FONT_VFDIDOT3_SEMIBOLD_ITALIC = "fonts/vfdidot3-semibolditalic.ttf";
	public static final String FONT_TIMES = "fonts/times-new-roman.ttf";
	public static final String FONT_TIMES_ITALIC = "fonts/times-new-roman-italic.ttf";
	public static final String FONT_TIMES_BOLD_ITALIC = "fonts/times-new-roman-bold-italic.ttf";

	public static final String EMAIL_APP = "iphone.styleacademie@condenast.fr";
	public static final String EMAIL_SUGGEST = EMAIL_APP;
	public static final String EMAIL_SOS = EMAIL_APP;

	public static final boolean SMARTAD_ENABLED = true;
	public static final boolean SMARTAD_ENABLED_INTERSTITIAL = true;
	// SMARTAD VALUES PHONE
	public static final int SMARTAD_SITEID_TEST = 35176;
	public static final int SMARTAD_FORMAT_BANNER_TEST = 15140;
	public static final int SMARTAD_FORMAT_INTERSTITIAL_TEST = 12167;
	public static final String SMARTAD_PAGEID_BANNER_HOME_TEST = "(news_activity)";
	public static final String SMARTAD_PAGEID_BANNER_OTHERS_TEST = "(news_activity)";
	public static final String SMARTAD_PAGEID_INTERSTITIAL_HOME_TEST = "(news_activity)";

	public static final int SMARTAD_SITEID_PROD = 54795;
	public static final int SMARTAD_FORMAT_BANNER_PROD = 13535;
	public static final int SMARTAD_FORMAT_INTERSTITIAL_PROD = 13534;
	public static final String SMARTAD_PAGEID_BANNER_HOME_PROD = "404362";
	public static final String SMARTAD_PAGEID_BANNER_OTHERS_PROD = "404362";
	public static final String SMARTAD_PAGEID_INTERSTITIAL_HOME_PROD = "404363";

	public static final int SMARTAD_SITEID = SMARTAD_SITEID_PROD;
	public static final int SMARTAD_FORMAT_BANNER = SMARTAD_FORMAT_BANNER_PROD;
	public static final int SMARTAD_FORMAT_INTERSTITIAL = SMARTAD_FORMAT_INTERSTITIAL_PROD;
	public static final String SMARTAD_PAGEID_BANNER_HOME = SMARTAD_PAGEID_BANNER_HOME_PROD;
	public static final String SMARTAD_PAGEID_BANNER_OTHERS = SMARTAD_PAGEID_BANNER_OTHERS_PROD;
	public static final String SMARTAD_PAGEID_INTERSTITIAL_HOME = SMARTAD_PAGEID_INTERSTITIAL_HOME_PROD;

	// SMARTAD VALUES TABLET
	public static final int SMARTAD_TABLET_SITEID_TEST = 35176;
	public static final int SMARTAD_TABLET_FORMAT_BANNER_TEST = 15140;
	public static final int SMARTAD_TABLET_FORMAT_INTERSTITIAL_TEST = 12167;
	public static final String SMARTAD_TABLET_PAGEID_BANNER_HOME_TEST = "(news_activity)";
	public static final String SMARTAD_TABLET_PAGEID_BANNER_OTHERS_TEST = "(news_activity)";
	public static final String SMARTAD_TABLET_PAGEID_INTERSTITIAL_HOME_TEST = "(news_activity)";

	public static final int SMARTAD_TABLET_SITEID_PROD = 54795;
	public static final int SMARTAD_TABLET_FORMAT_BANNER_PROD = 13535;
	public static final int SMARTAD_TABLET_FORMAT_INTERSTITIAL_PROD = 13534;
	public static final String SMARTAD_TABLET_PAGEID_BANNER_HOME_PROD = "404362";
	public static final String SMARTAD_TABLET_PAGEID_BANNER_OTHERS_PROD = "404362";
	public static final String SMARTAD_TABLET_PAGEID_INTERSTITIAL_HOME_PROD = "404363";

	public static final int SMARTAD_TABLET_SITEID = SMARTAD_TABLET_SITEID_PROD;
	public static final int SMARTAD_TABLET_FORMAT_BANNER = SMARTAD_TABLET_FORMAT_BANNER_PROD;
	public static final int SMARTAD_TABLET_FORMAT_INTERSTITIAL = SMARTAD_TABLET_FORMAT_INTERSTITIAL_PROD;
	public static final String SMARTAD_TABLET_PAGEID_BANNER_HOME = SMARTAD_TABLET_PAGEID_BANNER_HOME_PROD;
	public static final String SMARTAD_TABLET_PAGEID_BANNER_OTHERS = SMARTAD_TABLET_PAGEID_BANNER_OTHERS_PROD;
	public static final String SMARTAD_TABLET_PAGEID_INTERSTITIAL_HOME = SMARTAD_TABLET_PAGEID_INTERSTITIAL_HOME_PROD;

	// Image width to be requested to API, it depends on width in px of the
	// device
	public static int[] WS_IMAGE_SIZES = { 480, 720, 1200, 1600 };
	// other sizes { 240, 320, 480, 600, 720, 800, 1024, 1200, 1600 };

	// Twitter configuration
	public final static String TWITTER_CONSUMER_KEY = "RG8aAgpwmzkaQSvCWfE9Q";
	public final static String TWITTER_CONSUMER_SECRET = "WqS4bhhPsh6pgkMbMyxY167Bttkk0Cc55Kl6HnA";
	// Vogue
	// public final static String TWITTER_CONSUMER_KEY =
	// "GVXH0n7UYOhf6WZKzQ8GTg";
	// public final static String TWITTER_CONSUMER_SECRET =
	// "11OXu2a2zqql9FK7JLx4cL1Az9bbYQV79RwsiGjIEhg";
	public final static int TWITTER_MAX_CHARS_WITH_MEDIA = 94;
	public static final String TWITTER_CALLBACK_URL = "oauth://twitter4j";

	// Facebook configuration
	public static final String FACEBOOK_APP_ID = "1395660837340012";

	// Crittercism configuration
	public static final String CRITTERCISM_ID = "527a0e6746b7c270ee000001";

	// AQuery configuration
	public static final Boolean AQUERY_DEBUG = false;
	public static String AQUERY_CACHE_DIR = "VanityFair";
	// max number of images (width>50) to be cached in memory, default is 20
	public static int AQUERY_CACHE_LIMIT = 200;
	// max size of an image to be cached in memory, default is
	// 1600pixels (400x400)
	public static int AQUERY_PIXEL_LIMIT = 640 * 360;

	// Notification with GCM (Google Cloud Messaging) configuration
	public static final String GCM_SENDER_ID = "699783331380";
	static final String NOTIFICATION_SERVER_URL_BASE_PROD = "http://merlin.vogue.fr";
	static final String NOTIFICATION_SERVER_URL_BASE_PRE = "http://merlin.preprod.digital.condenast.fr";
	static final String NOTIFICATION_SERVER_URL_BASE_DEV = "http://192.168.1.61";
	static final String NOTIFICATION_SERVER_URL_BASE = NOTIFICATION_SERVER_URL_BASE_PROD;
	static final String NOTIFICATION_SERVER_URL_REGISTER = NOTIFICATION_SERVER_URL_BASE
			+ "/androidapptokens/register_device";
	static final String NOTIFICATION_SERVER_URL_UNREGISTER = NOTIFICATION_SERVER_URL_BASE
			+ "/androidapptokens/unregister_device";

	public static final String URL_ACILIA = "http://acilia.es";
	public static final String URL_FACEBOOK = "https://www.facebook.com/vanityfairfr";
	public static final String URL_TWITTER = "https://twitter.com/VanityFairFR";
	public static final String URL_GOOGLEPLUS = "https://plus.google.com/108440886420511258234/posts";
	public static final String URL_PINTEREST = "http://www.pinterest.com/vanityfairfr/";

	public static final String DATE_FORMAT = "dd MMMM yyyy";
	public static final String DATE_FORMAT_PUBLISH = "dd/MM/yyyy";
	public static final String TIME_FORMAT_PUBLISH = "hh:mm";

	public static final int SHARE_ID_FACEBOOK = 1;
	public static final int SHARE_ID_TWITTER = 2;
	public static final int SHARE_ID_EMAIL = 3;
	public static final int SHARE_ID_ANDROID = 4;
	
	public static final int THRESHOLD_SCROLL_HORIZONTAL = 50;
	public static final int THRESHOLD_SCROLL_VERTICAL = 150;
	
	public static final String GA_UA_TRACKER2 = "UA-1199649-24";
}
