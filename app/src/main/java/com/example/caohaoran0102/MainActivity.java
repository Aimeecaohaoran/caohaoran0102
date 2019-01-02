package com.example.caohaoran0102;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.Toast;

import com.example.ShowActivity;
import com.example.adapter.HomeGridAdapte;
import com.example.adapter.MyAdapter;
import com.example.bean.HomeBean;
import com.example.bean.JsonBean;
import com.example.caohaoran0102.presenter.ShowPresenter;
import com.example.caohaoran0102.view.IShowView;
import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity implements IShowView {

    private GridView gridView,gridView2,gridView3;
    private ShowPresenter showPresenter;
    private JsonBean jsonBean;
    private MyAdapter myAdapter;
    private HomeBean homeBean;
    private HomeGridAdapte myAdapterr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化控件
        gridView=findViewById(R.id.grid_view);
        gridView2=findViewById(R.id.grid_view2);
        gridView3=findViewById(R.id.grid_view3);
        showPresenter=new ShowPresenter(this);
        showPresenter.GetDData("http://172.17.8.100/small/commodity/v1/commodityList");
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(MainActivity.this,ShowActivity.class));
                finish();
                Toast.makeText(MainActivity.this,"确定删除？",Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void getPresenterData(final String data) {
        Gson gson = new Gson();
        homeBean = gson.fromJson(data, HomeBean.class);
        new Thread(){
            @Override
            public void run() {
                super.run();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        myAdapterr = new HomeGridAdapte(MainActivity.this,homeBean);
                        gridView.setAdapter(myAdapterr);
                        gridView2.setAdapter(myAdapterr);
                        gridView3.setAdapter(myAdapterr);
                    }
                });
            }
        }.start();

    }
}
