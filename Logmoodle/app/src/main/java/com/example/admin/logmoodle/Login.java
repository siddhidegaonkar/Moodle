package com.example.admin.logmoodle;

import android.content.Intent;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
    private EditText userEmail, userPass;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        userEmail = (EditText) findViewById(R.id.userEmail);
        userPass = (EditText) findViewById(R.id.userPass);
        mAuth = FirebaseAuth.getInstance();

    }

    public void signinButtonClicked(View view) {

        (mAuth.signInWithEmailAndPassword(userEmail.getText().toString(), userPass.getText().toString()))
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {
                            Toast.makeText(Login.this, "LOGIN SUCCESSFUL", Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(Login.this, Dashboard.class);
                            i.putExtra("Email", mAuth.getCurrentUser().getEmail());
                            startActivity(i);
                        } else {
                            Log.e("Error", task.getException().toString());
                            Toast.makeText(Login.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}

