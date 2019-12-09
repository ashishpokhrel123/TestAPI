package com.example.testapi;

public class Employee {
    private int id;
    private String  employee_name;
    private float employee_salary;
    private int employee_age;
    private String Profile_image;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    public float getEmployee_salary() {
        return employee_salary;
    }

    public void setEmployee_salary(float employee_salary) {
        this.employee_salary = employee_salary;
    }

    public int getEmployee_age() {
        return employee_age;
    }

    public void setEmployee_age(int employee_age) {
        this.employee_age = employee_age;
    }

    public String getProfile_image() {
        return Profile_image;
    }

    public void setProfile_image(String profile_image) {
        Profile_image = profile_image;
    }

    public Employee(String employee_name, float employee_salary , int employee_age)
    {

        this.employee_name=employee_name;
        this.employee_age=employee_age;
        this.employee_salary=employee_salary;

    }

}
