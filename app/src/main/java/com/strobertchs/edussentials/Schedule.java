package com.strobertchs.edussentials;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener

public class Schedule extends AppCompatActivity {
    String[] periodArray = {"Computer Science","Physics","Morality","Business Leadership"};

    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);

        CustomListAdapter array1 = new CustomListAdapter(this, periodArray);
        listView = (ListView) findViewById(R.id.ListViewID);
        listView.setAdapter(array1);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                Intent intent = new Intent(Schedule.this, DetailActivity.class);
                String message = periodArray[position];
                intent.putExtra("info", message);
                startActivity(intent);

            }
        });
    }
}
