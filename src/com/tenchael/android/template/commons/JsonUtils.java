package com.tenchael.android.template.commons;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tenchael.android.template.bean.Info;

public class JsonUtils {

	private JsonUtils() {
		/* cannot be instantiated */
		throw new UnsupportedOperationException("cannot be instantiated");
	}

	public static JsonMsg toJson(String str) {
		JsonMsg jmsg = null;
		try {
			JSONObject json = new JSONObject(str);
			jmsg = new JsonMsg();
			jmsg.setStatus(json.getInt("status"));
			jmsg.setHintMsg(json.getString("msg"));
			jmsg.setContent(json.getJSONObject("content").toString());
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return jmsg;
	}

	public static JSONArray toJsonArray(String jsonWrapper, String key)
			throws JSONException {
		JSONObject json = new JSONObject(jsonWrapper);
		return json.getJSONArray(key);
	}

	public static List<Info> toInfoList(String jsonWrapper, String key)
			throws JSONException {
		JSONArray array = toJsonArray(jsonWrapper, key);
		return toInfoList(array.toString());

	}

	public static List<Info> toInfoList(String jsonData) {
		Gson gson = new Gson();
		List<Info> retList = gson.fromJson(jsonData,
				new TypeToken<List<Info>>() {
				}.getType());
		return retList;
	}

}
