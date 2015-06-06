package com.tenchael.android.template.qiniu;

import org.json.JSONObject;

import android.util.Log;

import com.qiniu.android.http.ResponseInfo;
import com.qiniu.android.storage.UpCompletionHandler;
import com.qiniu.android.storage.UploadManager;

public class QiniuClient {
	protected static final String TAG = "QiniuClient";
	private static UploadManager uploadManager = new UploadManager();

	public static boolean upload(String key, byte[] data, String token) {
		// data = <File对象、或 文件路径、或 字节数组>
		// String key = <指定七牛服务上的文件名，或 null>;
		// String token = <从服务端SDK获取>;
		uploadManager.put(data, key, token, new UpCompletionHandler() {

			public void complete(String key, ResponseInfo info,
					JSONObject response) {
				Log.i(TAG, info.toString());
				Log.i(TAG, response.toString());
			}

		}, null);

		return false;

	}

}
