package com.strobertchs.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

public class clubsteams extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ArrayAdapter<String> adapter1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clubsteams);

        ListView lv_clubsteams = (ListView) findViewById(R.id.listViewClubsTeams);

        ArrayList<String> arrayClubsTeams = new ArrayList<>();
        arrayClubsTeams.addAll(Arrays.asList(getResources().getStringArray(R.array.array_clubsteams)));

        adapter1 = new ArrayAdapter<>(
                clubsteams.this,
                android.R.layout.simple_list_item_1,
                arrayClubsTeams);
        lv_clubsteams.setAdapter(adapter1);
        lv_clubsteams.setOnItemClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater1 = getMenuInflater();
        inflater1.inflate(R.menu.menu_search, menu);
        MenuItem item = menu.findItem(R.id.menuSearch);
        SearchView searchView = (SearchView) item.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter1.getFilter().filter(newText);

                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (position == 0) {
            Intent clubsteams_intent = new Intent(view.getContext(), clubsteams_artcouncil.class);
            startActivityForResult(clubsteams_intent, 0);
        }
        if (position == 1) {
            Intent clubsteams_intent = new Intent(view.getContext(), clubsteams_athleticcouncil.class);
            startActivityForResult(clubsteams_intent, 1);
        }
        if (position == 2) {
            Intent clubsteams_intent = new Intent(view.getContext(), clubsteams_band.class);
            startActivityForResult(clubsteams_intent, 2);
        }
        if (position == 3) {
            Intent clubsteams_intent = new Intent(view.getContext(), clubsteams_chessclub.class);
            startActivityForResult(clubsteams_intent, 3);
        }
        if (position == 4) {
            Intent clubsteams_intent = new Intent(view.getContext(), clubsteams_choir.class);
            startActivityForResult(clubsteams_intent, 4);
        }
        if (position == 5) {
            Intent clubsteams_intent = new Intent(view.getContext(), clubsteams_christianfellowship.class);
            startActivityForResult(clubsteams_intent, 5);
        }
        if (position == 6) {
            Intent clubsteams_intent = new Intent(view.getContext(), clubsteams_crosscountry.class);
            startActivityForResult(clubsteams_intent, 6);
        }
        if (position == 7) {
            Intent clubsteams_intent = new Intent(view.getContext(), clubsteams_danceclub.class);
            startActivityForResult(clubsteams_intent, 7);
        }
        if (position == 8) {
            Intent clubsteams_intent = new Intent(view.getContext(), clubsteams_debatingclub.class);
            startActivityForResult(clubsteams_intent, 8);
        }
        if (position == 9) {
            Intent clubsteams_intent = new Intent(view.getContext(), clubsteams_deca.class);
            startActivityForResult(clubsteams_intent, 9);
        }
        if (position == 10) {
            Intent clubsteams_intent = new Intent(view.getContext(), clubsteams_designclub.class);
            startActivityForResult(clubsteams_intent, 10);
        }
        if (position == 11) {
            Intent clubsteams_intent = new Intent(view.getContext(), clubsteams_eslwriting.class);
            startActivityForResult(clubsteams_intent, 11);
        }
        if (position == 12) {
            Intent clubsteams_intent = new Intent(view.getContext(), clubsteams_esp.class);
            startActivityForResult(clubsteams_intent, 12);
        }
        if (position == 13) {
            Intent clubsteams_intent = new Intent(view.getContext(), clubsteams_environmentalclub.class);
            startActivityForResult(clubsteams_intent, 13);
        }
        if (position == 14) {
            Intent clubsteams_intent = new Intent(view.getContext(), clubsteams_frenchcouncil.class);
            startActivityForResult(clubsteams_intent, 14);
        }
        if (position == 15) {
            Intent clubsteams_intent = new Intent(view.getContext(), clubsteams_frenchdrama.class);
            startActivityForResult(clubsteams_intent, 15);
        }
        if (position == 16) {
            Intent clubsteams_intent = new Intent(view.getContext(), clubsteams_french_hwclub.class);
            startActivityForResult(clubsteams_intent, 16);
        }
        if (position == 17) {
            Intent clubsteams_intent = new Intent(view.getContext(), clubsteams_frenchnewspaper.class);
            startActivityForResult(clubsteams_intent, 17);
        }
        if (position == 18) {
            Intent clubsteams_intent = new Intent(view.getContext(), clubsteams_healthsciences.class);
            startActivityForResult(clubsteams_intent, 18);
        }
        if (position == 19) {
            Intent clubsteams_intent = new Intent(view.getContext(), clubsteams_ibclub.class);
            startActivityForResult(clubsteams_intent, 19);
        }
        if (position == 20) {
            Intent clubsteams_intent = new Intent(view.getContext(), clubsteams_interfaithclub.class);
            startActivityForResult(clubsteams_intent, 20);
        }
        if (position == 21) {
            Intent clubsteams_intent = new Intent(view.getContext(), clubsteams_jazzband.class);
            startActivityForResult(clubsteams_intent, 21);
        }
        if (position == 22) {
            Intent clubsteams_intent = new Intent(view.getContext(), clubsteams_mach1aviation.class);
            startActivityForResult(clubsteams_intent, 22);
        }
        if (position == 23) {
            Intent clubsteams_intent = new Intent(view.getContext(), clubsteams_mathclub.class);
            startActivityForResult(clubsteams_intent, 23);
        }
        if (position == 24) {
            Intent clubsteams_intent = new Intent(view.getContext(), clubsteams_muralclub.class);
            startActivityForResult(clubsteams_intent, 24);
        }
        if (position == 25) {
            Intent clubsteams_intent = new Intent(view.getContext(), clubsteams_newspaper.class);
            startActivityForResult(clubsteams_intent, 25);
        }
        if (position == 26) {
            Intent clubsteams_intent = new Intent(view.getContext(), clubsteams_nightflyers.class);
            startActivityForResult(clubsteams_intent, 26);
        }
        if (position == 27) {
            Intent clubsteams_intent = new Intent(view.getContext(), clubsteams_orchestra.class);
            startActivityForResult(clubsteams_intent, 27);
        }
        if (position == 28) {
            Intent clubsteams_intent = new Intent(view.getContext(), clubsteams_outreachclub.class);
            startActivityForResult(clubsteams_intent, 28);
        }
        if (position == 29) {
            Intent clubsteams_intent = new Intent(view.getContext(), clubsteams_photographyclub.class);
            startActivityForResult(clubsteams_intent, 29);
        }
        if (position == 30) {
            Intent clubsteams_intent = new Intent(view.getContext(), clubsteams_physicsclub.class);
            startActivityForResult(clubsteams_intent, 30);
        }
        if (position == 31) {
            Intent clubsteams_intent = new Intent(view.getContext(), clubsteams_pride.class);
            startActivityForResult(clubsteams_intent, 31);
        }
        if (position == 32) {
            Intent clubsteams_intent = new Intent(view.getContext(), clubsteams_reachforthetop.class);
            startActivityForResult(clubsteams_intent, 32);
        }
        if (position == 33) {
            Intent clubsteams_intent = new Intent(view.getContext(), clubsteams_robotics.class);
            startActivityForResult(clubsteams_intent, 33);
        }
        if (position == 34) {
            Intent clubsteams_intent = new Intent(view.getContext(), clubsteams_scienceclub.class);
            startActivityForResult(clubsteams_intent, 34);
        }
        if (position == 35) {
            Intent clubsteams_intent = new Intent(view.getContext(), clubsteams_socialjustice.class);
            startActivityForResult(clubsteams_intent, 35);
        }
        if (position == 36) {
            Intent clubsteams_intent = new Intent(view.getContext(), clubsteams_stuco.class);
            startActivityForResult(clubsteams_intent, 36);
        }
        if (position == 37) {
            Intent clubsteams_intent = new Intent(view.getContext(), clubsteams_tabletennis.class);
            startActivityForResult(clubsteams_intent, 37);
        }
        if (position == 38) {
            Intent clubsteams_intent = new Intent(view.getContext(), clubsteams_unitedbooknerds.class);
            startActivityForResult(clubsteams_intent, 38);
        }
        if (position == 39) {
            Intent clubsteams_intent = new Intent(view.getContext(), clubsteams_unitednations.class);
            startActivityForResult(clubsteams_intent, 39);
        }
        if (position == 40) {
            Intent clubsteams_intent = new Intent(view.getContext(), clubsteams_yearbookclub.class);
            startActivityForResult(clubsteams_intent, 40);
        }
    }
}
