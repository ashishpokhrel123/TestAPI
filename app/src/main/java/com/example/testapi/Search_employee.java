package com.example.testapi;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.testapi.Interface.EmployeApi;

import javax.xml.validation.Validator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Search_employee extends AppCompatActivity {

    private final static String BASE_URL = "http://dummy.restapiexample.com/api/v1/";

    private EditText etempno;
    private TextView txtdata;
    private Button btnsearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_employee);

        etempno = findViewById(R.id.etempid);
        txtdata = findViewById(R.id.txtdata);
        btnsearch = findViewById(R.id.btnsearch);

        btnsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                loaddata();

            }
        });

    }

    private void loaddata() {

        Retrofit retrofit =new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        EmployeApi employeeAPI = retrofit.create(EmployeApi.class);
        Call<Employee> listCall = employeeAPI.getEmployeeByID(Integer.parseInt(etempno.getText().toString()));

        listCall.enqueue(new Callback<Employee>() {

            @Override
            public void onResponse(Call<Employee> call, Response<Employee> response) {
                Toast.makeText(Search_employee.this, response.body().toString(), Toast.LENGTH_LONG).show();
                String content = "";
                content += "Id : " + response.body().getId() + "\n";
                content += "Name : " + response.body().getEmployee_name() + "\n";
                content += "Age : " + response.body().getEmployee_age() + "\n";
                content += "Salary : " + response.body().getEmployee_salary() + "\n";
                //Toast.makeText(getApplicationContext(),"aaa:"+ content,Toast.LENGTH_SHORT).show();


                txtdata.setText(" Details: \n"+content);
            }

            @Override
            public void onFailure(Call<Employee> call, Throwable t) {
                Toast.makeText(Search_employee.this, "Error", Toast.LENGTH_SHORT).show();
            }
        });
   }
}