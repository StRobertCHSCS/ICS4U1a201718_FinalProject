package com.strobertchs.finalproject;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;


public class tips extends AppCompatActivity {

    CalendarView calender;
    TextView myDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips);

        calender = findViewById(R.id.calendarView);
        myDate = findViewById(R.id.myDate);

        calender.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendar, int year, int month, int day) {
                Toast.makeText(getApplicationContext(), day + "/" + month + "/" + year, Toast.LENGTH_LONG).show();
            }
        });
    }
}