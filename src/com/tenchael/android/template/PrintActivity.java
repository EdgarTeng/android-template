package com.tenchael.android.template;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.widget.TextView;

public class PrintActivity extends ActionBarActivity {

	private static final String TAG = "PrintActivity";
	private Context context;
	private TextView mTextViewMessage;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_print);
		this.context = this;
		this.mTextViewMessage = (TextView) findViewById(R.id.tv_message);
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
			String info = extras.getString("content");
			Log.v(TAG, info);
			mTextViewMessage.setText(info);
		}
	}

}
