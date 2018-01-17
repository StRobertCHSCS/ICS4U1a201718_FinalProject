package com.strobertchs.finalproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class examschedule extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_examschedule);

        WebView mWebView= findViewById(R.id.webView);
        mWebView.getSettings().setJavaScriptEnabled(true);
        // mWebView.getSettings().setPluginState(WebSettings.PluginState.ON);
        mWebView.loadUrl("http://docs.google.com/viewer?url=http://stro.ycdsb.ca/wp-content/uploads/sites/104/2017/12/Exam-Schedule-29Nov17.pdf");
    }
}
