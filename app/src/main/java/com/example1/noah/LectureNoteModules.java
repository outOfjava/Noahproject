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

public class LectureNoteModules extends AppCompatActivity {
    StorageReference storageRef;
    FirebaseStorage firebaseStorage;
    StorageReference ref;
    String filenamenote="",pathnamenote;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lecturenote_modules);
        Intent i2 = getIntent();
        Bundle b1 = i2.getExtras();
        pathnamenote = b1.getString("name");

    }
    public void noteone(View view) {

        filenamenote="Module-1";
        lecturenote();
    }
    public void notetwo(View view) {
        filenamenote="Module-2";
        lecturenote();
    }
    public void notethree(View view) {
        filenamenote="Module-3";
        lecturenote();
    }
    public void notefour(View view) {
        filenamenote="Module-4";
        lecturenote();
    }
    public void notefive(View view) {
        filenamenote="Module-5";
        lecturenote();
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

    public void lecturenote() {
        Toast.makeText(LectureNoteModules.this, "Downloading", Toast.LENGTH_LONG).show();

        storageRef = firebaseStorage.getInstance().getReference();
        ref = storageRef.child(pathnamenote+filenamenote+".pdf");
        ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                String url = uri.toString();
                downloadFile(LectureNoteModules.this, filenamenote,
                        "pdf", "DIRECTORY_DOWNLOADS", url);

            }
        });
    }
}

