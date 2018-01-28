package com.strobertchs.finalproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Window;

public class Axiom extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_axiom);
        Intent browserIntent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("http://www.theaxiom.ca"));
        startActivity(browserIntent);
    }
}
