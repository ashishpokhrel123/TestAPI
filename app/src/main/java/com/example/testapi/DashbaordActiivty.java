package com.example.testapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;

public class DashbaordActiivty extends AppCompatActivity {
    Button btnshow,btnregister,btnsearch,btnupdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashbaord_actiivty);

        btnshow = findViewById(R.id.btnshow);
        btnregister = findViewById(R.id.btnregister);
        btnsearch =findViewById(R.id.btnsearch);
        btnupdate = findViewById(R.id.btnupdatedelete);

        btnshow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DashbaordActiivty.this,MainActivity.class);
                startActivity(i);
            }
        });
        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DashbaordActiivty.this,EmployeeActivity.class);
                startActivity(i);
            }
        });
        btnsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DashbaordActiivty.this,Search_employee.class);
                startActivity(i);
            }
        });
        btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DashbaordActiivty.this,UpdateEmployeeActivity.class);
                startActivity(i);
            }
        });
    }
}
