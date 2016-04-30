package com.demo.activitylifetimedemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
/*
 * 创建到销毁的生命周期
 * onCreate() -> onStart() -> onResume()
 * -> onPause() -> onStop() -> onDestroy()
 * 从启动到后台，再到前台的生命周期
 * onCreate() -> onStart() -> onResume()
 * -> onPause() -> onStop()
 * -> onRestart() -> onStart() -> OnResume()
 * 从启动到失去焦点，再到获取到焦点的生命周期
 * onCreate() -> onStart() ->onResume()
 * -> onPause()
 * -> onResume()
 * */
public class MainActivity extends Activity {

	final String TAG = "MainActivity";
	Button btn1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		btn1 = (Button) findViewById(R.id.btn_test);
		btn1.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(MainActivity.this, SecondActivity.class);
				MainActivity.this.startActivity(intent);
			}			
		});
	}
	
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		Log.i(TAG, "MainActivity -> onStart.");
	}
	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		Log.i(TAG, "MainActivity -> onPause.");
	}
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Log.i(TAG, "MainActivity -> onResume.");
	}
	
	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		Log.i(TAG, "MainActivity -> onStop.");
	}
	
	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
		Log.i(TAG, "MainActivity -> onRestart.");
	}
	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Log.i(TAG, "MainActivity -> onDestroy.");
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
		return super.onOptionsItemSelected(item);
	}
}
