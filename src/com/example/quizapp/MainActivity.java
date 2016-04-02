package com.example.quizapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	Button play, menu, signin;
	TextView tv;
	public static String username="Guest!";
	public static int c=0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		play = (Button) findViewById(R.id.button1);
		menu = (Button) findViewById(R.id.button2);
		signin = (Button) findViewById(R.id.button3);
		tv=(TextView) findViewById(R.id.textView2);
		
		tv.setText(username);
		
		
		
		if(username!="Guest!")
		{
			signin.setText("Sign out");
		}
		play.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent in = new Intent(getApplicationContext(), category.class);
				startActivity(in);
				//Toast.makeText(getApplicationContext(),"selected item is",Toast.LENGTH_SHORT).show();

			}
		});

		menu.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				NotificationCompat.Builder mBuilder =
				        new NotificationCompat.Builder(getApplicationContext())
				        .setSmallIcon(R.drawable.ic_launcher)
				        .setContentTitle("QuizApp")
				        .setContentText("Play a game!");
				// Creates an explicit intent for an Activity in your app
				Intent resultIntent = new Intent(getApplicationContext(), MainActivity.class);

				// The stack builder object will contain an artificial back stack for the
				// started Activity.
				// This ensures that navigating backward from the Activity leads out of
				// your application to the Home screen.
				TaskStackBuilder stackBuilder = TaskStackBuilder.create(getApplicationContext());
				// Adds the back stack for the Intent (but not the Intent itself)
				stackBuilder.addParentStack(MainActivity.class);
				// Adds the Intent that starts the Activity to the top of the stack
				stackBuilder.addNextIntent(resultIntent);
				PendingIntent resultPendingIntent =
				        stackBuilder.getPendingIntent(
				            0,
				            PendingIntent.FLAG_UPDATE_CURRENT
				        );
				mBuilder.setContentIntent(resultPendingIntent);
				NotificationManager mNotificationManager =
				    (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
				// mId allows you to update the notification later on.
				mNotificationManager.notify(0, mBuilder.build());
				Intent in = new Intent(getApplicationContext(), menu.class);
				startActivity(in);

			}
		});

		if(username=="Guest!")
		{
		signin.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				finish();
				//Intent in = new Intent(getApplicationContext(), signin.class);
				Intent in = new Intent(getApplicationContext(), signin.class);
				startActivity(in);

			}
		});
		}
		else
		{
			signin.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					username="Guest!";
					//Intent in = new Intent(getApplicationContext(), signin.class);
					finish();
					Intent in = new Intent(getApplicationContext(), MainActivity.class);
					startActivity(in);

				}
			});
		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		Intent in = new Intent(getApplicationContext(), menu.class);
		startActivity(in);
		return super.onOptionsItemSelected(item);
	}
	
	public boolean onKeyDown(int keyCode, KeyEvent event) {
	    if (keyCode == KeyEvent.KEYCODE_BACK) {
	        exitByBackKey();

	        //moveTaskToBack(false);

	        return true;
	    }
	    return super.onKeyDown(keyCode, event);
	}

	protected void exitByBackKey() {

	    AlertDialog alertbox = new AlertDialog.Builder(this)
	    .setMessage("Do you want to exit QuizApp?")
	    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
	    	
	        // do something when the button is clicked
	        public void onClick(DialogInterface arg0, int arg1) {
	        	splash.mediaPlayer.stop();
	        	
	            finish();
	            //close();


	        }
	    })
	    .setNegativeButton("No", new DialogInterface.OnClickListener() {

	        // do something when the button is clicked
	        public void onClick(DialogInterface arg0, int arg1) {
	                       }
	    })
	      .show();

	}
}
