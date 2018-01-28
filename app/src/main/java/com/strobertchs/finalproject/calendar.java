package com.strobertchs.finalproject;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.TextView;

public class calendar extends AppCompatActivity {

    CalendarView SchoolCalendarView;
    TextView markDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        SchoolCalendarView = (CalendarView) findViewById(R.id.CalendarView);
        markDate = (TextView) findViewById(R.id.markDate);

        SchoolCalendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener(){
            @Override
            public void onSelectedDayChange(@NonNull CalendarView SchoolCalendarView, int year, int month, int dayOfMonth) {
                String date = (month + 1) + "/" + dayOfMonth + "/" + year;
                markDate.setText(date);
            }
        });
    }
}
