package com.example.testapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.testapi.Interface.EmployeApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class EmployeeActivity extends AppCompatActivity {

    private final static  String BASE_URL = "http://dummy.restapiexample.com/api/v1/";

    EditText ed1,et2,et3;
    Button btnsave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee);

        ed1 = findViewById(R.id.edtname);
        et2 = findViewById(R.id.edtage);
        et3 = findViewById(R.id.edtsalary);
        btnsave = findViewById(R.id.save);

        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                register();

            }
        });





    }

    private void register()
    {
        int id;
        String name = ed1.getText().toString();
        int age = Integer.parseInt(et2.getText().toString());
        float salary = Float.parseFloat(et3.getText().toString());

        Employee employee = new Employee(name,salary,age);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        EmployeApi employeApi = retrofit.create(EmployeApi.class);
        Call<Void> voidcall = employeApi.registeremployee(employee);

        voidcall.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Toast.makeText(getApplicationContext(),"Successfully added",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(getApplication(),"Error",Toast.LENGTH_SHORT).show();

            }
        });

    }
}
