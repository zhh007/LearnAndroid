package com.example.democlipboardmanager;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;

import android.app.Activity;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.util.Base64;
import android.widget.TextView;

public class OtherActivity extends Activity {
	
	TextView textView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_other);
		
		textView = (TextView)this.findViewById(R.id.textView1);
		
		ClipboardManager clipboardManager = (ClipboardManager)getSystemService(Context.CLIPBOARD_SERVICE);
		String msg = clipboardManager.getText().toString();
		
		
		byte[] base64_byte = Base64.decode(msg, Base64.DEFAULT);
		ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(base64_byte);
		try {
			ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
			MyData myData = (MyData)objectInputStream.readObject();
			msg = myData.toString();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		textView.setText(msg);
		
	}
}
