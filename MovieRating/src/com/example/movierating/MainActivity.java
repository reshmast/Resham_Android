package com.example.movierating;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener{
	
	EditText moviename, year, duration, reviews, starring, director;
	Spinner type;
	ArrayAdapter<String> ad;
	String[] myarray={"Comedy","Action", "History", "Horror", "Drama", "Animation", "Family"};
	RatingBar rating;
	Button save;
	MovieRatingDataHelper sql;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		moviename=(EditText)findViewById(R.id.moviename);
		year=(EditText)findViewById(R.id.year);
		duration=(EditText)findViewById(R.id.duration);
		reviews=(EditText)findViewById(R.id.reviews);
		starring=(EditText)findViewById(R.id.starring);
		director=(EditText)findViewById(R.id.director);
		
		type=(Spinner)findViewById(R.id.genre);
		
		rating=(RatingBar)findViewById(R.id.ratingbar);
		
		save=(Button)findViewById(R.id.save);
		
		sql=new MovieRatingDataHelper(this);
		
		save.setOnClickListener(this);
		director.setOnClickListener(this);
		
		ad= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, myarray);
		ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		type.setAdapter(ad);
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated
		String mname=moviename.getText().toString();
		String myear=year.getText().toString();
		String mduration=duration.getText().toString();
		String mreview=reviews.getText().toString();
		String mstarring=starring.getText().toString();
		String mdirector=director.getText().toString();
		String mtype=type.getSelectedItem().toString();
		String mrating=String.valueOf(rating.getRating());
		MovieN obj=new MovieN();
		obj.setName(mname);
		obj.setYear(myear);
		obj.setDuration(mduration);
		obj.setStarring(mstarring);
		obj.setDirection(mdirector);
		obj.setType(mtype);
		obj.setReviews(mreview);
		obj.setRating(mrating);
		
		
		if(arg0.equals(save)){
			try{
				sql.insertRecord(obj);
				Toast.makeText(this, "Data Saved!", Toast.LENGTH_LONG).show();
				
			}catch(Exception e){
				Log.e("mainerror", "error");
			}
			
			Intent myint=new Intent(this, Reviews.class);
			Bundle b=new Bundle();
			b.putString("name", mname);
			b.putString("year", myear);
			b.putString("duration", mduration);
			b.putString("rating", mrating);
			b.putString("reviews", mreview);
			b.putString("starring", mstarring);
			b.putString("director", mdirector);
			b.putString("type", mtype);
			
			myint.putExtras(b);
			startActivity(myint);
		
		}
		
		if(arg0.equals(director)){
			
			Intent myint=new Intent(this, Director.class);
			startActivityForResult(myint, 777);
			
		}
		
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if(requestCode==777 && resultCode==Activity.RESULT_OK){
			director.setText(data.getStringExtra("directorname"));
		}
		
	}
	
	

}
