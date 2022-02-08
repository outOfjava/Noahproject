package com.example1.noah;

import android.os.Bundle;
import android.widget.Space;

import androidx.appcompat.app.AppCompatActivity;

public class GameActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new SpaceShooter(this));
    }
    @Override
    public void onDestroy(){
        super.onDestroy();
    }
    @Override
    public void onPause(){
        super.onPause();
    }
}
