package com.example.quizapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class achievements extends Activity {
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.achievements);
		TextView gk=(TextView) findViewById(R.id.textView2);
		TextView eng=(TextView) findViewById(R.id.textView1);
		TextView phy=(TextView) findViewById(R.id.textView3);
		TextView chem=(TextView) findViewById(R.id.textView4);
		TextView mov=(TextView) findViewById(R.id.textView5);
		TextView cric=(TextView) findViewById(R.id.textView6);
		TextView tech=(TextView) findViewById(R.id.textView7);
		TextView his=(TextView) findViewById(R.id.textView8);
		TextView geo=(TextView) findViewById(R.id.textView9);
		
		gk.setText(category.categories[0]+"    "+(result.s*10));eng.setText(category.categories[1]+"                        "+(result.s*10)); phy.setText(category.categories[2]+"                      "+(result.s*10));
		chem.setText(category.categories[3]+"                  "+(result.s*10));mov.setText(category.categories[4]+"                         "+(result.s*10));cric.setText(category.categories[5]+"                    "+(result.s*10));
		tech.setText(category.categories[6]+"                     "+(result.s*10));his.setText(category.categories[7]+"                     "+(result.s*10));geo.setText(category.categories[8]+"                  "+(result.s*10));
		
		
		quiz.score=0;
		super.onCreate(savedInstanceState);
	}

}
