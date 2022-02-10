package com.example1.noah;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class MainVideoPlayActivity extends AppCompatActivity {
    TextView tv,tv2,tv3;
    VideoView v1,v2,v3;
    MediaController mc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_video_play);
        v1 = findViewById(R.id.videoView3);
        v2 = findViewById(R.id.videoView5);
        v3 = findViewById(R.id.videoView6);
        //initialising different video players for each videos
        MediaController mc = new MediaController(this);
        mc.setAnchorView(v1);
        MediaController mc1 = new MediaController(this);
        mc1.setAnchorView(this.v2);
        MediaController mc2 = new MediaController(this);
        mc2.setAnchorView(this.v3);
        v1.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.chapter1));
        v1.setMediaController(mc);

        v2.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.chapter2));
        v2.setMediaController(mc1);

        v3.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.chapter3));
        v3.setMediaController(mc2);
    }
    // the video starts playing only after clicking on the video
    public void v1(View view){
        v1.start();
    }
    public void v2(View view){
        v2.start();
    }
    public void v3(View view){
        v3.start();
    }


}