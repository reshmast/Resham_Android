package com.example.movierating;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.RatingBar;
import android.widget.TextView;

public class Reviews1 extends Activity {
	MovieRatingDataHelper sql;
	TextView name, year, type, duration, reviews, starring, director;
	String mname, myear, mtype, mduration, mreviews, mstarring, mdirector;
	float rating;
	RatingBar userRating;
	MovieN obj;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main1);
		name=(TextView)findViewById(R.id.txtname);
		type=(TextView)findViewById(R.id.txttype);
		year=(TextView)findViewById(R.id.txtyear);
		duration=(TextView)findViewById(R.id.txtdur);
		reviews=(TextView)findViewById(R.id.txtreviews);
		starring=(TextView)findViewById(R.id.starring);
		director=(TextView)findViewById(R.id.txtdirector);
		userRating=(RatingBar)findViewById(R.id.userRating);
		
		
		
		sql=new MovieRatingDataHelper(this);
		
		
		Intent myint=getIntent();
		String name1=myint.getStringExtra("name");
		obj=sql.viewName(name1);
		mname=obj.getName();
		mtype=obj.getType();
		myear=obj.getYear();
		mduration=obj.getDuration();
		rating=Float.parseFloat(obj.getRating());
		mreviews=obj.getReviews();
		mdirector=obj.getDirection();
		mstarring=obj.getStarring();
		
		name.setText(mname);
		type.setText(mtype);
		year.setText(myear);
		duration.setText(mduration);
		userRating.setRating(rating);
		starring.setText(mstarring);
		director.setText(mdirector);
		reviews.setText(mreviews);
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main1, menu);
		return true;
	}

}
