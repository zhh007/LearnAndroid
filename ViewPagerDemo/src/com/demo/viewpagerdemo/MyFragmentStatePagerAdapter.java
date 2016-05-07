package com.demo.viewpagerdemo;

import java.util.List;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;

public class MyFragmentStatePagerAdapter extends FragmentStatePagerAdapter {

	private List<Fragment> fragList;
	private List<String> titleList;
	public MyFragmentStatePagerAdapter(FragmentManager fm, List<Fragment> fragList, List<String> titleList) {
		super(fm);
		this.fragList = fragList;
		this.titleList = titleList;
	}

	@Override
	public Fragment getItem(int arg0) {
		return fragList.get(arg0);
	}

	@Override
	public int getCount() {
		return fragList.size();
	}

	@Override
	public CharSequence getPageTitle(int position) {
		return titleList.get(position);
	}
	
	@Override
	public Object instantiateItem(ViewGroup arg0, int arg1) {
		// TODO Auto-generated method stub
		return super.instantiateItem(arg0, arg1);
	}
	
	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		// TODO Auto-generated method stub
		super.destroyItem(container, position, object);
	}
}
