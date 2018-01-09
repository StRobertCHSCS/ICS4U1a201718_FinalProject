package com.strobertchs.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button buttonObjectChoice1;
    Button buttonObjectChoice2;
    Button buttonObjectChoice3;
    Button buttonObjectChoice4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonObjectChoice1 =
                (Button) findViewById(R.id.TeacherButton);

        buttonObjectChoice2 =
                (Button) findViewById(R.id.TipsButton);

        buttonObjectChoice3 =
                (Button) findViewById(R.id.MapButton);

        buttonObjectChoice4 =
                (Button) findViewById(R.id.LinksButton);

        buttonObjectChoice1.setOnClickListener(this);
        buttonObjectChoice2.setOnClickListener(this);
        buttonObjectChoice3.setOnClickListener(this);
        buttonObjectChoice4.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.TeacherButton:
                Intent i;
                i = new Intent(this, teachers.class);
                    startActivity(i);
                break;

            case R.id.TipsButton:
                i = new Intent(this, tips.class);
                    startActivity(i);
                break;

            case R.id.MapButton:
                i = new Intent(this, maps.class);
                    startActivity(i);
                break;

            case R.id.LinksButton:
                i = new Intent(this, links.class);
                    startActivity(i);
                break;
        }
    }
}
