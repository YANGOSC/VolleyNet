package com.hpe.yanliu.volleynet;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by yanliu on 2016/2/13.
 */
public class MyApplication extends Application{
    //建立请求队列
    public static RequestQueue queues;


    @Override
    public void onCreate() {
        super.onCreate();
        //实例化全局队列,使用app的全局上下文
        queues = Volley.newRequestQueue(getApplicationContext());
    }

    //暴露一个方法用来获取这个请求队列,要将这个application注册到AndroidManifest中
    public static RequestQueue getHttpQueues(){
        return queues;
    }
}
