package com.strobertchs.final_project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class GameOverActivity extends AppCompatActivity {

    TextView textObjectResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);

        textObjectResult = (TextView) findViewById(R.id.textResult);
        if(GlobalAttributes.student.getWinOrLose() == "win"){
            textObjectResult.setText("YOU WIN");
        }else if(GlobalAttributes.student.getWinOrLose() == "lose"){
            textObjectResult.setText("YOU LOSE");
        }

    }
}
