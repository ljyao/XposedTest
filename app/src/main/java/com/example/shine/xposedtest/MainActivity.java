package com.example.shine.xposedtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import de.robv.android.xposed.XposedHelpers;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
