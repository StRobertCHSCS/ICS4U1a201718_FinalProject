package com.strobertchs.final_project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    TextView textObjectMoney;
    TextView textObjectSocial;
    TextView textObjectGrades;
    TextView textObjectSleep;
    TextView textObjectEvent;
    Button buttonObjectYes;
    Button buttonObjectNo;

    //TESTING
    Event event;
    Randomizer random = new Randomizer();

    Event allNighter = new Event("all Nighter", -5, 30, -5, -30);
    Event doYourHomework = new Event("homework assignment", -5, -20, 25, -5);
    Event extraCurricular = new Event("extra curricular", -5, 15, 5, -5);
    Event partTimeJob = new Event("part time job", 30, 10, -15, -10);

    //Initializing Student
    Student gabe = new Student("Gabe-kun", 1, true);

    //Linking Student to the Event
    //Turn turn = new Turn(gabe);

    //testing
    //turn.makeTurn();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        textObjectMoney = (TextView) findViewById(R.id.textMoney);
        textObjectSocial = (TextView) findViewById(R.id.textSocial);
        textObjectGrades = (TextView) findViewById(R.id.textGrades);
        textObjectSleep = (TextView) findViewById(R.id.textSleep);
        textObjectEvent = (TextView) findViewById(R.id.textEvent);
        buttonObjectYes = (Button) findViewById(R.id.buttonYes);
        buttonObjectNo = (Button) findViewById(R.id.buttonNo);

        buttonObjectYes.setOnClickListener(this);
        buttonObjectNo.setOnClickListener(this);

    }//onCreate ends here

    //TESTING
    void makeTurn(){
        event = random.pickEvent(allNighter, doYourHomework, extraCurricular, partTimeJob);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonYes:

                break;

            case R.id.buttonNo:

                break;
        }
        updateStatusBars();
    }

    void updateStatusBars() {
        textObjectMoney.setText("Money: " + gabe.getMoney());
        textObjectSocial.setText("Social: " + gabe.getSocial());
        textObjectGrades.setText("Grades: " + gabe.getGrades());
        textObjectSleep.setText("Sleep: " + gabe.getSleep());
    }

    void updateEvent() {
        textObjectEvent.setText("Event: " + "Do you want to perform a/an " + event.getEventName());
    }


}
