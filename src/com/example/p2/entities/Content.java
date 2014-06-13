package com.example.p2.entities;

import java.util.Calendar;
import java.util.Date;

import org.json.JSONObject;

import com.example.p2.utils.Utils;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "content")
public class Content {
	public static final String CATEGORY_ID_FIELD_NAME = "category_id";

	@DatabaseField(id = true)
	private int id = 0;

	@DatabaseField
	private int importedId = 0;

	@DatabaseField
	private int appBackendId = 0;

	@DatabaseField
	private int appBackendCategoryId = 0;

	@DatabaseField
	private String title = "";

	@DatabaseField
	private String subtitle = "";

	@DatabaseField
	private String pretitle = "";

	@DatabaseField
	private String posttitle = "";

	@DatabaseField
	private String auxtitle = "";

	@DatabaseField
	private String name = "";

	@DatabaseField
	private String text = "";

	@DatabaseField
	private String address = "";

	@DatabaseField
	private String zipcode = "";

	@DatabaseField
	private String city = "";

	@DatabaseField
	private String country = "";

	@DatabaseField
	private double latitude = 0;

	@DatabaseField
	private double longitude = 0;

	@DatabaseField
	private String signature = "";

	@DatabaseField
	private String hashtag = "";

	@DatabaseField
	private boolean isVisible = false;

	@DatabaseField
	private Date createdAt = Calendar.getInstance().getTime();

	@DatabaseField
	private Date updatedAt = Calendar.getInstance().getTime();

	@DatabaseField
	private Date publishAt = Calendar.getInstance().getTime();

	@DatabaseField
	private int coverImageId = 0;

	@DatabaseField
	private int horizontalImageId = 0;

	@DatabaseField
	private int verticalImageId = 0;

	@DatabaseField
	private int squareImageId = 0;

	@DatabaseField
	private int auxImageId = 0;

	@DatabaseField
	private int extraImageId = 0;

	@DatabaseField
	private String coverBigImage = "";

	@DatabaseField
	private String horizontalBigImage = "";

	@DatabaseField
	private String verticalBigImage = "";

	@DatabaseField
	private String squareBigImage = "";

	@DatabaseField
	private String auxBigImage = "";

	@DatabaseField
	private String extraBigImage = "";

	@DatabaseField
	private String coverSmallImage = "";

	@DatabaseField
	private String horizontalSmallImage = "";

	@DatabaseField
	private String verticalSmallImage = "";

	@DatabaseField
	private String squareSmallImage = "";

	@DatabaseField
	private String auxSmallImage = "";

	@DatabaseField
	private String extraSmallImage = "";

	// CONSTRUCTORS

	public Content() {
		// ORMLite needs a no-arg constructor
	}

	public Content(JSONObject jo) {
		this.id = Utils.jsonOptInt(jo, "id");
		this.importedId = Utils.jsonOptInt(jo, "imported_id");
		this.appBackendId = Utils.jsonOptInt(jo, "appbackend_id");
		this.appBackendCategoryId = Utils.jsonOptInt(jo, "appbackendcategory_id");
		this.title = Utils.jsonOptString(jo, "title");
		this.subtitle = Utils.jsonOptString(jo, "sub_title");
		this.pretitle = Utils.jsonOptString(jo, "pre_title");
		this.posttitle = Utils.jsonOptString(jo, "post_title");
		this.auxtitle = Utils.jsonOptString(jo, "aux_title");
		this.name = Utils.jsonOptString(jo, "name");
		this.text = Utils.jsonOptString(jo, "text");
		this.address = Utils.jsonOptString(jo, "address");
		this.zipcode = Utils.jsonOptString(jo, "zipcode");
		this.city = Utils.jsonOptString(jo, "city");
		this.country = Utils.jsonOptString(jo, "country");
		this.latitude = Double.valueOf(jo.optDouble("latitude"));
		this.longitude = Double.valueOf(jo.optDouble("longitude"));
		this.signature = Utils.jsonOptString(jo, "signature");
		this.hashtag = Utils.jsonOptString(jo, "hashtag");

		this.coverImageId = Utils.jsonOptInt(jo, "cover_image_id");
		this.horizontalImageId = Utils.jsonOptInt(jo, "horizontal_image_id");
		this.verticalImageId = Utils.jsonOptInt(jo, "vertical_image_id");
		this.squareImageId = Utils.jsonOptInt(jo, "square_image_id");
		this.auxImageId = Utils.jsonOptInt(jo, "aux_image_id");
		this.extraImageId = Utils.jsonOptInt(jo, "extra_image_id");
		this.coverBigImage = Utils.jsonOptString(jo, "cover_big_image");
		this.horizontalBigImage = Utils.jsonOptString(jo, "horizontal_big_image");
		this.verticalBigImage = Utils.jsonOptString(jo, "vertical_big_image");
		this.squareBigImage = Utils.jsonOptString(jo, "square_big_image");
		this.auxBigImage = Utils.jsonOptString(jo, "aux_big_image");
		this.extraBigImage = Utils.jsonOptString(jo, "extra_big_image");
		this.coverSmallImage = Utils.jsonOptString(jo, "cover_small_image");
		this.horizontalSmallImage = Utils.jsonOptString(jo, "horizontal_small_image");
		this.verticalSmallImage = Utils.jsonOptString(jo, "vertical_small_image");
		this.squareSmallImage = Utils.jsonOptString(jo, "square_small_image");
		this.auxSmallImage = Utils.jsonOptString(jo, "aux_small_image");
		this.extraSmallImage = Utils.jsonOptString(jo, "extra_small_image");
	}

	// GETTERS AND SETTERS

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public int getImportedId() {
		return importedId;
	}

	public void setImportedId(int importedId) {
		this.importedId = importedId;
	}

	public int getAppBackendId() {
		return appBackendId;
	}

	public void setAppBackendId(int appBackendId) {
		this.appBackendId = appBackendId;
	}

	public int getAppBackendCategoryId() {
		return appBackendCategoryId;
	}

	public void setAppBackendCategoryId(int appBackendCategoryId) {
		this.appBackendCategoryId = appBackendCategoryId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	public String getPretitle() {
		return pretitle;
	}

	public void setPretitle(String pretitle) {
		this.pretitle = pretitle;
	}

	public String getPosttitle() {
		return posttitle;
	}

	public void setPosttitle(String posttitle) {
		this.posttitle = posttitle;
	}

	public String getAuxtitle() {
		return auxtitle;
	}

	public void setAuxtitle(String auxtitle) {
		this.auxtitle = auxtitle;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public String getHashtag() {
		return hashtag;
	}

	public void setHashtag(String hashtag) {
		this.hashtag = hashtag;
	}

	public boolean isVisible() {
		return isVisible;
	}

	public void setVisible(boolean isVisible) {
		this.isVisible = isVisible;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Date getPublishAt() {
		return publishAt;
	}

	public void setPublishAt(Date publishAt) {
		this.publishAt = publishAt;
	}

	// PUBLIC METHODS
	public String getListImage() {
		return coverSmallImage;
	}

	public String getDetailImage() {
		if (!horizontalBigImage.isEmpty()) {
			return horizontalBigImage;
		} else {
			return coverBigImage;
		}
	}

	@Override
	public String toString() {
		return "Content [id=" + id + ", title=" + title + ", name=" + name + "]";
	}

}
