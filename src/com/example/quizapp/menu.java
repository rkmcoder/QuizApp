package com.example.quizapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.RatingBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class menu extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.menu);
		final Switch mySwitch=(Switch) findViewById(R.id.switch1);
		RatingBar r=(RatingBar) findViewById(R.id.ratingBar1);
		TextView av=(TextView) findViewById(R.id.textView2);
		TextView share=(TextView) findViewById(R.id.textView3);
		
		av.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i=new Intent(getApplicationContext(), achievements.class);
				startActivity(i);
				
				
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
		mySwitch.setChecked(true);
		  //attach a listener to check for changes in state
		  mySwitch.setOnCheckedChangeListener(new OnCheckedChangeListener() {
		 
		   @Override
		   public void onCheckedChanged(CompoundButton buttonView,
		     boolean isChecked) {
		 
		    if(isChecked){
		    	mySwitch.setChecked(true);
		    	splash.mediaPlayer.start();
		    	
		    	
		    }else{
		    	mySwitch.setChecked(false);
		    	splash.mediaPlayer.pause();
		    	
		    }
		 
		   }
		  });
		  
		  
		super.onCreate(savedInstanceState);
	}

}
