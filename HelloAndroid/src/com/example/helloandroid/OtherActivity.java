package com.example.helloandroid;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class OtherActivity extends Activity {
	
	TextView textView;
	MyApp myApp;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_other);
		
		textView = (TextView)this.findViewById(R.id.msg);
		myApp = (MyApp)getApplication();
		textView.setText(myApp.getName());
		
	}
}
