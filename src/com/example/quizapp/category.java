package com.example.quizapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class category extends Activity {
	public static String[] categories={"General Knowlegde","English","Physics","Chemistry","Movies","Technology","Cricket","History","Geography"};
	public static int id;
	Button b1, b2, b3,b4,b5,b6,b7,b8,b9;
	public static int quiz1=6;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		setContentView(R.layout.category);
		final Intent in= new Intent(getApplicationContext(), quiz.class);
		b1=(Button) findViewById(R.id.button1);
		b2=(Button) findViewById(R.id.button2);
		b3=(Button) findViewById(R.id.button3);
		b4=(Button) findViewById(R.id.button4);
		b5=(Button) findViewById(R.id.button5);
		b6=(Button) findViewById(R.id.button6);
		b7=(Button) findViewById(R.id.button7);
		b8=(Button) findViewById(R.id.button8);
		b9=(Button) findViewById(R.id.button9);
		
		View.OnClickListener myhandler = new View.OnClickListener() {
			  public void onClick(View v) {
			      switch(v.getId()) {
			        case R.id.button1:
			        	id=0;  startActivity(in); finish();
			          break;
			        case R.id.button2:
			        	id=1;startActivity(in);finish();
			          break;
			        case R.id.button3:
			        	id=2;startActivity(in);finish();
				          break;
			        case R.id.button4:
			        	id=3;startActivity(in);finish();
				          break;
			        case R.id.button5:
			        	id=4;startActivity(in);finish();
			          break;
			        case R.id.button6:
			        	id=5;startActivity(in);finish();
			          break;
			        case R.id.button7:
			        	id=6;startActivity(in);finish();
				          break;
			        case R.id.button8:
			        	id=7;startActivity(in);finish();
				          break;
			        case R.id.button9:
			        	id=8;startActivity(in);
				          break;
				          
			      }
			  }
			};
			b1.setOnClickListener(myhandler);
		    b2.setOnClickListener(myhandler);
		    b3.setOnClickListener(myhandler);
		    b4.setOnClickListener(myhandler);
		    b5.setOnClickListener(myhandler);
		    b6.setOnClickListener(myhandler);
		    b7.setOnClickListener(myhandler);
		    b8.setOnClickListener(myhandler);
		    b9.setOnClickListener(myhandler);
		    
		
		    super.onCreate(savedInstanceState);
	}
	    
}
	




