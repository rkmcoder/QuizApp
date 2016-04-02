package com.example.quizapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
 
public class signin extends Activity {
	
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setting default screen to login.xml
        setContentView(R.layout.signin);
        
        Button b=(Button) findViewById(R.id.btnLogin);
        final EditText user=(EditText) findViewById(R.id.edit1);
        final EditText pass=(EditText) findViewById(R.id.edit2);
        
        b.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				MainActivity.username=user.getText().toString()+"!";
				Intent in = new Intent(getApplicationContext(), MainActivity.class);
				startActivity(in);
				finish();
				
			}
		});
        
        
        
        
 
      
    }
}
