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
    Student student = new Student("Gabe-kun", 1, true);

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

        makeTurn();
        updateStatusBars();
        updateEvent();
    }//onCreate ends here

    //TESTING
    void makeTurn(){
        event = random.pickEvent(allNighter, doYourHomework, extraCurricular, partTimeJob);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonYes:
                student.setMoney(student.getMoney() + event.getMoneyAdder());
                student.setSocial(student.getSocial() + event.getSocialAdder());
                student.setGrades(student.getGrades() + event.getGradesAdder());
                student.setSleep(student.getSleep() + event.getSleepAdder());
                break;

            case R.id.buttonNo:

                break;
        }
        makeTurn();
        updateStatusBars();
        updateEvent();
    }

    void updateStatusBars() {
        textObjectMoney.setText("Money: " + student.getMoney());
        textObjectSocial.setText("Social: " + student.getSocial());
        textObjectGrades.setText("Grades: " + student.getGrades());
        textObjectSleep.setText("Sleep: " + student.getSleep());
    }

    void updateEvent() {
        textObjectEvent.setText("Event: " + "Do you want to perform a/an " + event.getEventName());
    }


}
