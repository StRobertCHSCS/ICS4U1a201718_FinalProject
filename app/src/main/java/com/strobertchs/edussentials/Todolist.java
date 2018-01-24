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
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Todolist extends AppCompatActivity {

    private void readToDoList() {
        File filesDir = getFilesDir();
        File toDoListFile = new File(filesDir, "tasks.txt");
        try {
            tasks = new ArrayList<String>(FileUtils.readLines(toDoListFile));
        } catch (IOException e) {
            tasks = new ArrayList<String>();
        }
    }

    private void writeTasks() {
        File filesDir = getFilesDir();
        File toDoListFile = new File(filesDir, "tasks.txt");
        try {
            FileUtils.writeLines(toDoListFile, tasks);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private ArrayList<String> tasks;
    private ArrayAdapter<String> tasksAdapter;
    private ListView lvTasks;

    private Button newTaskOpen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todolist);


        lvTasks = (ListView)findViewById(R.id.lvTasks);
        readToDoList();
        tasksAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, tasks);
        lvTasks.setAdapter(tasksAdapter);
        setupListViewListener();

    }

    private void setupListViewListener() {
        lvTasks.setOnItemLongClickListener(
                new AdapterView.OnItemLongClickListener() {
                    @Override
                    public boolean onItemLongClick(AdapterView<?> adapter, View item, int pos, long id) {
                        tasks.remove(pos);
                        tasksAdapter.notifyDataSetChanged();
                        writeTasks();
                        return true;
                    }

                });
    }

    public void onAddTask(View v) {
        EditText etNewTask = (EditText) findViewById(R.id.taskName);
        String taskText = etNewTask.getText().toString();
        tasksAdapter.add(taskText);
        etNewTask.setText("");
        writeTasks();

    }
}
