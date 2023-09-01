package com.todomobile;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;


public class MainActivity extends AppCompatActivity {
    private EditText editText1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = findViewById(R.id.editText1);

        String todo = editText1.getText().toString();
        Intent intent = new Intent(MainActivity.this, MainActivity1.class);
        intent.putExtra("text_key", todo);

        startActivity(intent);

    }



}