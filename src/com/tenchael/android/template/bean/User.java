package com.tenchael.android.template.bean;

import java.io.Serializable;

public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id; // 自动生成 主键

	private String username; // 手机号

	private String nickName;

	private String portrait;

	private Long registerTime; // 注册日期

	private String apikey;// 唯一标识,每次登陆自动重新生成并填入.

	private Integer state;// 帐号状态，禁用或者启用，默认启用

	public User() {
	}

	public User(Long id, String username, String apikey) {
		this.id = id;
		this.username = username;
		this.apikey = apikey;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getPortrait() {
		return portrait;
	}

	public void setPortrait(String portrait) {
		this.portrait = portrait;
	}

	public Long getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(Long registerTime) {
		this.registerTime = registerTime;
	}

	public String getApikey() {
		return apikey;
	}

	public void setApikey(String apikey) {
		this.apikey = apikey;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

}
