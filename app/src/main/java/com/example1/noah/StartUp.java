package com.example1.noah;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class StartUp extends AppCompatActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.startup);
    }
    // goes to game activity when clicking the play button
    public void startGame(View view){
        startActivity(new Intent(this,GameActivity.class));
        finish();
    }
}
