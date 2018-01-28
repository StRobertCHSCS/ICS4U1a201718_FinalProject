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

public class second_map extends AppCompatActivity {

    private WebView webView;
    private Button changeFirst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_map);

        webView = (WebView) findViewById(R.id.secondMapView);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://justinchan45.wixsite.com/schoolmaptwo");

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setDisplayZoomControls(false);

        changeFirst = (Button) findViewById(R.id.firstMapChange);
        changeFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFirst();
            }
        });

    }
    public void openFirst() {
        Intent intent = new Intent(this, map.class);
        startActivity(intent);
    }

}


