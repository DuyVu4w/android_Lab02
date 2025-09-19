package com.example.myappbai3;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static final String Tag = "Life circle";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Log.d(Tag, "onCreate()");
    }

    @Override
    protected  void onStart() {
        super.onStart();
        Log.d(Tag, "onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(Tag, "onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(Tag, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(Tag, "onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(Tag, "onDestroy");
    }
}