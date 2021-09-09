package com.example.mvptest.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.mvptest.R;

public class MainActivity extends AppCompatActivity {

    public Button button;
    public Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);

        button.setOnClickListener(v -> {

            Intent intent = new Intent(this, ExperimentActivity.class);
            startActivity(intent);
        });

        button2.setOnClickListener(v -> {

            Intent intent = new Intent(this, TestActivity.class);
            startActivity(intent);
        });
    }
}