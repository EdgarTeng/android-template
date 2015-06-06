package com.tenchael.android.template.bean;

import java.io.Serializable;
import java.util.List;

public class Info implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String title;

	private String content;

	private Double longitude;// 经度

	private Double latitude;// 纬度

	private Long createTime;

	private Double radius;

	private Integer viewCount;

	private Integer praiseCount;

	private User user;

	private List<String> imageList;

	public Info() {
		super();
	}

	public Info(String title, String content, Double longitude,
			Double latitude, User user) {
		super();
		this.title = title;
		this.content = content;
		this.longitude = longitude;
		this.latitude = latitude;
		this.user = user;
	}

	public Info(Long id, String title, String content, Double longitude,
			Double latitude, Long createTime, Double radius, Integer viewCount,
			Integer praiseCount, User user) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.longitude = longitude;
		this.latitude = latitude;
		this.createTime = createTime;
		this.radius = radius;
		this.viewCount = viewCount;
		this.praiseCount = praiseCount;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getRadius() {
		return radius;
	}

	public void setRadius(Double radius) {
		this.radius = radius;
	}

	public Integer getViewCount() {
		return viewCount;
	}

	public void setViewCount(Integer viewCount) {
		this.viewCount = viewCount;
	}

	public Integer getPraiseCount() {
		return praiseCount;
	}

	public void setPraiseCount(Integer praiseCount) {
		this.praiseCount = praiseCount;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<String> getImageList() {
		return imageList;
	}

	public void setImageList(List<String> imageList) {
		this.imageList = imageList;
	}

}
