package com.tenchael.android.template.commons;

import org.json.JSONException;
import org.json.JSONObject;

public class JsonMsg {

	private int status;
	private String hintMsg;
	private String content;

	public JsonMsg() {
		super();
	}

	public JsonMsg(String jsonData) {
		try {
			JSONObject json = new JSONObject(jsonData);
			status = json.getInt("status");
			hintMsg = json.getString("msg");
			content = json.getJSONObject("content").toString();
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	public JsonMsg(int status, String hintMsg, String content) {
		super();
		this.status = status;
		this.hintMsg = hintMsg;
		this.content = content;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getHintMsg() {
		return hintMsg;
	}

	public void setHintMsg(String hintMsg) {
		this.hintMsg = hintMsg;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
