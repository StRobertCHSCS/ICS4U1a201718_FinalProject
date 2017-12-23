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

    //Initializing Student
    Student gabe = new Student("Gabe-kun", 1, true);

    //Linking Student to the Event
    Turn randomTurn = new Turn(gabe);

    //testing
    // randomTurn.makeTurn();



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

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonYes:
//                //initialize a new int with the value contained in buttonObjectChoice1
//                //Remember we put it there ourselves previously
//                answerGiven = Integer.parseInt("" + buttonObjectChoice1.getText());
//                break;
//
//            case R.id.buttonChoice2:
//                answerGiven = Integer.parseInt("" + buttonObjectChoice2.getText());
//                break;
//
//            case R.id.buttonChoice3:
//                answerGiven = Integer.parseInt("" + buttonObjectChoice3.getText());
//                break;
//        }
//        updateScoreAndLevel(answerGiven);
//        setQuestion();
    }

    void setText() {
        textObjectMoney.setText(gabe.getMoney());
        textObjectSocial.setText(gabe.getSocial());
        textObjectGrades.setText(gabe.getGrades());
        textObjectSleep.setText(gabe.getSleep());
    }
}
