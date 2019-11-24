package com.example.admin.logmoodle;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
public class Subjects extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subjects);
    }
    public void Dbms(View view) {
        Intent Intent = new Intent(this,Upload.class);
        startActivity(Intent);
    }

    public void toc(View view) {
        Intent Intent = new Intent(this, Upload.class);
        startActivity(Intent);
    }
    public void sepm(View view) {
        Intent Intent = new Intent(this,Upload.class);
        startActivity(Intent);
    }

    public void isee(View view) {
        Intent Intent = new Intent(this, Upload.class);
        startActivity(Intent);
    }
    public void cn(View view) {
        Intent Intent = new Intent(this,Upload.class);
        startActivity(Intent);
    }

}
