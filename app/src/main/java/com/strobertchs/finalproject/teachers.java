package com.strobertchs.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.Arrays;

public class teachers extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teachers);

        ListView lv_teachers = (ListView)findViewById(R.id.listViewTeachers);

        ArrayList<String> arrayTeachers = new ArrayList<>();
        arrayTeachers.addAll(Arrays.asList(getResources().getStringArray(R.array.array_teachers)));

        adapter = new ArrayAdapter<>(
                teachers.this,
                android.R.layout.simple_list_item_1,
                arrayTeachers);
        lv_teachers.setAdapter(adapter);
        lv_teachers.setOnItemClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_search,menu);
        MenuItem item = menu.findItem(R.id.menuSearch);
        SearchView searchView = (SearchView)item.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener(){
            @Override
            public boolean onQueryTextSubmit(String query){
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText){
                adapter.getFilter().filter(newText);

                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (position==0){
            Intent teachers_intent = new Intent(view.getContext(),teachers_alshaikh.class);
            startActivityForResult(teachers_intent,0);
        }
        if (position==1){
            Intent teachers_intent = new Intent(view.getContext(),teachers_albi.class);
            startActivityForResult(teachers_intent, 1);
        }
        if (position==2){
            Intent teachers_intent = new Intent(view.getContext(),teachers_ashworth.class);
            startActivityForResult(teachers_intent, 2);
        }
        if (position==3){
            Intent teachers_intent = new Intent(view.getContext(),teachers_battaglia.class);
            startActivityForResult(teachers_intent, 3);
        }
        if (position==4){
            Intent teachers_intent = new Intent(view.getContext(),teachers_bianchi.class);
            startActivityForResult(teachers_intent,4);
        }
        if (position==5){
            Intent teachers_intent = new Intent(view.getContext(),teachers_boccia.class);
            startActivityForResult(teachers_intent, 5);
        }
        if (position==6){
            Intent teachers_intent = new Intent(view.getContext(),teachers_bottiglione.class);
            startActivityForResult(teachers_intent, 6);
        }
        if (position==7){
            Intent teachers_intent = new Intent(view.getContext(),teachers_brockest.class);
            startActivityForResult(teachers_intent,7);
        }
        if (position==8){
            Intent teachers_intent = new Intent(view.getContext(),teachers_buchignani.class);
            startActivityForResult(teachers_intent, 8);
        }
        if (position==9){
            Intent teachers_intent = new Intent(view.getContext(), teachers_buckley.class);
            startActivityForResult(teachers_intent, 9);
        }
        if (position==10){
            Intent teachers_intent = new Intent(view.getContext(), teachers_bumbaca.class);
            startActivityForResult(teachers_intent,10);
        }
        if (position==11){
            Intent teachers_intent = new Intent(view.getContext(), teachers_cappelli.class);
            startActivityForResult(teachers_intent, 11);
        }
        if (position==12){
            Intent teachers_intent = new Intent(view.getContext(), teachers_capuccinello.class);
            startActivityForResult(teachers_intent, 12);
        }
        if (position==13){
            Intent teachers_intent = new Intent(view.getContext(), teachers_cara.class);
            startActivityForResult(teachers_intent, 13);
        }
        if (position==14){
            Intent teachers_intent = new Intent(view.getContext(), teachers_carone.class);
            startActivityForResult(teachers_intent, 14);
        }
        if (position==15){
            Intent teachers_intent = new Intent(view.getContext(), teachers_catenaro.class);
            startActivityForResult(teachers_intent, 15);
        }
        if (position==16){
            Intent teachers_intent = new Intent(view.getContext(), teachers_chan.class);
            startActivityForResult(teachers_intent, 16);
        }
    }
}
