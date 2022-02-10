package com.example1.noah;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_main);
    }
    // Goes to lecture video page
    public void video(View view){
        Intent intent=new Intent(getApplicationContext(),LectureVideoPage.class);
        startActivity(intent);
    }
//goes to lecture note
public void lecturenote(View view) {
    Intent intent = new Intent(getApplicationContext(), LectureNotesMainActivity.class);
    startActivity(intent);
}
//Navigates to note pad
    public void notepad(View view){
        Intent intent=new Intent(getApplicationContext(),MainActivityNote.class);
        startActivity(intent);
    }
    //navigates to pyg page
    public void pyq(View view){
        Intent intent=new Intent(getApplicationContext(),MainActivityPYQ.class);
        startActivity(intent);
    }
//navigates to calculator activity
    public void calc(View view){
        Intent intent=new Intent(getApplicationContext(),MainActivityCalculator.class);
        startActivity(intent);
    }
// game list which includes two games
    public void games(View view){
        Intent intent=new Intent(getApplicationContext(),gamelist.class);
        startActivity(intent);
    }

}