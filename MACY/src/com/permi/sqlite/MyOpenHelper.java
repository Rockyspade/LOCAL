package com.permi.sqlite;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyOpenHelper extends SQLiteOpenHelper {
	private static final String name = "student";
	private static final int version = 1;

	public MyOpenHelper(Context context) {
		super(context, name, null, version);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		// 学生表
		try {
			String sql = "CREATE TABLE IF NOT EXISTS Student( Snum varchar(8) primary key,"
					+ " Sclass varchar(6),Sname varchar(6),Ssex varchar(2),Sage integer(3),Sphone varchar(12))";
			db.execSQL(sql);

			// 课程表
			sql = "CREATE TABLE IF NOT EXISTS Course("
					+ "Cnum varchar(4) primary key,Cname varchar(10),Ccredit integer(3))";
			db.execSQL(sql);

			// 成绩表

			sql = "CREATE TABLE IF NOT EXISTS Grade(id integer primary key autoincrement,"
					+ "Snum varchar(10),Cnum varchar(4),Score varchar(3))";
			db.execSQL(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		// db.execSQL("DROP TABLE IF EXISTS students");

	}

	public List<String> getStringList(String sql) {
		Cursor cursor = this.getReadableDatabase().rawQuery(sql, null);
		List<String> list = new ArrayList<String>();
		while (cursor.moveToNext()) {
			String str = cursor.getString(0).toString();
			list.add(str);
		}
		return list;
	}
	
	
	public List<Integer> getIntList(String sql) {
		Cursor cursor = this.getReadableDatabase().rawQuery(sql, null);
		List<Integer> list = new ArrayList<Integer>();
		while (cursor.moveToNext()) {
			Integer str = cursor.getInt(0);
			list.add(str);
		}
		return list;
	}
	public List<HashMap<String,String>> getListObject(String sql,String [] n) {
		Cursor cursor = this.getReadableDatabase().rawQuery(sql, null);
		List<HashMap<String,String>> list = new ArrayList<HashMap<String,String>>();
		while (cursor.moveToNext()) {
			HashMap<String,String> map=new HashMap<String,String>();
			for(int i=0;i<n.length;i++){
				map.put(n[i],cursor.getString(i));
			}
			list.add(map);
		}
		return list;
	}
	
	
	
	public String getString(String sql) {
		Cursor cursor = this.getReadableDatabase().rawQuery(sql, null);
		cursor.moveToFirst();
		
			String str = cursor.getString(0).toString();
			
		
		return str;
	}
	
}
