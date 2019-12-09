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

public class UpdateEmployeeActivity extends AppCompatActivity {
    private final static  String BASE_URL = "http://dummy.restapiexample.com/api/v1/";

    private EditText et1,et2,et3,etsearch;
    private Button btnupdate,btndelete,btnsearch;
    Retrofit retrofit;
    EmployeApi employeApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        et1 = findViewById(R.id.edtname);
        et2 = findViewById(R.id.edtage);
        et3 = findViewById(R.id.edtsalary);
        etsearch = findViewById(R.id.edsearchid);
        btnupdate = findViewById(R.id.update);
        btndelete = findViewById(R.id.delete);
        btnsearch = findViewById(R.id.search);


        btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                update();
            }
        });
         btndelete.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 delete();
             }
         });
         btnsearch.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 loaddata();
             }
         });
    }
    private void CreateInstance()
    {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        employeApi = retrofit.create(EmployeApi.class);
    }
        private void loaddata()
        {
               CreateInstance();
               Call<Employee> listCall = employeApi.getEmployeeByID(Integer.parseInt(etsearch.getText().toString()));
               listCall.enqueue(new Callback<Employee>() {
                   @Override
                   public void onResponse(Call<Employee> call, Response<Employee> response) {
                       et1.setText(response.body().getEmployee_name());

                       et2.setText( Float.toString(response.body().getEmployee_salary()));
                       et3.setText(Integer.toString(response.body().getEmployee_age()));
                   }

                   @Override
                   public void onFailure(Call<Employee> call, Throwable t) {

                       Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_SHORT).show();

                   }
               });
        }
        private void update()
        {
           CreateInstance();
           EmployeeCUD employeeCUD = new EmployeeCUD(
                   et1.getText().toString(),
                   Float.parseFloat(et2.getText().toString()),
                   Integer.parseInt(et3.getText().toString())


           );



            Call<Void> voidCall = employeApi.updateemployee(Integer.parseInt(etsearch.getText().toString()),employeeCUD);
            voidCall.enqueue(new Callback<Void>() {
                @Override
                public void onResponse(Call<Void> call, Response<Void> response) {
                    Toast.makeText(getApplication(),"Update",Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onFailure(Call<Void> call, Throwable t) {
                    Toast.makeText(getApplication(),"Error",Toast.LENGTH_SHORT).show();

                }
            });


        }
        private void delete()
        {
            CreateInstance();
            Call<Void> voidCall = employeApi.deleteemployee(Integer.parseInt(etsearch.getText().toString()));
            voidCall.enqueue(new Callback<Void>() {
                @Override
                public void onResponse(Call<Void> call, Response<Void> response) {
                    Toast.makeText(getApplication(),"Delete succesfully",Toast.LENGTH_SHORT).show();

                }

                @Override
                public void onFailure(Call<Void> call, Throwable t) {
                    Toast.makeText(getApplication(),"Error",Toast.LENGTH_SHORT).show();

                }
            });
        }
    }

