package com.example1.noah;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class LectureNotesMainActivity extends AppCompatActivity {
    String pathnamenote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lecturenotes);
    }

    public void demoenglish(View view) {
        pathnamenote="LectureNotes/English/";
        Intent intent = new Intent(getApplicationContext(), LectureNoteModules.class);
        intent.putExtra("name",pathnamenote);
        startActivity(intent);
    }

    public void demomaths(View view) {
        pathnamenote="LectureNotes/Maths/";
        Intent intent = new Intent(getApplicationContext(), LectureNoteModules.class);
        intent.putExtra("name",pathnamenote);
        startActivity(intent);
    }

    public void demophysics(View view) {
        pathnamenote="LectureNotes/Physics/";
        Intent intent = new Intent(getApplicationContext(), LectureNoteModules.class);
        intent.putExtra("name",pathnamenote);
        startActivity(intent);
    }

    public void demochemistry(View view) {
        pathnamenote="LectureNotes/Chemistry/";
        Intent intent = new Intent(getApplicationContext(), LectureNoteModules.class);
        intent.putExtra("name",pathnamenote);
        startActivity(intent);
    }

    public void demobiology(View view) {
        pathnamenote="LectureNotes/Biology/";
        Intent intent = new Intent(getApplicationContext(), LectureNoteModules.class);
        intent.putExtra("name",pathnamenote);
        startActivity(intent);
    }
    public void demosocial(View view) {
        pathnamenote="LectureNotes/Social Science/";
        Intent intent = new Intent(getApplicationContext(), LectureNoteModules.class);
        intent.putExtra("name",pathnamenote);
        startActivity(intent);
    }
}
