package com.example.admin.logmoodle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
    }
    public  void subjects(View view){
        Intent intent=new Intent(this,Subjects.class);
                startActivity(intent);
    }
    public  void timetable(View view){
        Intent intent=new Intent(Dashboard.this,Timetable.class);
        startActivity(intent);
    }
    public  void Aboutus(View view){
        Intent intent=new Intent(Dashboard.this,MapsActivity.class);
        startActivity(intent);
    }

}
