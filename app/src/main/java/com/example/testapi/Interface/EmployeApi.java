package com.example.testapi.Interface;

import com.example.testapi.Employee;
import com.example.testapi.EmployeeCUD;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface EmployeApi {


    @GET("employees")
    Call<List<Employee>>getEmployee();
    @POST("employees")
    Call<Void> registeremployee(@Body Employee emp);
    @GET("employee/{empID}")
    Call<Employee> getEmployeeByID (@Path("empID") int empId);
    @PUT("employee/{empID}")
    Call<Void> updateemployee(@Path("empID") int empId ,@Body EmployeeCUD emp);
    @DELETE("employee/{empID}")
    Call<Void> deleteemployee(@Path("empID") int empId);
}
