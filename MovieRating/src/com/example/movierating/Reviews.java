package com.example.movierating;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Reviews extends Activity implements OnClickListener{
	TextView reviewstxt;
	Button ok1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.reviews);
		reviewstxt=(TextView)findViewById(R.id.reviewstxt);
		ok1=(Button)findViewById(R.id.ok1);
		ok1.setOnClickListener(this);
		
		Intent myint= getIntent();
		Bundle b1=myint.getExtras();
		String name=b1.getString("name");
		String year=b1.getString("year");
		String type=b1.getString("type");
		String duration=b1.getString("duration");
		String rating=b1.getString("rating");
		String reviews=b1.getString("reviews");

		String starring=b1.getString("starring");

		String director=b1.getString("director");
		
		reviewstxt.setText("Moview Name:"+name+"\n"+"Movie Genere:"+type+"\n"+"Release Year"+year+"\n"+"Duration:"+duration+"\n"+"Movie Rating:"+rating+"\n"+"Reviews:"+reviews+"\n"+"Starring:"+starring+"\n"+"Director:"+director+"\n");
	
	}
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		if(arg0.equals(ok1)){
			
			
			Intent mynewint=new Intent(this, ReviewsList.class);
			startActivity(mynewint);
			
			
		}
	}
	
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
		
	}
	
	
	

}
