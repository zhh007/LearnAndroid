package com.demo.viewpagerdemo;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class Demo1Activity extends Activity implements OnPageChangeListener {

	/**
	 * PagerAdapter 数据源：List<View>，加载3个View，多余自动销毁
	 * FragmentPagerAdapter 数据源：List<Fragment>，全部加载
	 * FragmentStatePagerAdapter 数据源：List<Fragment>
	 */
	private ViewPager pager;
	private List<View> viewList;
	private PagerTabStrip tab;
	private List<String> titleList;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_demo1);
		
		pager = (ViewPager) findViewById(R.id.pager);
		
		//將Layout布局转换为View对象
		//(1)
		//android.view.LayoutInflater lf = getLayoutInflater().from(this);
		//lf.inflate(resource, root);
		//(2)
		//View.inflate(context, resource, root);
		
		View view1 = View.inflate(this, R.layout.view1, null);
		View view2 = View.inflate(this, R.layout.view2, null);
		View view3 = View.inflate(this, R.layout.view3, null);
		View view4 = View.inflate(this, R.layout.view4, null);
		viewList = new ArrayList<View>();
		viewList.add(view1);
		viewList.add(view2);
		viewList.add(view3);
		viewList.add(view4);
		
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
		
		MyPagerAdapter adapter = new MyPagerAdapter(viewList, titleList);
		pager.setAdapter(adapter);
		//pager.setOnPageChangeListener(this);//已过时
		pager.addOnPageChangeListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.demo1, menu);
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
	public void onPageScrollStateChanged(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPageSelected(int arg0) {
		Toast.makeText(this, "当前是第" + (arg0+1) + "个页面", Toast.LENGTH_SHORT).show();
	}
}
