package com.csdn.statusbar.demo;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.csdn.statusbar.StatusBar;
import com.csdn.statusbar.annotation.FontMode;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StatusBar.Builder()
                .color(getResources().getColor(R.color.yellow))
                .fontMode(FontMode.DARK)
                .transparent(false)
                .change(this);
    }

    public void setFontWhite(View view) {
        StatusBar.Builder()
                .fontMode(FontMode.LIGHT)
                .change(this);
    }

    public void setFontBlack(View view) {
        StatusBar.Builder()
                .fontMode(FontMode.DARK)
                .change(this);
    }

    public void hideStatusBar(View view) {
        StatusBar.Builder()
                .transparent(true)
                .change(this);
    }

    public void showStatusBar(View view) {
        StatusBar.Builder()
                .transparent(false)
                .change(this);
    }

    public void setBgRed(View view) {
        StatusBar.Builder()
                .color(getResources().getColor(R.color.red))
                .change(this);
    }

    public void setBgWhite(View view) {
        StatusBar.Builder()
                .color(Color.WHITE)
                .change(this);
    }

}