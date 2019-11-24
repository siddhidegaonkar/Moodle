package com.example.admin.logmoodle;
import android.content.Intent;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
public class MainActivity extends AppCompatActivity {

    private EditText email,pass;

    private DatabaseReference mDatabase;

    private FirebaseAuth mAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        email=(EditText)findViewById(R.id.editEmail);

        pass=(EditText)findViewById(R.id.editPass);

        mAuth= FirebaseAuth.getInstance();

        mDatabase= FirebaseDatabase.getInstance().getReference().child("owner");


    }

    public  void signupButtonClicked(View view){

        //final String email_text=email.getText().toString().trim();
        //String pass_text=pass.getText().toString().trim();

        // if(!TextUtils.isEmpty(email_text) && !TextUtils.isEmpty(pass_text) ){

        mAuth.createUserWithEmailAndPassword(email.getText().toString(),pass.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()) {

                    String user_id = mAuth.getCurrentUser().getUid();
                    DatabaseReference current_user = mDatabase.child(user_id);
                    current_user.child("Name").setValue(email.getText().toString());
                    Toast.makeText(MainActivity.this,"Registered successfully",Toast.LENGTH_SHORT).show();

                    Intent login = new Intent(MainActivity.this, Login.class);
                    startActivity(login);
                }else {
                    Log.e("Error",task.getException().toString());
                    Toast.makeText(MainActivity.this,task.getException().getMessage(),Toast.LENGTH_SHORT).show();

                }
            }
        }) ;
        // }

    }
    public  void signinButtonClicked(View view){
        Intent loginIntent= new Intent(MainActivity.this,Login.class);
        startActivity(loginIntent);
    }
}

