package com.github.nervzz.bootcamp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendMessage(View view) {
        Intent myIntent = new Intent(MainActivity.this, GreetingActivity.class);
        EditText nameField = findViewById(R.id.mainName);
        myIntent.putExtra("name", nameField.getText().toString());
        MainActivity.this.startActivity(myIntent);
    }
}