package com.strobertchs.final_project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    TextView textObjectMoney;
    TextView textObjectSocial;
    TextView textObjectGrades;
    TextView textObjectSleep;
    TextView textObjectEvent;
    Button buttonObjectYes;
    Button buttonObjectNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        textObjectMoney = (TextView)findViewById(R.id.textMoney);
        textObjectSocial = (TextView)findViewById(R.id.textSocial);
        textObjectGrades = (TextView)findViewById(R.id.textGrades);
        textObjectSleep = (TextView)findViewById(R.id.textSleep);
        textObjectEvent = (TextView)findViewById(R.id.textEvent);
        buttonObjectYes = (Button)findViewById(R.id.buttonYes);
        buttonObjectNo = (Button)findViewById(R.id.buttonNo);

        buttonObjectYes.setOnClickListener(this);
        buttonObjectNo.setOnClickListener(this);

    }//onCreate ends here

    @Override
    public void onClick(View view) {

    }
}
