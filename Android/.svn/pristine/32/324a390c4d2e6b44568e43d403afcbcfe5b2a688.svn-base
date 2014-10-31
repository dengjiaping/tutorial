package com.nonobank.utils;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * 
* @ClassName: 	VolleyUtils
* @Description: 获得单例VolleyUtils的实例然后拿到RequestQueue
* @author 		mio4kon 
* @mail			mio4kon.dev@gmail.com 
* @date 		2014-9-25 上午11:06:02 
*
 */
public class VolleyUtils {
	private static VolleyUtils mInstance = null;
    private RequestQueue mRequestQueue;
    
    private VolleyUtils(Context context) {
    	mRequestQueue = Volley.newRequestQueue(context);
    }
    
    public static VolleyUtils getInstance(Context context){
        if(mInstance == null){
        	synchronized (VolleyUtils.class) {
				if(mInstance==null){
					mInstance = new VolleyUtils(context);
				}
			}
        }
        return mInstance;
    }
    
	public RequestQueue getmRequestQueue() {
		return mRequestQueue;
	}


	public void release() {
		this.mRequestQueue = null;
		mInstance = null;
	}
}
