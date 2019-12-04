package com.example.testapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.testapi.Interface.EmployeApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private TextView tvdata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvdata = findViewById(R.id.tvdata);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://dummy.restapiexample.com/api/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        EmployeApi employeApi = retrofit.create(EmployeApi.class);
        Call<List<Employee>> listCall = employeApi.getEmployee();

        listCall.enqueue(new Callback<List<Employee>>() {
            @Override
            public void onResponse(Call<List<Employee>> call, Response<List<Employee>> response) {

                if(!response.isSuccessful())
                {
                    tvdata.setText("Code:"+response.code());
                    return;
                }
                List<Employee>employeeList=response.body();
                for(Employee employee:employeeList){
                    String content = "";
                    content +="ID:"+employee.getId() + "\n";
                    content +="Employee Name:"+employee.getEmployee_name() + "\n";
                    content +="Employee age:"+employee.getEmployee_age() + "\n";
                    content +="Employee salary:"+employee.getEmployee_salary()+ "\n";
                    content +="Employee Profile:"+employee.getProfile_image()+ "\n";

                    tvdata.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<Employee>> call, Throwable t) {

            tvdata.setText("Error:"+t.getMessage());
            }
        });
    }
}
