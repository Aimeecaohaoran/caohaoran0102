package com.example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;

import com.example.caohaoran0102.R;

public class ShowActivity extends AppCompatActivity {
    private WebView webView;
    private String  url="https://www.zhaoapi.cn/product/getProductDetail?pid=21";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        //初始化
        webView=findViewById(R.id.web_view);
        webView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.loadUrl(url);
            }
        });


    }
}
