package com.github.nervzz.bootcamp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GreetingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        setContentView(R.layout.activity_greeting);

        String greetMsg = "Hello " + name + " !";
        TextView message = findViewById(R.id.greetingMessage);
        message.setText(greetMsg);
    }
}