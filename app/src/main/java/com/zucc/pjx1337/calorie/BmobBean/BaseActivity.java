package com.zucc.pjx1337.calorie.BmobBean;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Toast;

import cn.bmob.v3.exception.BmobException;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

public class BaseActivity extends AppCompatActivity {
	
	public static String TAG = "bmob";

	private CompositeSubscription mCompositeSubscription;

	/**
	 * 解决Subscription内存泄露问题
	 * @param s
	 */
	protected void addSubscription(Subscription s) {
		if (this.mCompositeSubscription == null) {
			this.mCompositeSubscription = new CompositeSubscription();
		}
		this.mCompositeSubscription.add(s);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	
	public void toast(String msg){
		Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
	}
	
	Toast mToast;

	public void showToast(String text) {
		if (!TextUtils.isEmpty(text)) {
			if (mToast == null) {
				mToast = Toast.makeText(getApplicationContext(), text,
						Toast.LENGTH_SHORT);
			} else {
				mToast.setText(text);
			}
			mToast.show();
		}
	}
	
	public void showToast(int resId) {
		if (mToast == null) {
			mToast = Toast.makeText(getApplicationContext(), resId,
					Toast.LENGTH_SHORT);
		} else {
			mToast.setText(resId);
		}
		mToast.show();
	}
	
	public static void log(String msg) {
		Log.i(TAG,"===============================================================================");
		Log.i(TAG, msg);
	}

	public static void loge(Throwable e) {
		Log.i(TAG,"===============================================================================");
		if(e instanceof BmobException){
			Log.e(TAG, "错误码："+((BmobException)e).getErrorCode()+",错误描述："+((BmobException)e).getMessage());
		}else{
			Log.e(TAG, "错误描述："+e.getMessage());
		}
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		if (this.mCompositeSubscription != null) {
			this.mCompositeSubscription.unsubscribe();
		}
	}
}
