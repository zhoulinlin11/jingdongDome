package com.example.zll.jingdongdome.net;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

import com.example.zll.jingdongdome.R;

public class WebActivity extends AppCompatActivity {

    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        initView();
        Intent intent = getIntent();
        String detailUrl = intent.getStringExtra("DetailUrl");
        mWebView.loadUrl(detailUrl);
    }

    private void initView() {
        mWebView = (WebView) findViewById(R.id.web_view);
    }
}
