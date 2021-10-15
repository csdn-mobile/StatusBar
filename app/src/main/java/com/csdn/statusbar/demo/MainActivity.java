package com.csdn.statusbar.demo;

import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.csdn.statusbar.StatusBar;
import com.csdn.statusbar.annotation.FontMode;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StatusBar.Builder()
                .color(Color.WHITE)
                .fontMode(FontMode.DARK)
                .transparent(true)
                .change(this);
    }
}