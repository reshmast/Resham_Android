package com.example.movierating;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

public class Director extends Activity implements OnClickListener{
	
	AutoCompleteTextView directorname;
	String[] myarray={"Guljar", "Karan Johar", "Yesh Chopra"};
	ArrayAdapter<String> ad;
	Button ok;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.director);
		
		directorname=(AutoCompleteTextView)findViewById(R.id.autodirector);
		ok=(Button)findViewById(R.id.ok);
		
		ad=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, myarray);
		directorname.setAdapter(ad);
		
		ok.setOnClickListener(this);
		
	}
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
		Intent myint=new Intent(this, MainActivity.class);
		myint.putExtra("directorname", directorname.getText().toString());
		setResult(RESULT_OK, myint);
		finish();
		
	}
	
	

}
