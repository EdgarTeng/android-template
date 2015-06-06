package com.tenchael.android.template.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class UserSQLiteOpenHelper extends SQLiteOpenHelper {
	private static final String DBFILENAME = "user.db";
	private static int db_version = 1;

	public UserSQLiteOpenHelper(Context context) {
		super(context, DBFILENAME, null, db_version);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String sql = "create table user(id varchar(20) primary key,username varchar(20),apikey varchar(256))";
		db.execSQL(sql);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		System.out.println("upgrade database");
		String sql = "alter table user add account varchar(20)";
		db.execSQL(sql);
	}

}
