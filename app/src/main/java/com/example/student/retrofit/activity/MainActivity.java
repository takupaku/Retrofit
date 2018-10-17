package com.example.student.retrofit.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.student.retrofit.R;
import com.example.student.retrofit.model.Student;
import com.example.student.retrofit.network.ApiClient;
import com.example.student.retrofit.network.ApiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private List<Student> studentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        loadData();



    }

    private void loadData() {

        final StringBuffer stringBuffer = new StringBuffer();
        ApiService apiService = ApiClient.getApiClient().create(ApiService.class);
        Call<List<Student>> call = apiService.getAllStudent();
        call.enqueue(new Callback<List<Student>>() {
            @Override
            public void onResponse(Call<List<Student>> call, Response<List<Student>> response) {

                Toast.makeText(MainActivity.this, ""+response.body(), Toast.LENGTH_SHORT).show();
                studentList = response.body();

                for(int i = 0; i<studentList.size();i++){
                    stringBuffer.append(studentList.get(i).getStudent_Id()).append(" . ")
                            .append(studentList.get(i).getName()).append(" . ")
                            .append(studentList.get(i).getDept()).append("\n\n");
                }
                textView.setText(stringBuffer);


            }

            @Override
            public void onFailure(Call<List<Student>> call, Throwable t) {
                Toast.makeText(MainActivity.this, ""+t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void initView() {
        textView = findViewById(R.id.txtId);
    }
}
