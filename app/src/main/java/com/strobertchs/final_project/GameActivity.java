package com.strobertchs.final_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity implements View.OnClickListener{

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

    Student student = new Student();
    {
        GlobalAttributes.student = this.student;
    }
    Event event;
    Randomizer random = new Randomizer();
    int currentGradeLevel = 9;

    Event allNighter = new Event("stay up all night playing videogames", 0, 30, -20, -20, 0, -30, 20, 20);
    Event doYourHomework = new Event("do your homework", 0, -20, 20, -10, 0, 20, -20, 10);
    Event extraCurricular = new Event("do an extra curricular", -10, 20, 10, -10, 10, -20, -10, 10);
    Event partTimeJob = new Event("a part time job", 30, 20, -20, -20, -30, -20, 20, 20);
    Event party = new Event("go to a party", -10, 30, -20, -10, 10, -30, 20, 10);
    Event attendFamilyDinner = new Event("attend a family dinner", 10, 20, -10, -10, -10, -20, 10, 10);
    Event prepareForPresentation = new Event("stay up late to prepare for your presentation", 0, -10, 20, -10, 0, 10, -20, 10);
    Event skipClass = new Event("skip class and chill with your friends", 0, 20, -20, 0, 0, -20, 20, 0);
    Event doDrugs = new Event("do drugs and see the world in a new light", -30, 30, -30, -30, 30, -30, 30, 30);
    Event hangOut = new Event("hangout after school with your friends", -20, 20, -10, -10, 20, -20, 10, 10);
    Event vacation = new Event("go on a nice sunny vacation", -30, 20, -20, 20, 30, -20, 20, -20);
    Event sleepIn = new Event("sleep in",0,0,-30,20,0,0,30,-20);
    Event getTutor = new Event("get a tutor", -20, -10, 40, -10, 20, 10,-40,10);
    Event attendSchoolSick = new Event("attend school even though you are sick", 0, -10, 10, -10, 0, 10, -10, 10);
    Event procrastinate = new Event("procrastinate today", 0, 20, -20, 20, 0, -20, 20, -20);
    Event playVideoGames = new Event("play video games on your new PS4", -10, 20, -10, -10, 10, -20, 10, 10);
    Event cram = new Event("cram tonight", 0, 10, 20, -20, 0, -10, -20, 20);
    Event attendSchoolRetreat = new Event("attend a school retreat", -10, 20, -10, 0, 10, -20, 10, 0);
    Event contest = new Event("participate in a math contest", 0, 0, 20, -20, 0, 0, -20, 20);
    Event groupProjectAlone = new Event("do a group project by yourself", 0, -20, 20, -10,  0, 20, -20, -10);
    Event communityService = new Event ("volunteer in a community service project", 0, 30, 0, -10, 0, -30, 0, 10);

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
            student.setWinOrLose("win");
        }
    }
    void checkIfLose(){
        if(student.getMoney() <= 0){
            i = new Intent(this, GameOverActivity.class);
            startActivity(i);
            student.setWinOrLose("lose");
        }else if(student.getSocial() <= 0){
            i = new Intent(this, GameOverActivity.class);
            startActivity(i);
            student.setWinOrLose("lose");
        }else if(student.getGrades() <= 0){
            i = new Intent(this, GameOverActivity.class);
            startActivity(i);
            student.setWinOrLose("lose");
        }else if(student.getSleep() <= 0){
            i = new Intent(this, GameOverActivity.class);
            startActivity(i);
            student.setWinOrLose("lose");
        }
    }

    void makeTurn(){
        event = random.pickEvent(allNighter, doYourHomework, extraCurricular, partTimeJob, party, attendFamilyDinner, prepareForPresentation, skipClass, doDrugs, hangOut, vacation, sleepIn, getTutor, attendSchoolSick, procrastinate, playVideoGames, cram, attendSchoolRetreat, contest, groupProjectAlone, communityService);
    }

    void updateStudentStatus() {
        textObjectMoney.setText("Money: " + student.getMoney());
        textObjectSocial.setText("Social: " + student.getSocial());
        textObjectGrades.setText("Grades: " + student.getGrades());
        textObjectSleep.setText("Sleep: " + student.getSleep());
        textObjectCurrentGrade.setText("Current Grade Level: " + currentGradeLevel);
    }

    void updateEvent() {
        textObjectEvent.setText("Event: " + "Do you want to " + event.getEventMessage());
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
}
