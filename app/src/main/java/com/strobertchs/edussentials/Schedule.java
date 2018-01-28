package com.strobertchs.edussentials;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

import java.util.Arrays;


public class Schedule extends AppCompatActivity {
    String[] periodArray = {"Period 1","Period 2","Period 3","Period 4","Lunch"};
    String[] timeArray = {"8:30-9:51","9:53-11:09","(A- 11:53-1:13, B- 11:11-11:53+12:30-1:13, C-11:09-12:30 ","1:13-2:30","A- 11:09-11:53, B- 11:53-12:30, C-12:30-1:13"};
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);

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
