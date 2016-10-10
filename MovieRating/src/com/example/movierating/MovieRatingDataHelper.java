package com.example.movierating;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class MovieRatingDataHelper extends SQLiteOpenHelper{
	 
	static final String database="MovieRating.db";
	static final String table="reviewtable";
	SQLiteDatabase db;
	

	public MovieRatingDataHelper(Context con) {
		super(con, database, null, 1);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase arg0) {
		// TODO Auto-generated method stub
		final String query="create table "+table+" (ID integer PRIMARY KEY AUTOINCREMENT, MovieName text, Type text, Year text, Duration text, Rating text, Reviews text, Starring text, Director text)";
		arg0.execSQL(query);
		
	}
	
//public void insertRecord(String mname, String type, String year, String duration, String rating, String reviews, String starring, String director){
	public void insertRecord(MovieN obj){
		db=this.getWritableDatabase();
		//final String query="insert into "+table+" (Name, Email, Password, DOB, Phone, Address) values (name, email, password, dob, phone, address)";
		//db.execSQL(query);
		
		
		ContentValues cv=new ContentValues();
		cv.put("MovieName", obj.getName());
		cv.put("Type", obj.getType());
		cv.put("Year", obj.getYear());
		cv.put("Duration", obj.getDuration());
		cv.put("Rating", obj.getRating());
		cv.put("Reviews", obj.getReviews());
		cv.put("Starring", obj.getStarring());
		cv.put("Director", obj.getDirection());
		
		db.insert(table, null, cv);
		
	}

public List<String> viewAllName(){
	db=this.getReadableDatabase();
	ArrayList<String> listdata=new ArrayList<String>();
	Cursor data=db.query(table, new String[]{"MovieName"}, null, null, null, null, null, null);
	if(data.moveToFirst()){
		while(data.isAfterLast()==false){
			String n = data.getString(0);
			listdata.add(n);
			data.moveToNext();
		}
	}else{
		data.close();
	}
	return listdata;
	
}


public MovieN viewName(String n1){
	db=this.getReadableDatabase();
	MovieN data1=new MovieN();
	Cursor data=db.query(table, new String[]{"MovieName", "Type", "Year", "Duration", "Rating", "Reviews", "Starring", "Director"}, "MovieName='"+n1+"'", null, null, null, null, null);
	if(data.moveToFirst()){
		data1.setName(data.getString(0));
		data1.setType(data.getString(1));
		data1.setYear(data.getString(2));
		data1.setDuration(data.getString(3));
		data1.setRating(data.getString(4));
		data1.setReviews(data.getString(5));
		data1.setStarring(data.getString(6));
		data1.setDirection(data.getString(7));
		
	}
	
	return data1;
	
}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}

}
