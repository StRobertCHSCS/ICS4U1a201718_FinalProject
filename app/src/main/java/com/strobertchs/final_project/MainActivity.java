package com.strobertchs.final_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button buttonObjectPlay;
    Button buttonObjectInstructions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonObjectPlay = (Button)findViewById(R.id.buttonPlay);
        buttonObjectInstructions = (Button)findViewById(R.id.buttonInstructions);
        buttonObjectPlay.setOnClickListener(this);
        buttonObjectInstructions.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent i;
        switch (view.getId()) {
            case R.id.buttonPlay:
                i = new Intent(this, GameActivity.class);
                startActivity(i);
                break;

            case R.id.buttonInstructions:
                i = new Intent(this, InstructionsActivity.class);
                startActivity(i);
                break;
        }
    }
}
