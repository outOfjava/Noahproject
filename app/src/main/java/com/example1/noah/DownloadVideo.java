package com.example1.noah;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class DownloadVideo extends AppCompatActivity {
    String pathname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download_video);
    }

    public void demoenglish(View view) {
        pathname="LectureVideos/English/";
        Intent intent = new Intent(getApplicationContext(), LectureVideoChapters.class);
        intent.putExtra("name",pathname);
        startActivity(intent);
    }

    public void demomaths(View view) {
        pathname="LectureVideos/Maths/";
        Intent intent = new Intent(getApplicationContext(), LectureVideoChapters.class);
        intent.putExtra("name",pathname);
        startActivity(intent);
    }

    public void demophysics(View view) {
        pathname="LectureVideos/Physics/";
        Intent intent = new Intent(getApplicationContext(), LectureVideoChapters.class);
        intent.putExtra("name",pathname);
        startActivity(intent);
    }

    public void demochemistry(View view) {
        pathname="LectureVideos/Chemistry/";
        Intent intent = new Intent(getApplicationContext(), LectureVideoChapters.class);
        intent.putExtra("name",pathname);
        startActivity(intent);
    }

    public void demobiology(View view) {
        pathname="LectureVideos/Biology/";
        Intent intent = new Intent(getApplicationContext(), LectureVideoChapters.class);
        intent.putExtra("name",pathname);
        startActivity(intent);
    }

    public void demosocial(View view) {
        pathname="LectureVideos/Social/";
        Intent intent = new Intent(getApplicationContext(), LectureVideoChapters.class);
        intent.putExtra("name",pathname);
        startActivity(intent);
    }

}
