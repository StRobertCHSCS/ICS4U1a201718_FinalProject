package com.strobertchs.edussentials;

import android.content.Intent;
import android.graphics.Matrix;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;

public class map extends AppCompatActivity {

    private WebView webView;
    private Button changeSecond;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        webView = (WebView) findViewById(R.id.firstMapView);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://justinchan45.wixsite.com/schoolmapone");

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setDisplayZoomControls(false);

        changeSecond = (Button) findViewById(R.id.secondMapChange);
        changeSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSecond();
            }
        });

    }

    public void openSecond() {
        Intent intent = new Intent(this, second_map.class);
        startActivity(intent);
    }

}

