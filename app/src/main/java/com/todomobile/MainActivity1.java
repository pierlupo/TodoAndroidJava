package com.todomobile;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;


import java.util.ArrayList;

public class MainActivity1 extends AppCompatActivity {

    private ArrayList<String> todos;
    private ArrayAdapter<String> todosAdapter;
    private ListView listView;

    private Button btn;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);

        listView = findViewById(R.id.listview);
        btn = findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addTodo();
            }
        });

        todos = new ArrayList<>();
        todosAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, todos);
        listView.setAdapter(todosAdapter);

        setUpListViewListener();

    }

    private void addTodo() {
        EditText input = findViewById(R.id.editText);
        String todoText = input.getText().toString();

        if(!(todoText.equals(""))){
            todosAdapter.add(todoText);
            input.setText("");
        } else {
            Toast.makeText(getApplicationContext(), "Please enter a to do", Toast.LENGTH_LONG).show();
        }
    }

    private void setUpListViewListener() {
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Context context = getApplicationContext();
                Toast.makeText(context, "Todo Removed", Toast.LENGTH_LONG).show();

                todos.remove(i);
                todosAdapter.notifyDataSetChanged();
                return true;
            }
        });
    }
}
