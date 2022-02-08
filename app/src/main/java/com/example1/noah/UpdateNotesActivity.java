package com.example1.noah;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class UpdateNotesActivity extends AppCompatActivity {

    EditText title,description;
    Button updateNotes;
    String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_notes);

        title=findViewById(R.id.title);
        description=findViewById(R.id.description);
        updateNotes=findViewById(R.id.updateNote);

        Intent i =getIntent();
        title.setText(i.getStringExtra("title"));
        description.setText(i.getStringExtra("description"));
        id=i.getStringExtra("id");

        updateNotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!TextUtils.isEmpty(title.getText().toString()) && !TextUtils.isEmpty(description.getText().toString()))
                {

                    com.example1.noah.DatabaseClass db = new com.example1.noah.DatabaseClass(UpdateNotesActivity.this);
                    db.updateNotes(title.getText().toString(),description.getText().toString(),id);

                    Intent i=new Intent(UpdateNotesActivity.this, com.example1.noah.MainActivityNote.class);
                    i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(i);
                    finish();


                }
                else
                {
                    Toast.makeText(UpdateNotesActivity.this, "Both Fields Required", Toast.LENGTH_SHORT).show();
                }


            }
        });


    }
}