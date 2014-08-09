package com.example.democlipboardmanager;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;

import android.R.string;
import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.os.Build;

public class MainActivity extends Activity {

	Button button;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
		
		button = (Button)this.findViewById(R.id.button1);
		button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//从android系统中调用剪切板服务
				//ClipboardManager clipboard = (ClipboardManager)getSystemService(Context.CLIPBOARD_SERVICE);								
				//android.content.ClipData clip = android.content.ClipData.newPlainText("text label","Hi clipboard~~!!");
                //clipboard.setPrimaryClip(clip);				
				//Intent intent = new Intent(MainActivity.this, OtherActivity.class);
				//startActivity(intent);
				
				MyData data = new MyData("jeffrey", 30);
				ByteArrayOutputStream stream = new ByteArrayOutputStream();
				String base64String = "";
				try {
					ObjectOutputStream objStream = new ObjectOutputStream(stream);
					objStream.writeObject(data);
					base64String= Base64.encodeToString(stream.toByteArray(), Base64.DEFAULT);
					objStream.close();					
				} catch (Exception e) {
					// TODO: handle exception
				}
				ClipboardManager clipboard = (ClipboardManager)getSystemService(Context.CLIPBOARD_SERVICE);
				android.content.ClipData clip = android.content.ClipData.newPlainText("text label",base64String);
                clipboard.setPrimaryClip(clip);				
				Intent intent = new Intent(MainActivity.this, OtherActivity.class);
				startActivity(intent);
				
			}
		});
		
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

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}

}
