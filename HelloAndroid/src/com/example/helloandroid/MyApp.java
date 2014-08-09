package com.example.helloandroid;

import android.R.string;
import android.app.Application;

public class MyApp extends Application {
	public String name;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		setName("уехЩ");
	}
}
