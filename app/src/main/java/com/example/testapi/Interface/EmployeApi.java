package com.example.testapi.Interface;

import com.example.testapi.Employee;
import com.example.testapi.EmployeeCUD;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface EmployeApi {


    @GET("employees")
    Call<List<Employee>>getEmployee();
    @POST("employees")
    Call<Void> registeremployee(@Body EmployeeCUD emp);
}
