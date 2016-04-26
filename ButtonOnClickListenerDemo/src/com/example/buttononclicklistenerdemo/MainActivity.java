package com.example.buttononclicklistenerdemo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;

public class MainActivity extends Activity implements OnClickListener {

	private Button button1;
	private Button button2;
	private Button button3;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		button1 = (Button) findViewById(R.id.button1);
		button1.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				Log.i("MainActivity", "button1 click.");
				Toast.makeText(getApplicationContext(), "button1 click.", Toast.LENGTH_SHORT).show();
			}
		});
		
		button2 = (Button) findViewById(R.id.button2);
		button2.setOnClickListener(listener);
		
		button3 = (Button) findViewById(R.id.button3);
		button3.setOnClickListener(this);
	}
	
	OnClickListener listener = new OnClickListener() {		
		@Override
		public void onClick(View v) {
			Log.i("MainActivity", "button2 click.");
			Toast.makeText(getApplicationContext(), "button2 click.", Toast.LENGTH_SHORT).show();
		}
	};

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
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View v) {
		Log.i("MainActivity", "button3 click.");
		Toast.makeText(getApplicationContext(), "button3 click.", Toast.LENGTH_SHORT).show();
	}
}
