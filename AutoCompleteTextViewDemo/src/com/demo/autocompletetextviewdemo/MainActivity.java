package com.demo.autocompletetextviewdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.*;

public class MainActivity extends Activity {

	private AutoCompleteTextView acTextView;
	private MultiAutoCompleteTextView macTextView;
	private String[] res = {"beijing1", "beijing2", "beijing3", "shanghai1", "shanghai2"};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		acTextView = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView1);		
		ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, res);
		acTextView.setAdapter(adapter);
		
		macTextView = (MultiAutoCompleteTextView) findViewById(R.id.multiAutoCompleteTextView1);
		macTextView.setAdapter(adapter);
		//以逗号位分隔符
		macTextView.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
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
