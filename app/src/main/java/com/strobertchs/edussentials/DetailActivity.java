package com.strobertchs.edussentials;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        String savedExtra = getIntent().getStringExtra("information");
        TextView myText = (TextView) findViewById(R.id.textID);
        myText.setText(savedExtra);
    }
}
