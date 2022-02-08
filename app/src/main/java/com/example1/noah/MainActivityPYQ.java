package com.example1.noah;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivityPYQ extends AppCompatActivity {


    String pathnamepyq="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_pyq);
    }
    public void englishpyq(View view) {
        pathnamepyq="PreviousYearQuestionPapers/English/";
        Intent intent = new Intent(getApplicationContext(), YearPYQ.class);
        intent.putExtra("name",pathnamepyq);
        startActivity(intent);

    }

    public void mathspyq(View view) {
        pathnamepyq="PreviousYearQuestionPapers/Maths/";
        Intent intent = new Intent(getApplicationContext(), YearPYQ.class);
        intent.putExtra("name",pathnamepyq);
        startActivity(intent);
    }

    public void physicspyq(View view) {
        pathnamepyq="PreviousYearQuestionPapers/Physics/";
        Intent intent = new Intent(getApplicationContext(), YearPYQ.class);
        intent.putExtra("name",pathnamepyq);
        startActivity(intent);
    }
    public void chemistrypyq(View view) {
        pathnamepyq="PreviousYearQuestionPapers/Chemistry/";
        Intent intent = new Intent(getApplicationContext(), YearPYQ.class);
        intent.putExtra("name",pathnamepyq);
        startActivity(intent);
    }
    public void biologypyq(View view) {
        pathnamepyq="PreviousYearQuestionPapers/Biology/";
        Intent intent = new Intent(getApplicationContext(), YearPYQ.class);
        intent.putExtra("name",pathnamepyq);
        startActivity(intent);
    }

    public void socialpyq(View view) {
        pathnamepyq="PreviousYearQuestionPapers/Social/";
        Intent intent = new Intent(getApplicationContext(), YearPYQ.class);
        intent.putExtra("name",pathnamepyq);
        startActivity(intent);
    }





}
