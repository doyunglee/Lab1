package com.evansimpson.mobpro.lab1;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Adapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Iterator;

public class MainActivity extends Activity {

    private ArrayList<String> taskList;
    adapter newAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        taskList = new ArrayList<String>();
        //uses the my2Do Arraylist and puts it into an adapter with the name newAdapter
        newAdapter = new adapter(this, taskList);
        //makes a listview1 that is called from activity_main with id listView and sets it to adapter newAdapter
        ListView listView1 = (ListView) findViewById(R.id.listView);
        listView1.setAdapter(newAdapter);
    }

    public void addTodo(View view) {
        //find that EditText from activity_main called editText and call it newTask.
        EditText newTask = (EditText) findViewById(R.id.editText);
        //make a string called work that is the text from the newTask
        String work = newTask.getText().toString();

        taskList.add(work);
        newAdapter.notifyDataSetChanged();
        //Toast.makeText(this, work, Toast.LENGTH_LONG).show();
    }



}

