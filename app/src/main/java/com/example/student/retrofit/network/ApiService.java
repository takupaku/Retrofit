package com.example.student.retrofit.network;

import com.example.student.retrofit.model.Student;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {
    @GET("api/get_data.php")
   Call<List<Student>> getAllStudent();

    @POST("api/student_data.php")
    Call<Student> insertStudent(@Body Student student);

}
