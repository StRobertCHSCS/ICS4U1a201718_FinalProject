package com.strobertchs.final_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameOverActivity extends AppCompatActivity implements View.OnClickListener{

    Button buttonObjectBack;
    Button buttonObjectPlay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_instructions);

            buttonObjectBack = (Button)findViewById(R.id.buttonBack);
            buttonObjectPlay = (Button)findViewById(R.id.buttonPlay);
            buttonObjectBack.setOnClickListener(this);
            buttonObjectPlay.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        Intent i;
        switch (view.getId()) {
            case R.id.buttonBack:
                i = new Intent(this, MainActivity.class);
                startActivity(i);
                break;

            case R.id.buttonPlay:
                i = new Intent(this, GameActivity.class);
                startActivity(i);
                break;
        }
    }
}
