package com.example1.noah;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class LectureVideoChapters extends AppCompatActivity {
    StorageReference storageRef;

    FirebaseStorage firebaseStorage;
    StorageReference ref;
    String filename="";
    String pathname;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lecture_video_chapters);
        Intent i2=getIntent();
        Bundle b1=i2.getExtras();
        pathname=b1.getString("name");

    }
    public void englishch1(View view) {
        filename="Chapter 1";
        Videos();
    }
    public void englishch2(View view) {
        filename="Chapter 2";
        Videos();
    }
    public void englishch3(View view) {
        filename="Chapter 3";
        Videos();
    }
    public void englishch4(View view) {
        filename="Chapter 4";
        Videos();
    }
    public void englishch5(View view) {
        filename="Chapter 5";
        Videos();
    }



    public void downloadFile(Context context, String fileName,
                             String fileExt, String destinationDirectory, String url) {
        DownloadManager downloadManager = (DownloadManager)
                context.getSystemService(Context.DOWNLOAD_SERVICE);
        Uri uri = Uri.parse(url);
        DownloadManager.Request request = new DownloadManager.Request(uri);
        request.setNotificationVisibility(DownloadManager.Request.
                VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setDestinationInExternalFilesDir(context, destinationDirectory,
                fileName + fileExt);
        downloadManager.enqueue(request);

    }
    public void Videos() {
        Toast.makeText(LectureVideoChapters.this, "Downloading", Toast.LENGTH_LONG).show();
        storageRef = firebaseStorage.getInstance().getReference();
        ref = storageRef.child(pathname+filename+".mp4");
        ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                String url = uri.toString();
                downloadFile(LectureVideoChapters.this, filename,
                        ".mp4", "DIRECTORY_DOWNLOADS", url);

            }
        });
    }



}
