package com.example1.noah;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class MainActivity extends AppCompatActivity {
    private EditText editTextEmail, editTextPassword;
    private FirebaseAuth mAuth;
    private ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextEmail=findViewById(R.id.email);
        editTextPassword=findViewById(R.id.editTextTextPassword);
        progressBar=findViewById(R.id.progressBar);
        mAuth=FirebaseAuth.getInstance();


    }
    public void register(View view)
    {
        Intent intent=new Intent(getApplicationContext(), Register.class);
        startActivity(intent);

    }
    public void signIn(View view)
    {
        String email=editTextEmail.getText().toString().trim();
        String password=editTextPassword.getText().toString().trim();
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
        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    FirebaseUser user= FirebaseAuth.getInstance().getCurrentUser();
                    if(user.isEmailVerified()){
                        //redirect to user profile
                        startActivity(new Intent(MainActivity.this, ProfileActivity.class));
                        progressBar.setVisibility(View.GONE);
                    }else {
                        user.sendEmailVerification();
                        Toast.makeText(MainActivity.this, "Check your Email to verify your account", Toast.LENGTH_LONG).show();
                        progressBar.setVisibility(View.GONE);
                    }
                }
                else{
                    Toast.makeText(MainActivity.this,"Failed to login!, Please check your credentials",Toast.LENGTH_LONG).show();
                    progressBar.setVisibility(View.GONE);
                }

            }
        });
    }
    public void forgotPassword(View view)
    {
        startActivity(new Intent(this,ForgotPassword.class));
    }

}