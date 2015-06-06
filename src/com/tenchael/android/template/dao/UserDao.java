package com.tenchael.android.template.dao;

import java.util.ArrayList;

import com.tenchael.android.template.bean.User;
import com.tenchael.android.template.db.UserSQLiteOpenHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class UserDao {
	UserSQLiteOpenHelper helper = null;

	public UserDao(Context context) {
		super();
		this.helper = new UserSQLiteOpenHelper(context);
	}

	public long add(User user) {
		SQLiteDatabase db = this.helper.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put("id", ""+user.getId());
		values.put("username", user.getUsername());
		values.put("apikey", user.getApikey());
		long id = db.insert("user", null, values);
		db.close();
		return id;
	}

	public boolean find(String username) {
		SQLiteDatabase db = this.helper.getReadableDatabase();
		Cursor cursor = db.query("user", null, "username=?",
				new String[] { username }, null, null, null);
		boolean result = cursor.moveToNext();
		cursor.close();
		db.close();
		return result;
	}

	public int update(long id, String apikey) {
		SQLiteDatabase db = this.helper.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put("apikey", apikey);
		int number = db.update("user", values, "id=?",
				new String[] { ""+id });
		db.close();
		return number;
	}

	public int delete(long id) {
		SQLiteDatabase db = this.helper.getWritableDatabase();
		// db.execSQL("delete from person where name=?", new Object[] { name });
		int number = db.delete("user", "id=?", new String[] { ""+id });
		db.close();
		return number;
	}

	public ArrayList<User> findAll() {
		SQLiteDatabase db = this.helper.getReadableDatabase();
		ArrayList<User> persons = new ArrayList<User>();
		Cursor cursor = db.query("user", null, null, null, null, null, null);
		while (cursor.moveToNext()) {
			long id = Long.parseLong(cursor.getString(cursor
					.getColumnIndex("id")));
			String username = cursor.getString(cursor
					.getColumnIndex("username"));
			String apikey = cursor.getString(cursor.getColumnIndex("apikey"));
			User p = new User(id, username, apikey);
			persons.add(p);
		}
		cursor.close();
		db.close();
		return persons;

	}

}
