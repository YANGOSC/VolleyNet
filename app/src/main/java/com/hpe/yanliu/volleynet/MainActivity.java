package com.hpe.yanliu.volleynet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //volley的get请求
        volley_Get();
    }

    private void volley_Get() {
        String url = "http://apis.juhe.cn/mobile/get?phone=13429667914&key=您申请的KEY";
        //建立StringRequest的请求对象,第三个是请求成功的回调，第四个是请求失败的回调
        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                Toast.makeText(MainActivity.this,s,Toast.LENGTH_SHORT).show();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Toast.makeText(MainActivity.this,volleyError.toString(),Toast.LENGTH_SHORT).show();
            }
        });
        //给请求对象设置TAG标签，这样在请求对象加入全局队列后可以通过TAG标签进行寻找
        request.setTag("abcGet");
        //先获取全局队列，再将request添加到全局队列中
        MyApplication.getHttpQueues().add(request);
    }


}
