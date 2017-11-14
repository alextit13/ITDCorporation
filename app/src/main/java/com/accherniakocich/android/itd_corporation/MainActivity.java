package com.accherniakocich.android.itd_corporation;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ProgressBar;

import com.lusfold.spinnerloading.SpinnerLoading;

public class MainActivity extends AppCompatActivity {

    private WebView mWebView;
    private ProgressBar pb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SpinnerLoading view_pb = findViewById(R.id.pb);
        view_pb.setPaintMode(1);
        view_pb.setCircleRadius(20);
        view_pb.setItemCount(8);

        mWebView = (WebView) findViewById(R.id.webView);
        // включаем поддержку JavaScript
        mWebView.getSettings().setJavaScriptEnabled(true);
        // указываем страницу загрузки
        mWebView.loadUrl("https://ltd-corporation.com/");

        mWebView.setWebViewClient(new MyWebViewClient(){
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                //pb.setVisibility(ProgressBar.VISIBLE);

                view_pb.setVisibility(View.VISIBLE);
                mWebView.setAlpha(0.5f);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                //pb.setVisibility(ProgressBar.GONE);
                mWebView.setAlpha(1f);
                view_pb.setVisibility(View.GONE);
            }
        });
    }

    @Override
    public void onBackPressed() {
        if(mWebView.canGoBack()) {
            mWebView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}
