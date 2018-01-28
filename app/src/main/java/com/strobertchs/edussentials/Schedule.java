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
    String[] periodArray = {"Computer Science","Physics","Morality","Business Leadership","Lunch"};
    String[] timeArray = {"8:30-9:50","9:53-11:09","11:53-1:13","1:13-2:30","11:10-11:53"};

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Scanner scan = new Scanner(System.in);
        //System.out.println("Enter the array size: ");
        //int size = scan.nextInt();
        //String[] periodArray = {};
        //Arrays.fill(periodArray,-1);
        //super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_schedule);

        //Scanner scan1 = new Scanner(System.in);
        //System.out.println("Enter the array size: ");
        //int size1 = scan1.nextInt();
        //int[] timeArray = {};
        //Arrays.fill(timeArray,-1);
        //super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_schedule);

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
