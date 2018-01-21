package com.strobertchs.final_project;

import android.content.Intent;
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

    TextView textObjectMoneyBar;
    TextView textObjectSocialBar;
    TextView textObjectGradesBar;
    TextView textObjectSleepBar;

    TextView textObjectEvent;
    TextView textObjectCurrentGrade;
    Button buttonObjectYes;
    Button buttonObjectNo;

    Student student = new Student(1);
    Event event;
    Randomizer random = new Randomizer();
    int currentGradeLevel = 9;

    Event allNighter = new Event("all Nighter playing videogames", 0, 30, -20, -20, 0, -30, 20, 20);
    Event doYourHomework = new Event("homework assignment", 0, -20, 20, -10, 0, 20, -20, 10);
    Event extraCurricular = new Event("extra curricular", -10, 20, 10, -10, 10, -20, -10, 10);
    Event partTimeJob = new Event("part time job", 30, 20, -20, -20, -30, -20, 20, 20);
    Event attendFamilyDinner = new Event("family dinner", 10, 20, -10, -10, -10, -20, 10, 10);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        textObjectMoney = (TextView) findViewById(R.id.textMoney);
        textObjectSocial = (TextView) findViewById(R.id.textSocial);
        textObjectGrades = (TextView) findViewById(R.id.textGrades);
        textObjectSleep = (TextView) findViewById(R.id.textSleep);

        textObjectMoneyBar = (TextView) findViewById(R.id.textMoneyBar);
        textObjectSocialBar = (TextView) findViewById(R.id.textSocialBar);
        textObjectGradesBar = (TextView) findViewById(R.id.textGradesBar);
        textObjectSleepBar = (TextView) findViewById(R.id.textSleepBar);

        textObjectEvent = (TextView) findViewById(R.id.textEvent);
        textObjectCurrentGrade = (TextView) findViewById(R.id.textCurrentGrade);
        buttonObjectYes = (Button) findViewById(R.id.buttonYes);
        buttonObjectNo = (Button) findViewById(R.id.buttonNo);

        buttonObjectYes.setOnClickListener(this);
        buttonObjectNo.setOnClickListener(this);

        makeTurn();
        updateStudentStatus();
        updateStudentStatusBars();
        updateEvent();
    }//onCreate ends here

    Intent i;
    void calculateCurrentGrade() {
        if(student.getCurrentEventNum() >= 4 && student.getCurrentEventNum() <= 7) {
            currentGradeLevel = 10;
        } else if(student.getCurrentEventNum() >= 8 && student.getCurrentEventNum() <= 11) {
            currentGradeLevel = 11;
        } else if(student.getCurrentEventNum() >= 12 && student.getCurrentEventNum() <= 15) {
            currentGradeLevel = 12;
        } else if(student.getCurrentEventNum() >= 16){
            i = new Intent(this, GameOverActivity.class);
            startActivity(i);
        }
    }


    void makeTurn(){
        event = random.pickEvent(allNighter, doYourHomework, extraCurricular, partTimeJob);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonYes:
                if(student.getMoney() + event.getMoneyAdder() <= 100){
                    student.setMoney(student.getMoney() + event.getMoneyAdder());
                }else {
                    student.setMoney(100);
                }
                if(student.getSocial() + event.getSocialAdder() <= 100){
                    student.setSocial(student.getSocial() + event.getSocialAdder());
                }else {
                    student.setSocial(100);
                }
                if(student.getGrades() + event.getGradesAdder() <= 100){
                    student.setGrades(student.getGrades() + event.getGradesAdder());
                }else {
                    student.setGrades(100);
                }
                if(student.getSleep() + event.getSleepAdder() <= 100){
                    student.setSleep(student.getSleep() + event.getSleepAdder());
                }else {
                    student.setSleep(100);
                }
                checkIfLose();
                student.increaseCurrentEventNum();
                updateStudentStatusBars();
                calculateCurrentGrade();
                break;

            case R.id.buttonNo:
                if(student.getMoney() + event.getMoneyReducer() <= 100){
                    student.setMoney(student.getMoney() + event.getMoneyReducer());
                }else {
                    student.setMoney(100);
                }
                if(student.getSocial() + event.getSocialReducer() <= 100){
                    student.setSocial(student.getSocial() + event.getSocialReducer());
                }else {
                    student.setSocial(100);
                }
                if(student.getGrades() + event.getGradesReducer() <= 100){
                    student.setGrades(student.getGrades() + event.getGradesReducer());
                }else {
                    student.setGrades(100);
                }
                if(student.getSleep() + event.getSleepReducer() <= 100){
                    student.setSleep(student.getSleep() + event.getSleepReducer());
                }else {
                    student.setSleep(100);
                }
                checkIfLose();
                student.increaseCurrentEventNum();
                updateStudentStatusBars();
                calculateCurrentGrade();
                break;
        }
        makeTurn();
        updateStudentStatus();
        updateEvent();
    }

    void checkIfLose(){
        if(student.getMoney() <= 0){
            i = new Intent(this, GameOverActivity.class);
            startActivity(i);
        }else if(student.getSocial() <= 0){
            i = new Intent(this, GameOverActivity.class);
            startActivity(i);
        }else if(student.getGrades() <= 0){
            i = new Intent(this, GameOverActivity.class);
            startActivity(i);
        }else if(student.getSleep() <= 0){
            i = new Intent(this, GameOverActivity.class);
            startActivity(i);
        }
    }
    void updateStudentStatus() {
        textObjectMoney.setText("Money: " + student.getMoney());
        textObjectSocial.setText("Social: " + student.getSocial());
        textObjectGrades.setText("Grades: " + student.getGrades());
        textObjectSleep.setText("Sleep: " + student.getSleep());
        textObjectCurrentGrade.setText("Current Grade Level: " + currentGradeLevel);
    }

    void updateEvent() {
        textObjectEvent.setText("Event: " + "Do you want to perform a/an " + event.getEventName());
    }

    String moneyBarLines;
    String socialBarLines;
    String gradesBarLines;
    String sleepBarLines;
    void updateStudentStatusBars(){
        if(student.getMoney() == 0 ){
            moneyBarLines = "          ";
        }else if(student.getMoney() == 10){
            moneyBarLines = "|         ";
        }else if(student.getMoney() == 20){
            moneyBarLines = "||        ";
        }else if(student.getMoney() == 30){
            moneyBarLines = "|||       ";
        }else if(student.getMoney() == 40){
            moneyBarLines = "||||      ";
        }else if(student.getMoney() == 50){
            moneyBarLines = "|||||     ";
        }else if(student.getMoney() == 60){
            moneyBarLines = "||||||    ";
        }else if(student.getMoney() == 70){
            moneyBarLines = "|||||||   ";
        }else if(student.getMoney() == 80){
            moneyBarLines = "||||||||  ";
        }else if(student.getMoney() == 90){
            moneyBarLines = "||||||||| ";
        }else if(student.getMoney() == 100){
            moneyBarLines = "||||||||||";
        }

        if(student.getSocial() == 0 ){
            socialBarLines = "          ";
        }else if(student.getSocial() == 10){
            socialBarLines = "|         ";
        }else if(student.getSocial() == 20){
            socialBarLines = "||        ";
        }else if(student.getSocial() == 30){
            socialBarLines = "|||       ";
        }else if(student.getSocial() == 40){
            socialBarLines = "||||      ";
        }else if(student.getSocial() == 50){
            socialBarLines = "|||||     ";
        }else if(student.getSocial() == 60){
            socialBarLines = "||||||    ";
        }else if(student.getSocial() == 70){
            socialBarLines = "|||||||   ";
        }else if(student.getSocial() == 80){
            socialBarLines = "||||||||  ";
        }else if(student.getSocial() == 90){
            socialBarLines = "||||||||| ";
        }else if(student.getSocial() == 100){
            socialBarLines = "||||||||||";
        }

        if(student.getGrades() == 0 ){
            gradesBarLines = "          ";
        }else if(student.getGrades() == 10){
            gradesBarLines = "|         ";
        }else if(student.getGrades() == 20){
            gradesBarLines = "||        ";
        }else if(student.getGrades() == 30){
            gradesBarLines = "|||       ";
        }else if(student.getGrades() == 40){
            gradesBarLines = "||||      ";
        }else if(student.getGrades() == 50){
            gradesBarLines = "|||||     ";
        }else if(student.getGrades() == 60){
            gradesBarLines = "||||||    ";
        }else if(student.getGrades() == 70){
            gradesBarLines = "|||||||   ";
        }else if(student.getGrades() == 80){
            gradesBarLines = "||||||||  ";
        }else if(student.getGrades() == 90){
            gradesBarLines = "||||||||| ";
        }else if(student.getGrades() == 100){
            gradesBarLines = "||||||||||";
        }

        if(student.getSleep() == 0 ){
            sleepBarLines = "          ";
        }else if(student.getSleep() == 10){
            sleepBarLines = "|         ";
        }else if(student.getSleep() == 20){
            sleepBarLines = "||        ";
        }else if(student.getSleep() == 30){
            sleepBarLines = "|||       ";
        }else if(student.getSleep() == 40){
            sleepBarLines = "||||      ";
        }else if(student.getSleep() == 50){
            sleepBarLines = "|||||     ";
        }else if(student.getSleep() == 60){
            sleepBarLines = "||||||    ";
        }else if(student.getSleep() == 70){
            sleepBarLines = "|||||||   ";
        }else if(student.getSleep() == 80){
            sleepBarLines = "||||||||  ";
        }else if(student.getSleep() == 90){
            sleepBarLines = "||||||||| ";
        }else if(student.getSleep() == 100){
            sleepBarLines = "||||||||||";
        }

        textObjectMoneyBar.setText("[" + moneyBarLines + "]");
        textObjectSocialBar.setText("[" + socialBarLines + "]");
        textObjectGradesBar.setText("[" + gradesBarLines + "]");
        textObjectSleepBar.setText("[" + sleepBarLines + "]");
    }
}
