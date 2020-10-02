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

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    EditText editName;
    Button greet;
    TextView textName;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferences = getSharedPreferences("name", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editName = (EditText) findViewById(R.id.greetField);
        greet = (Button) findViewById(R.id.greet);
        textName = (TextView) findViewById(R.id.name);
        setTextOnCreate();

        greet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((String) editName.getText().toString()).isEmpty()) {
                    Toast.makeText(MainActivity.this, "Text Field is empty!", Toast.LENGTH_SHORT).show();
                } else {
                    if (name != "") {
                        name = sharedPreferences.getString("name", "");
                        name = editName.getText().toString();
                        textName.setText("Hello " + name);
                    } else {
                        name = editName.getText().toString();
                        textName.setText("Hello " + name);
                    }
                    commitToSharedPreferences();
                }
            }
        });
    }

    public void commitToSharedPreferences() {
        editor.putString("name", name);
        editor.commit();
    }

    private void setTextOnCreate() {
        sharedPreferences = getSharedPreferences("name", Context.MODE_PRIVATE);
        name = sharedPreferences.getString("name", "");
        textName.setText(name);
    }

}