package com.strobertchs.edussentials;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

import java.util.Arrays;
import java.util.Scanner;

public class Schedule extends AppCompatActivity {
    String[] periodArray = {"Period 1","Period 2","Period 3","Period 4","Lunch"};
    String[] timeArray = {"Time Slot 1","Time Slot 2","Time Slot 3","Time Slot 4","LunchTime"};
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        CustomListAdapter array1 = new CustomListAdapter(this, periodArray,timeArray);
        listView = (ListView) findViewById(R.id.ListViewID);
        listView.setAdapter(array1);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                Intent intent = new Intent(Schedule.this, DetailActivity.class);
                String message = periodArray[position];
                intent.putExtra("information", message);
                startActivity(intent);

            }
       });
    }

}
