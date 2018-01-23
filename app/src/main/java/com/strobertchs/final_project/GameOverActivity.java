package com.strobertchs.final_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameOverActivity extends AppCompatActivity implements View.OnClickListener{

    TextView textObjectResult;
    TextView textObjectMessage;
    Button buttonObjectRestart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);

        textObjectResult = (TextView) findViewById(R.id.textResult);
        textObjectMessage = (TextView) findViewById(R.id.textMessage);
        buttonObjectRestart = (Button)findViewById(R.id.buttonRestart);
        buttonObjectRestart.setOnClickListener(this);


        if(GlobalAttributes.student.getWinOrLose() == "win"){
            textObjectResult.setText("YOU WIN");
            textObjectMessage.setText("Congratulations, you made it past all four years of highschool!");
        }else if(GlobalAttributes.student.getWinOrLose() == "lose"){
            textObjectResult.setText("YOU LOSE");
            textObjectMessage.setText("You failed highschool, better luck next time!");
        }
    }

    @Override
    public void onClick(View view) {
        GlobalAttributes.student.setMoney(50);
        GlobalAttributes.student.setSocial(50);
        GlobalAttributes.student.setGrades(50);
        GlobalAttributes.student.setSleep(50);
        GlobalAttributes.student.setCurrentEventNum(0);

        Intent i;
        i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}
