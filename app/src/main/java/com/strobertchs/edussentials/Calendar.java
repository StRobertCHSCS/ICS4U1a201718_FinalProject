package com.strobertchs.edussentials;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Calendar extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_club_meeting);

        webView = (WebView) findViewById(R.id.calendarWeb);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("http://http://stro.ycdsb.ca/our-school/calendar");
    }
}
