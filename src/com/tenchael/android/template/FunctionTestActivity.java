package com.tenchael.android.template;

import static com.tenchael.android.template.commons.Constants.INFO_LOCATION_URL;
import static com.tenchael.android.template.commons.Constants.INFO_URL;

import java.io.UnsupportedEncodingException;

import org.apache.http.Header;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.tenchael.android.template.bean.Info;
import com.tenchael.android.template.commons.GPSTracker;
import com.tenchael.android.template.commons.HttpsUtils;
import com.tenchael.android.template.commons.JsonMsg;
import com.tenchael.android.template.commons.JsonUtils;
import com.tenchael.android.template.commons.L;
import com.tenchael.android.template.qiniu.QiniuClient;

public class FunctionTestActivity extends ActionBarActivity {

	private static final String TAG = "FunctionTestActivity";
	private Context context;

	private GPSTracker gpsTracker;
	private double longitude;// 经度
	private double latitude;// 纬度

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_function_test);
		this.context = this;
		this.gpsTracker = new GPSTracker(context);
	}

	public void getInfo(View view) {
		String url = INFO_URL + "/" + 2;
		AsyncHttpClient client = new AsyncHttpClient();

		// setting ssl
		client.setSSLSocketFactory(HttpsUtils.getSSLSocketFactory());
		client.get(url, new AsyncHttpResponseHandler() {
			@Override
			public void onSuccess(int statusCode, Header[] headers,
					byte[] responseBody) {
				try {
					String response = new String(responseBody, "utf-8");
					JsonMsg jmsg = JsonUtils.toJson(response);
					if (jmsg.getStatus() == 1) {
						// Intent intent = new Intent(context,
						// PrintActivity.class);
						// intent.putExtra("content",
						// jmsg.getContent().toString());
						// startActivity(intent);
						// finish();
						try {
							Gson gson = new Gson();
							Info info = gson.fromJson(jmsg.getContent()
									.toString(), Info.class);
							L.v(TAG, info.getContent());
							L.v(TAG, info.getUser().getUsername());
							L.v(TAG, info.getImageList().get(0));
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} else {
						Toast.makeText(context, jmsg.getHintMsg(),
								Toast.LENGTH_SHORT).show();
						return;
					}
				} catch (UnsupportedEncodingException e) {
					Toast.makeText(context, "encoding not support",
							Toast.LENGTH_SHORT).show();
				}
			}

			@Override
			public void onFailure(int statusCode, Header[] headers,
					byte[] responseBody, Throwable error) {
				Toast.makeText(context, "error code: " + statusCode,
						Toast.LENGTH_LONG).show();
			}

		});
	}

	public void getNearbyInfos(View vies) {
		longitude = gpsTracker.getLongitude();
		latitude = gpsTracker.getLatitude();
		Log.v(TAG, "longitude: " + longitude);
		Log.v(TAG, "latitude: " + latitude);

		int pageIndex = 0;// 分页
		String url = INFO_LOCATION_URL + "/" + longitude + "/" + latitude + "/"
				+ pageIndex;
		AsyncHttpClient client = new AsyncHttpClient();

		// setting ssl
		client.setSSLSocketFactory(HttpsUtils.getSSLSocketFactory());
		client.get(url, new AsyncHttpResponseHandler() {
			@Override
			public void onSuccess(int statusCode, Header[] headers,
					byte[] responseBody) {
				try {
					String response = new String(responseBody, "utf-8");
					JsonMsg jmsg = JsonUtils.toJson(response);
					if (jmsg.getStatus() == 1) {
						Intent intent = new Intent(context, PrintActivity.class);
						intent.putExtra("content", jmsg.getContent().toString());
						startActivity(intent);
						finish();
					} else {
						Toast.makeText(context, jmsg.getHintMsg(),
								Toast.LENGTH_SHORT).show();
						return;
					}
				} catch (UnsupportedEncodingException e) {
					Toast.makeText(context, "encoding not support",
							Toast.LENGTH_SHORT).show();
				}
			}

			@Override
			public void onFailure(int statusCode, Header[] headers,
					byte[] responseBody, Throwable error) {
				Toast.makeText(context, "error code: " + statusCode,
						Toast.LENGTH_LONG).show();
			}

		});
	}

	public void upload(View view) {
		QiniuClient client = new QiniuClient();
		String key = "tttengzzzhang.txt";
		String token = "bjyRUWlLZR7lxFRRcsI-V6DllOx0EJXPlRSU2S_m:UjKPz1pNchX0c-1MSdRm2la_xpk=:eyJzY29wZSI6InRlbmNoYWVsLWJ1Y2tldCIsImRlYWRsaW5lIjoxNDMyNzkzMDYxfQ==";
		byte[] data = null;
		try {
			data = "Hello World".getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		client.upload(key, data, token);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		Log.v(TAG, "onCreateOptionsMenu...");
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		Log.v(TAG, "onOptionsItemSelected...");
		return super.onOptionsItemSelected(item);
	}
}
