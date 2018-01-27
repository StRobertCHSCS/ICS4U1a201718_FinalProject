package com.strobertchs.frcscoutingapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FieldScoutingSheet extends Fragment{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstancestate) {
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.fragment_field_scouting_sheet, container, false);

        //Initializes edit texts
        final EditText teamName = (EditText) view.findViewById(R.id.exampleTeam);
        final EditText allianceColour = (EditText) view.findViewById(R.id.insertAllianceColour);
        final EditText matchNumber = (EditText) view.findViewById(R.id.insertMatchNum);

        //Initializes finalization button
        Button button1 = view.findViewById(R.id.buttonNext1);
        button1.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View view) {
                Fragment fragment = new Fragment();
                Class fragmentClass = null;
                Log.d("ADebugTag", "Value:" + view.getId());
                while (true) {
                    if (view.getId() == 2131230778) {
                        String nameTeam = teamName.getText().toString();
                        String colourAlliance = allianceColour.getText().toString();
                        String numberMatch = matchNumber.getText().toString();
                        if (nameTeam.equals("") || nameTeam.equals("Example Team #4001")) {
                            Toast.makeText(getContext(), "You did not enter a team name", 10).show();
                            break;
                        }
                        else if (colourAlliance.equals("") || colourAlliance.equals("Insert Alliance Colour")) {
                            Toast.makeText(getContext(), "You did not enter an alliance colour", 10).show();
                            break;
                        }
                        else if (numberMatch.equals("") || colourAlliance.equals("Insert Match #")) {
                            Toast.makeText(getContext(), "You did not enter a match number", 10).show();
                            break;
                        }
                        else {
                            fragmentClass = FieldScoutingSheet2.class;
                        }
                    }
                    try {
                        fragment = (Fragment) fragmentClass.newInstance();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    //Insert the fragment by replacing any existing fragment
                    FragmentManager fragmentManager = getFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.fragmentContent, fragment).commit();
                    break;
                }
            }
        });
        return view;
    }
}
