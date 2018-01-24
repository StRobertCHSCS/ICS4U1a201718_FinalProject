package com.strobertchs.edussentials;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class Todolist extends AppCompatActivity {
    private ArrayList<String> tasks;
    private ArrayAdapter<String> tasksAdapter;
    private ListView lvTasks;

    private Button newTaskOpen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todolist);


        lvTasks = (ListView)findViewById(R.id.lvTasks);
        tasks = new ArrayList<>();
        tasksAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, tasks);
        lvTasks.setAdapter(tasksAdapter);
        tasks.add("Task 1");
        tasks.add("Task 2");
        setupListViewListener();

    }

    private void setupListViewListener() {
        lvTasks.setOnItemLongClickListener(
                new AdapterView.OnItemLongClickListener() {
                    @Override
                    public boolean onItemLongClick(AdapterView<?> adapter, View item, int pos, long id) {
                        tasks.remove(pos);
                        tasksAdapter.notifyDataSetChanged();
                        return true;
                    }

                });
    }

    public void onAddTask(View v) {
        EditText etNewTask = (EditText) findViewById(R.id.taskName);
        String taskText = etNewTask.getText().toString();
        tasksAdapter.add(taskText);
        etNewTask.setText("");

    }
}
