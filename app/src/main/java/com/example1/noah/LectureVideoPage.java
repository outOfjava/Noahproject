package com.example1.noah;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class LectureVideoPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lecture_video_page);
    }
    public void playvideo(View view)
    {
        Intent intent=new Intent(getApplicationContext(),MainVideoPlayActivity.class);
        startActivity(intent);
    }
    public void downloadvideo(View view)
    {
        Intent intent=new Intent(getApplicationContext(),DownloadVideo.class);
        startActivity(intent);
    }
}