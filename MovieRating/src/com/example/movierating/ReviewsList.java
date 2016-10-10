package com.example.movierating;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ReviewsList extends Activity implements OnItemClickListener{
	ListView movielist;
	ArrayAdapter<String> ad;
	ArrayList<String> mylist=new ArrayList<String>();
	MovieRatingDataHelper sql;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.review_list);
		movielist=(ListView)findViewById(R.id.movielist);
		sql=new MovieRatingDataHelper(this);
		mylist.addAll(sql.viewAllName());
		ad= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mylist);
		movielist.setAdapter(ad);
		movielist.setOnItemClickListener(this);
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
		String name1=ad.getItem(arg2);
		Intent listInt=new Intent(ReviewsList.this, Reviews1.class);
		listInt.putExtra("name", name1);
		startActivity(listInt);
		Toast.makeText(this, ""+name1, Toast.LENGTH_LONG).show();
		
		
	}

	/*@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		String name1=ad.getItem(position);
		Toast.makeText(this, ""+name1, Toast.LENGTH_LONG).show();
	}
*/
	
	

}
