package com.databasehandle;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.SimpleCursorAdapter;

public class Handle {
	
	
	private   SQLiteDatabase db;
	public  void dbhandle(){
		
	 db = SQLiteDatabase.openOrCreateDatabase(
     		"/data/data/com.example.sql/note.db", null);
	 
	 try{
		
	 db.execSQL("create table noteeveryday(_id integer primary key autoincrement,"
				+"note_title varchar(50),"
				+"note_data varchar(255),"
				+"note_date varchar(20))");
				
	 }
	catch(Exception e)
	{
		 
		e.printStackTrace();
	}	 
	}
	public  Cursor  findall() {
		// TODO Auto-generated method stub		
		
		String sql = "select * from  noteeveryday";
		Cursor cursor = db.rawQuery(sql,null);
		return cursor;	
	}
	
	public boolean add(String title,String data,String date)
	{
		boolean flag = false;
		try{
			db.execSQL("insert into noteeveryday  values(null,?,?,?)"
					,new String[]{title,data,date});
			
		
			flag = true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			flag = false;
		}
		
		return flag;
		
	}
	public  Cursor  findall(String i) {
		// TODO Auto-generated method stub		
		
		String sql = "select * from  noteeveryday where _id="+i;
		Cursor cursor = db.rawQuery(sql,null);
		return cursor;	
	}
	public boolean delete(String id)
	{
		boolean flag = false;
		if(id.equals("")||id==null){
			flag=false;
		}
			
		
		
		else{
		String sql ="delete from noteeveryday where _id="+id;
		try{
			
			db.execSQL(sql);
			flag=true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
		return flag;
	}
	}
