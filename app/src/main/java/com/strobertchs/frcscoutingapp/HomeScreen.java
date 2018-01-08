package com.strobertchs.frcscoutingapp;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class HomeScreen extends Fragment {

    public static Fragment newInstance(Context context) {
        HomeScreen f = new HomeScreen();

        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstancestate){
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_home_screen, null);
        return root;
    }

}
