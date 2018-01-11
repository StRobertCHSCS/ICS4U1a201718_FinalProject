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
    TextView textObjectCurrentGrade;
    Button buttonObjectYes;
    Button buttonObjectNo;

    Student student = new Student(1);
    Event event;
    Randomizer random = new Randomizer();
    int currentGradeLevel = 9;

    Event allNighter = new Event("all Nighter playing videogames", 0, 30, -10, -30, 0, -15, 10, 20);
    Event doYourHomework = new Event("homework assignment", 0, -20, 25, -5, 0, 20, -25, 5);
    Event extraCurricular = new Event("extra curricular", 0, 15, 5, -5, 0, -15, 5, 5);
    Event partTimeJob = new Event("part time job", 30, 10, -15, -10, 0, -10, 5, 5);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        textObjectMoney = (TextView) findViewById(R.id.textMoney);
        textObjectSocial = (TextView) findViewById(R.id.textSocial);
        textObjectGrades = (TextView) findViewById(R.id.textGrades);
        textObjectSleep = (TextView) findViewById(R.id.textSleep);
        textObjectEvent = (TextView) findViewById(R.id.textEvent);
        textObjectCurrentGrade = (TextView) findViewById(R.id.textCurrentGrade);
        buttonObjectYes = (Button) findViewById(R.id.buttonYes);
        buttonObjectNo = (Button) findViewById(R.id.buttonNo);

        buttonObjectYes.setOnClickListener(this);
        buttonObjectNo.setOnClickListener(this);

        makeTurn();
        updateStatusBars();
        updateEvent();
    }//onCreate ends here

    void calculateCurrentGrade() {
        if(student.getCurrentEventNum() >= 2 && student.getCurrentEventNum() <= 3) {
            currentGradeLevel = 10;
        } else if(student.getCurrentEventNum() >= 4 && student.getCurrentEventNum() <= 5) {
            currentGradeLevel = 11;
        } else if(student.getCurrentEventNum() >= 6 && student.getCurrentEventNum() <= 7) {
            currentGradeLevel = 12;
        }
    }


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
                student.increaseCurrentEventNum();
                calculateCurrentGrade();
                break;

            case R.id.buttonNo:
                student.setMoney(student.getMoney() + event.getMoneyReducer());
                student.setSocial(student.getSocial() + event.getSocialReducer());
                student.setGrades(student.getGrades() + event.getGradesReducer());
                student.setSleep(student.getSleep() + event.getSleepReducer());
                student.increaseCurrentEventNum();
                calculateCurrentGrade();
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
        textObjectCurrentGrade.setText("Current Grade Level: " + currentGradeLevel);
    }

    void updateEvent() {
        textObjectEvent.setText("Event: " + "Do you want to perform a/an " + event.getEventName());
    }


}
