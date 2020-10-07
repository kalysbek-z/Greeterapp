package com.example.greeterapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editName;
    Button greet;
    TextView textName;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editName = (EditText) findViewById(R.id.greetField);
        greet = (Button) findViewById(R.id.greet);
        textName = (TextView) findViewById(R.id.name);
        if(savedInstanceState != null){
            name = savedInstanceState.getString("name");
            textName.setText(name);
        }

        greet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((String) editName.getText().toString()).isEmpty()) {
                    Toast.makeText(MainActivity.this, "Text Field is empty!", Toast.LENGTH_SHORT).show();
                } else {
                    name = "Hello " + editName.getText().toString();
                    textName.setText(name);
                }
            }
        });
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("name", name);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }
}