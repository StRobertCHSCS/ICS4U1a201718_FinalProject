package com.strobertchs.edussentials;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GradeTracker extends AppCompatActivity {

    private Button scheduleOpen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grade_tracker);

        scheduleOpen = (Button) findViewById(R.id.Schedule);
        scheduleOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSchedule();
            }
        });
    }

    public void openSchedule() {
        Intent intent = new Intent(this, Schedule.class);
        startActivity(intent);
    }
}
