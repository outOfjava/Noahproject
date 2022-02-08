package com.example1.noah;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private TextView banner,registerUser;
    private EditText editTextFullName, editTextAge, editTextEmail, editTextPassword;
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mAuth = FirebaseAuth.getInstance();
        banner=findViewById(R.id.textView);
        registerUser=findViewById(R.id.button2);
        editTextFullName=findViewById(R.id.editTextTextPersonName);
        editTextAge =findViewById(R.id.editTextNumber);
        editTextEmail=findViewById(R.id.editTextTextEmailAddress2);
        editTextPassword=findViewById(R.id.editTextTextPassword2);
        progressBar=findViewById(R.id.progressBar2);
    }
    public void home(View view)
    {

        Intent i=new Intent(getApplicationContext(), MainActivity.class);
        startActivity(i);
    }
    public void registerUser(View view)
    {
        String email=editTextEmail.getText().toString().trim();
        String password=editTextPassword.getText().toString().trim();
        String fullName=editTextFullName.getText().toString().trim();
        String standard=editTextAge.getText().toString().trim();
        if(fullName.isEmpty())
        {
            editTextFullName.setError("Full name is required!");
            editTextFullName.requestFocus();
            return;
        }
        if(standard.isEmpty())
        {
            editTextAge.setError("Age is required!");
            editTextAge.requestFocus();
            return;
        }
        if(email.isEmpty())
        {
            editTextEmail.setError("Email is required!");
            editTextEmail.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            editTextEmail.setError("Please provide valid email!");
            editTextEmail.requestFocus();
            return;
        }
        if(password.isEmpty())
        {
            editTextPassword.setError("Password is required!");
            editTextPassword.requestFocus();
            return;
        }
        if(password.length()<6)
        {
            editTextPassword.setError("Minimum length for the password is 6 character");
            editTextPassword.requestFocus();
            return;
        }
        progressBar.setVisibility(View.VISIBLE);
        mAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Users user=new Users(fullName,standard,email);
                            FirebaseDatabase.getInstance().getReference("Users")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if(task.isSuccessful()){
                                        Toast.makeText(Register.this,"User has been registered succesfully",Toast.LENGTH_LONG).show();
                                        progressBar.setVisibility(View.GONE);
                                        Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                                        startActivity(intent);
                                    }else{
                                        Toast.makeText(Register.this,"Failed to register in, Try again!",Toast.LENGTH_LONG).show();
                                        progressBar.setVisibility(View.GONE);

                                    }
                                }
                            });
                        }else {
                            Toast.makeText(Register.this, "Failed to register out, Try again!", Toast.LENGTH_LONG).show();
                            progressBar.setVisibility(View.GONE);
                        }
                    }
                });


    }
}