package com.strobertchs.finalproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.Arrays;

public class clubsteams extends AppCompatActivity {

//    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clubsteams);

//        ListView lv_clubsteams = (ListView)findViewById(R.id.listViewClubsTeams);
//
//        ArrayList<String> arrayClubsTeams = new ArrayList<>();
//        arrayClubsTeams.addAll(Arrays.asList(getResources().getStringArray(R.array.array_clubsteams)));
//
//        adapter = new ArrayAdapter<>(
//                clubsteams.this,
//                android.R.layout.simple_list_item_1,
//                arrayClubsTeams);
//        lv_clubsteams.setAdapter(adapter);
//    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.menu_search,menu);
//        MenuItem item = menu.findItem(R.id.menuSearch);
//        SearchView searchView = (SearchView)item.getActionView();
//
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener(){
//            @Override
//            public boolean onQueryTextSubmit(String query){
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText){
//                adapter.getFilter().filter(newText);
//
//                return false;
//            }
//        });
//
//        return super.onCreateOptionsMenu(menu);
//    }
//}
