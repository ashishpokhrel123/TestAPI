package com.example.testapi;

public class EmployeeCUD {
    private int id;
    private String name;
    private float salary;
    private int age;
    private String Profile_image;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmployee_name() {
        return name;
    }

    public void setEmployee_name(String employee_name) {
        this.name = employee_name;
    }

    public float getEmployee_salary() {
        return salary;
    }

    public void setEmployee_salary(float employee_salary) {
        this.salary = employee_salary;
    }

    public int getEmployee_age() {
        return age;
    }

    public void setEmployee_age(int employee_age) {
        this.age = employee_age;
    }

    public String getProfile_image() {
        return Profile_image;
    }

    public void setProfile_image(String profile_image) {
        Profile_image = profile_image;
    }

    public EmployeeCUD(String employee_name, float employee_salary, int employee_age) {
        this.name = employee_name;
        this.age = employee_age;
        this.salary = employee_salary;

    }
}
