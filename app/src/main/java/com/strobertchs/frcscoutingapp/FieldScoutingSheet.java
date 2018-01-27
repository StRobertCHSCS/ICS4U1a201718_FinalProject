package com.strobertchs.frcscoutingapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class FieldScoutingSheet extends Fragment{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstancestate) {
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.fragment_field_scouting_sheet, container, false);
        Button button1 = view.findViewById(R.id.buttonNext1);
        button1.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View view) {
                Fragment fragment = new Fragment();
                Class fragmentClass = null;
                Log.d("ADebugTag", "Value:" + view.getId());
                if(view.getId() == 2131230778) {
                    fragmentClass = FieldScoutingSheet2.class;
                }
                try {
                    fragment = (Fragment) fragmentClass.newInstance();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                //Insert the fragment by replacing any existing fragment
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.fragmentContent, fragment).commit();
            }
        });
        return view;

    }
}
