package com.strobertchs.final_project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class GameOverActivity extends AppCompatActivity {

    TextView textObjectResult;
    TextView textObjectMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);

        textObjectResult = (TextView) findViewById(R.id.textResult);
        textObjectMessage = (TextView) findViewById(R.id.textMessage);

        if(GlobalAttributes.student.getWinOrLose() == "win"){
            textObjectResult.setText("YOU WIN");
            textObjectMessage.setText("Congratulations, you made it past all four years of highschool!");
        }else if(GlobalAttributes.student.getWinOrLose() == "lose"){
            textObjectResult.setText("YOU LOSE");
            textObjectMessage.setText("You failed highschool, better luck next time!");
        }
    }
}
