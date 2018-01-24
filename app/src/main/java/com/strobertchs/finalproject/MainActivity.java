package com.strobertchs.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button buttonObjectChoice1;
    Button buttonObjectChoice2;
    Button buttonObjectChoice3;
    Button buttonObjectChoice4;
    Button buttonObjectChoice5;
    Button buttonObjectChoice6;
    Button buttonObjectChoice7;
    Button buttonObjectChoice8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        buttonObjectChoice1 =
                (Button) findViewById(R.id.TeacherButton);

        buttonObjectChoice2 =
                (Button) findViewById(R.id.EventsButton);

        buttonObjectChoice3 =
                (Button) findViewById(R.id.MapButton);

        buttonObjectChoice4 =
                (Button) findViewById(R.id.LinksButton);

        buttonObjectChoice5 =
                (Button) findViewById(R.id.ClubsTeamsButton);

        buttonObjectChoice6 =
                (Button) findViewById(R.id.AxiomButton);

        buttonObjectChoice7 =
                (Button) findViewById(R.id.ExamScheduleButton);

        buttonObjectChoice8 =
                (Button) findViewById(R.id.ClassSitesButton);

        buttonObjectChoice1.setOnClickListener(this);
        buttonObjectChoice2.setOnClickListener(this);
        buttonObjectChoice3.setOnClickListener(this);
        buttonObjectChoice4.setOnClickListener(this);
        buttonObjectChoice5.setOnClickListener(this);
        buttonObjectChoice6.setOnClickListener(this);
        buttonObjectChoice7.setOnClickListener(this);
        buttonObjectChoice8.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.TeacherButton:
                Intent i;
                i = new Intent(this, teachers.class);
                    startActivity(i);
                break;

            case R.id.EventsButton:
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

            case R.id.AxiomButton:
                i = new Intent(this, Axiom.class);
                    startActivity(i);
                break;

            case R.id.ExamScheduleButton:
                i = new Intent(this, examschedule.class);
                    startActivity(i);
                break;
        }
    }
}
