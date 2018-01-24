package com.strobertchs.finalproject;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;

import com.github.sundeepk.compactcalendarview.CompactCalendarView;
import com.github.sundeepk.compactcalendarview.domain.Event;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class tips extends AppCompatActivity {

    CompactCalendarView compactCalendar;
    private SimpleDateFormat dateFormatMonth = new SimpleDateFormat("MMMM- yyyy", Locale.getDefault());
    private static final String TAG = "tips";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips);

//        final CompactCalendarView compactCalendar = findViewById(R.id.compactcalendar_view);
//
//        Event event1 = new Event(Color.RED, 1516167840000L, "Testing");
//        compactCalendar.addEvent(event1);
//
//        Event event2 = new Event(Color.RED, 1516167840000L, "Testing #2");
//        compactCalendar.addEvent(event2);
//
//        List<Event> events = compactCalendar.getEvents(1433701251000L);
//
//        Log.d(TAG, "Events: " + events);
//
//        compactCalendar.setListener(new CompactCalendarView.CompactCalendarViewListener() {
//            @Override
//            public void onDayClick(Date dateClicked) {
//                List<Event> events = CompactCalendarView.getEvents(dateClicked);
//                Log.d(TAG, "Day was clicked: " + dateClicked + " with events: " + events);
//                }
//            @Override
//            public void onMonthScroll(Date firstDayOfNewMonth){
//                Log.d(TAG, "Month scrolled to: " + firstDayOfNewMonth);
//            }
//        });
//    }
    }
}
