package com.example.student.retrofit.model;

import com.google.gson.annotations.SerializedName;

public class Student {
    @SerializedName("id")
    private String id;

    @SerializedName("name")
    private String name;

    @SerializedName("dept")
    private String dept;

    @SerializedName("student_id")
    private String student_Id;

    public Student(String id, String name, String dept, String student_Id) {
        this.id = id;
        this.name = name;
        this.dept = dept;
        this.student_Id = student_Id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getStudent_Id() {
        return student_Id;
    }

    public void setStudent_Id(String student_Id) {
        this.student_Id = student_Id;
    }
}
