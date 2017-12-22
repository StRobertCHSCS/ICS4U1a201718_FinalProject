package com.strobertchs.edussentials;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

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
    }
}
