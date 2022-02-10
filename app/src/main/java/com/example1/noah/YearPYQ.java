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
// download the datas saved in firebase as pdf
public class YearPYQ extends AppCompatActivity {
    StorageReference storageRef;

    FirebaseStorage firebaseStorage;
    StorageReference ref;

    String pathnamepyq="";
    String filenamepyq="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_year_pyq);
        Intent i2 = getIntent();
        Bundle b1 = i2.getExtras();
        pathnamepyq = b1.getString("name");

    }


        public void one(View view) {
            filenamepyq="2021";
            PYQ();
        }
        public void two(View view) {
            filenamepyq="2020";
            PYQ();
        }
        public void three(View view) {
            filenamepyq="2019";
            PYQ();
        }
        public void four(View view) {
            filenamepyq="2018";
            PYQ();
        }
        public void five(View view) {
            filenamepyq="2017";
            PYQ();
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


    public void PYQ () {

        Toast.makeText(YearPYQ.this, "Downloading", Toast.LENGTH_LONG).show();
        storageRef = firebaseStorage.getInstance().getReference();
        ref = storageRef.child(pathnamepyq+filenamepyq+".pdf");
        ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                String url = uri.toString();
                downloadFile(YearPYQ.this, filenamepyq, "pdf",
                        "DIRECTORY_DOWNLOADS", url);


            }
        });
    }
}