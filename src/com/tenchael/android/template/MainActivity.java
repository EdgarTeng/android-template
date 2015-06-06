package com.tenchael.android.template;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewConfiguration;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.tenchael.android.template.commons.T;

public class MainActivity extends FragmentActivity implements
		OnPageChangeListener, OnClickListener {

	protected static final String TAG = "MainActivity";
	private ViewPager mViewPager;
	private List<Fragment> mTabs = new ArrayList<Fragment>();
	private FragmentPagerAdapter mAdapter;

	// 定义3个Fragment的对象
	private Fragment1 fg1;
	private Fragment2 fg2;
	private Fragment3 fg3;
	// 定义底部导航栏的三个布局
	private RelativeLayout course_layout;
	private RelativeLayout found_layout;
	private RelativeLayout settings_layout;
	// 定义底部导航栏中的ImageView与TextView
	private ImageView course_image;
	private ImageView found_image;
	private ImageView settings_image;
	private TextView course_text;
	private TextView settings_text;
	private TextView found_text;
	// 定义要用的颜色值
	private int whirt = 0xFFFFFFFF;
	private int gray = 0xFF7597B3;
	private int blue = 0xFF0AB2FB;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initViews();
		initDatas();

		setOverflowShowingAlways();
		getActionBar().setDisplayShowHomeEnabled(false);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onMenuOpened(int featureId, Menu menu) {
		if (featureId == Window.FEATURE_ACTION_BAR && menu != null) {
			if (menu.getClass().getSimpleName().equals("MenuBuilder")) {
				try {
					Method m = menu.getClass().getDeclaredMethod(
							"setOptionalIconsVisible", Boolean.TYPE);
					m.setAccessible(true);
					m.invoke(menu, true);
				} catch (Exception e) {
				}
			}
		}
		return super.onMenuOpened(featureId, menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_function_test) {
			T.show(this, "功能测试", Toast.LENGTH_SHORT);
			Intent intent = new Intent(this, FunctionTestActivity.class);
			startActivity(intent);
			T.show(this, "功能测试1212", Toast.LENGTH_SHORT);
			return true;
		}
		if (id == R.id.action_add_friend) {
			T.show(this, "添加朋友", Toast.LENGTH_SHORT);
		}
		return super.onOptionsItemSelected(item);
	}

	// 完成组件的初始化
	public void initViews() {
		mViewPager = (ViewPager) findViewById(R.id.id_viewpager);
		course_image = (ImageView) findViewById(R.id.course_image);
		found_image = (ImageView) findViewById(R.id.found_image);
		settings_image = (ImageView) findViewById(R.id.setting_image);
		course_text = (TextView) findViewById(R.id.course_text);
		found_text = (TextView) findViewById(R.id.found_text);
		settings_text = (TextView) findViewById(R.id.setting_text);
		course_layout = (RelativeLayout) findViewById(R.id.course_layout);
		found_layout = (RelativeLayout) findViewById(R.id.found_layout);
		settings_layout = (RelativeLayout) findViewById(R.id.setting_layout);
		mViewPager.setOnPageChangeListener(this);
		course_layout.setOnClickListener(this);
		found_layout.setOnClickListener(this);
		settings_layout.setOnClickListener(this);
	}

	private void initDatas() {
		fg1 = new Fragment1();
		fg2 = new Fragment2();
		fg3 = new Fragment3();
		mTabs.add(fg1);
		mTabs.add(fg2);
		mTabs.add(fg3);
		mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
			@Override
			public int getCount() {
				return mTabs.size();
			}

			@Override
			public Fragment getItem(int position) {
				return mTabs.get(position);
			}
		};
		mViewPager.setAdapter(mAdapter);

		// 设置初始Fragment
		selectItem(0);
		mViewPager.setCurrentItem(0);

	}

	private void selectItem(int position) {
		switch (position) {
		case 0:
			course_image.setImageResource(R.drawable.ic_tabbar_course_pressed);
			course_text.setTextColor(blue);
			course_layout.setBackgroundResource(R.drawable.ic_tabbar_bg_click);
			break;
		case 1:
			found_image.setImageResource(R.drawable.ic_tabbar_found_pressed);
			found_text.setTextColor(blue);
			found_layout.setBackgroundResource(R.drawable.ic_tabbar_bg_click);
			break;
		case 2:
			settings_image
					.setImageResource(R.drawable.ic_tabbar_settings_pressed);
			settings_text.setTextColor(blue);
			settings_layout
					.setBackgroundResource(R.drawable.ic_tabbar_bg_click);
			break;
		}
	}

	@Override
	public void onClick(View v) {
		resetViews();
		switch (v.getId()) {
		case R.id.course_layout:
			mViewPager.setCurrentItem(0, true);
			break;
		case R.id.found_layout:
			mViewPager.setCurrentItem(1, true);
			break;
		case R.id.setting_layout:
			mViewPager.setCurrentItem(2, true);
			break;
		}

	}

	@Override
	public void onPageSelected(int position) {
		resetViews();
		selectItem(position);
	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		Log.i(TAG, arg0 + ", " + arg1 + ", " + arg1);

	}

	@Override
	public void onPageScrollStateChanged(int arg0) {
		// TODO Auto-generated method stub

	}

	// 定义一个重置所有选项的方法
	public void resetViews() {
		course_image.setImageResource(R.drawable.ic_tabbar_course_normal);
		course_layout.setBackgroundColor(whirt);
		course_text.setTextColor(gray);
		found_image.setImageResource(R.drawable.ic_tabbar_found_normal);
		found_layout.setBackgroundColor(whirt);
		found_text.setTextColor(gray);
		settings_image.setImageResource(R.drawable.ic_tabbar_settings_normal);
		settings_layout.setBackgroundColor(whirt);
		settings_text.setTextColor(gray);
	}

	private void setOverflowShowingAlways() {
		try {
			// true if a permanent menu key is present, false otherwise.
			ViewConfiguration config = ViewConfiguration.get(this);
			Field menuKeyField = ViewConfiguration.class
					.getDeclaredField("sHasPermanentMenuKey");
			menuKeyField.setAccessible(true);
			menuKeyField.setBoolean(config, false);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
