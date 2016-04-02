package com.example.quizapp;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class result extends Activity {

	public static int s;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.result);
		TextView tv = (TextView) findViewById(R.id.textView1);
		Button pa=(Button) findViewById(R.id.button1);
		Button share=(Button) findViewById(R.id.button2);
		

		
		tv.setText("Your final score is "+ quiz.score);
		category.quiz1=quiz.score;
		s=s+quiz.score;
		quiz.score=0;
		
		
		pa.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
			
				Intent intent = new Intent(getApplicationContext(), MainActivity.class);
	        	intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
	        	startActivity(intent);
				finish();
				
				
			}
		});
		
	share.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND); 
			    sharingIntent.setType("text/plain");
			    String shareBody = "Hey!Check it out.I have scored "+category.quiz1+"/10 in "+category.categories[category.id];
			    sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Lets Play!");
			    sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
			startActivity(Intent.createChooser(sharingIntent, "Share via"));
				
			}
		});	
	}
}
