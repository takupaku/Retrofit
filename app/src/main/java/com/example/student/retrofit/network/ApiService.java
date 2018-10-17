package com.example.student.retrofit.network;

import com.example.student.retrofit.model.Student;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("api/get_data.php")
   Call<List<Student>> getAllStudent();

}
