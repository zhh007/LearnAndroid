package com.demo.viewflipperdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class MainActivity extends Activity {

	private ViewFlipper flipper;
	private int[] resId = {R.drawable.pic1, R.drawable.pic2, R.drawable.pic3, R.drawable.pic4};
	private float startX;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		flipper = (ViewFlipper) findViewById(R.id.viewFlipper1);
		//动态导入子View
		for(int i=0; i< resId.length; i++)
		{
			flipper.addView(getImageView(resId[i]));
		}
		
		//（1）自动播放
		//设置动画
		//flipper.setInAnimation(this, R.anim.left_in);
		//flipper.setOutAnimation(this, R.anim.left_out);
		//切换时间间隔
		//flipper.setFlipInterval(3000);//3秒
		//开始播放
		//flipper.startFlipping();
	}
	
	private ImageView getImageView(int resId)
	{
		ImageView image = new ImageView(this);
		//image.setImageResource(resId);
		image.setBackgroundResource(resId);
		return image;
	}
	
	/**
	 * （2）手势切换
	 */
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		switch(event.getAction())
		{
			//手指落下
		case MotionEvent.ACTION_DOWN:
		{
			startX=event.getX();
			break;
		}
		//手指滑动
		case MotionEvent.ACTION_MOVE:
		{
			break;
		}
		//手指离开
		case MotionEvent.ACTION_UP:
		{
			//向右划，看前一页
			if(event.getX()-startX > 100)
			{
				flipper.setInAnimation(this, R.anim.left_in);
				flipper.setOutAnimation(this, R.anim.left_out);
				flipper.showPrevious();
			}
			//向左划
			if(startX-event.getX()>100)
			{
				flipper.setInAnimation(this, R.anim.right_in);
				flipper.setOutAnimation(this, R.anim.right_out);
				flipper.showNext();
			}
			break;
		}
		}
		return super.onTouchEvent(event);
	}
}
