package com.example1.noah;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class gamelist extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gamelist);
    }
    //Navigates to curresponding game activity while clicking the button
    public void space(View view){
        Intent intent=new Intent(getApplicationContext(),StartUp.class);
        startActivity(intent);
    }
    public void fly(View view){
        Intent intent=new Intent(getApplicationContext(),MainActivityBird.class);
        startActivity(intent);
    }
}