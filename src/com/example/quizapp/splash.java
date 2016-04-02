package com.example.quizapp;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;

public class splash extends Activity {

	public static MediaPlayer mediaPlayer; 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);
		
		mediaPlayer = MediaPlayer.create(this, R.raw.quizapp);
		mediaPlayer.start();
		mediaPlayer.setLooping(true);
		
		Thread t= new Thread(new Runnable() {	
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try{
					Thread.sleep(3000);
					Intent in=new Intent(getApplicationContext(), MainActivity.class);
					startActivity(in);
				}
				catch(Exception e){
					e.printStackTrace();
				}
				finally
				{
					finish();
				}
			
		   	}
		});
		
		t.start();
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}




	}
