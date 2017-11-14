package com.accherniakocich.android.itd_corporation;

import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MyWebViewClient extends WebViewClient {

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url)

    {
        view.loadUrl(url);
        return true;
    }

}
