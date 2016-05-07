package com.demo.viewpagerdemo;

import java.util.ArrayList;
import java.util.List;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;

public class Demo3Activity extends FragmentActivity {

	private ViewPager pager;
	private List<Fragment> fragList;
	private PagerTabStrip tab;
	private List<String> titleList;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_demo2);
		
		pager = (ViewPager) findViewById(R.id.pager);
		
		fragList = new ArrayList<Fragment>();
		fragList.add(new Fragment1());
		fragList.add(new Fragment2());
		fragList.add(new Fragment3());
		fragList.add(new Fragment4());
		
		//设置标题
		titleList = new ArrayList<String>();
		titleList.add("第一页");
		titleList.add("第二页");
		titleList.add("第三页");
		titleList.add("第四页");
		
		//设置PagerTabStrip属性
		tab = (PagerTabStrip) findViewById(R.id.tab);
		tab.setBackgroundColor(Color.YELLOW);
		tab.setTextColor(Color.RED);
		tab.setDrawFullUnderline(false);
		tab.setTabIndicatorColor(Color.GREEN);
		
		MyFragmentStatePagerAdapter adapter = new MyFragmentStatePagerAdapter(getSupportFragmentManager(), fragList, titleList);
		pager.setAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.demo2, menu);
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
