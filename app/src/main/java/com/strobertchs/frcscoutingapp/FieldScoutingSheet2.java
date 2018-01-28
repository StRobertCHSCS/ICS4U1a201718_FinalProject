package com.strobertchs.frcscoutingapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class FieldScoutingSheet2 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstancestate) {
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.fragment_field_scouting_sheet2, container, false);

        //Initializes xml variables
        final TextView textView1 = (TextView) view.findViewById(R.id.textView1);
        final TextView textView2 = (TextView) view.findViewById(R.id.textView2);
        final TextView textView3 = (TextView) view.findViewById(R.id.textView3);

        Button button1 = (Button) view.findViewById(R.id.button1);
        Button button2 = (Button) view.findViewById(R.id.button2);
        Button button3 = (Button) view.findViewById(R.id.button3);
        Button button4 = (Button) view.findViewById(R.id.button4);
        Button button5 = (Button) view.findViewById(R.id.button5);
        Button button6 = (Button) view.findViewById(R.id.button6);
        Button button7 = (Button) view.findViewById(R.id.button7);
        Button button8 = (Button) view.findViewById(R.id.button8);
        Button button9 = (Button) view.findViewById(R.id.button9);
        Button button10 = (Button) view.findViewById(R.id.button10);
        Button button11 = (Button) view.findViewById(R.id.button11);
        Button button12 = (Button) view.findViewById(R.id.button12);
        Button button13 = (Button) view.findViewById(R.id.button13);
        Button button14 = (Button) view.findViewById(R.id.button14);
        Button button15 = (Button) view.findViewById(R.id.button15);

        final EditText timeTaken = (EditText) view.findViewById(R.id.timeTaken);

        button1.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View view) {
                Log.d("ADebugTag", "Value:" + view.getId());
                if (view.getId() == 2131230761) {
                    textView2.setText("1 Cube in Scale");
                }
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View view) {
                Log.d("ADebugTag", "Value:" + view.getId());
                if (view.getId() == 2131230768) {
                    textView2.setText("2 Cubes in Scale");
                }
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View view) {
                Log.d("ADebugTag", "Value:" + view.getId());
                if (view.getId() == 2131230769) {
                    textView2.setText("3 Cubes in Scale");
                }
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View view) {
                Log.d("ADebugTag", "Value:" + view.getId());
                if (view.getId() == 2131230770) {
                    textView2.setText("4 Cubes in Scale");
                }
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View view) {
                Log.d("ADebugTag", "Value:" + view.getId());
                if (view.getId() == 2131230771) {
                    textView2.setText("5 Cubes in Scale");
                }
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View view) {
                Log.d("ADebugTag", "Value:" + view.getId());
                if (view.getId() == 2131230772) {
                    textView2.setText("6+ Cubes in Scale");
                }
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View view) {
                Log.d("ADebugTag", "Value:" + view.getId());
                if (view.getId() == 2131230773) {
                    textView1.setText("1 Cubes in Switch");
                }
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View view) {
                Log.d("ADebugTag", "Value:" + view.getId());
                if (view.getId() == 2131230774) {
                    textView1.setText("2 Cubes in Switch");
                }
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View view) {
                Log.d("ADebugTag", "Value:" + view.getId());
                if (view.getId() == 2131230775) {
                    textView1.setText("3 Cubes in Switch");
                }
            }
        });
        button10.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View view) {
                Log.d("ADebugTag", "Value:" + view.getId());
                if (view.getId() == 2131230762) {
                    textView1.setText("4 Cubes in Switch");
                }
            }
        });
        button11.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View view) {
                Log.d("ADebugTag", "Value:" + view.getId());
                if (view.getId() == 2131230763) {
                    textView1.setText("5 Cubes in Switch");
                }
            }
        });
        button12.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View view) {
                Log.d("ADebugTag", "Value:" + view.getId());
                if (view.getId() == 2131230764) {
                    textView1.setText("6+ Cubes in Switch");
                }
            }
        });
        button13.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View view) {
                Log.d("ADebugTag", "Value:" + view.getId());
                if (view.getId() == 2131230765) {
                    textView3.setText("Can Climb");
                }
            }
        });
        button14.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View view) {
                Log.d("ADebugTag", "Value:" + view.getId());
                if (view.getId() == 2131230766) {
                    textView3.setText("Cannot Climb");
                }
            }
        });
        button15.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View view) {
                Log.d("ADebugTag", "Value:" + view.getId());
                if (view.getId() == 2131230767) {
                    Fragment fragment = new Fragment();
                    Class fragmentClass = null;

                    PrintWriter pw = null;
                    try {
                        FileOutputStream fos = getContext().openFileOutput("data.txt", Context.MODE_PRIVATE);
                        pw = new PrintWriter(fos);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    pw.print(textView1);
                    pw.print(textView2);
                    pw.print(textView3);
                    pw.print(timeTaken);
                    pw.flush();
                    Toast.makeText(getContext(), "Scouting Sheet Saved", 10).show();

                    fragmentClass = HomeScreen.class;
                    try {
                        fragment = (Fragment) fragmentClass.newInstance();
                    }
                    catch (Exception e) {
                        e.printStackTrace();
                    }
                    //Insert the fragment by replacing any existing fragment
                    FragmentManager fragmentManager = getFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.fragmentContent, fragment).commit();
                }
            }
        });

    return view;
    }
}
