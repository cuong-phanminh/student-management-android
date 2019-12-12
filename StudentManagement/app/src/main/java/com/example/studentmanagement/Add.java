package com.example.studentmanagement;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import java.util.ArrayList;
import java.util.List;

public class Add extends AppCompatActivity {
    Button btnAddStudent;
    EditText et1, et2;
    StudentDatabase db;
    RecyclerView rvStudent;
    StudentAdapter studentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_main);

        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        btnAddStudent = findViewById(R.id.btnAddStudent);


        db = Room.databaseBuilder(getApplicationContext(),
                StudentDatabase.class, "database-name").build();

        btnAddStudent.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("StaticFieldLeak")
            @Override
            public void onClick(View view) {
                addStudent();
                finish();
            }
        });


    }
    public void addStudent(){
        final Student student = new Student();
        student.setStudentID(Integer.parseInt(et1.getText().toString()));
        student.setStudentName(et2.getText().toString());

        new AsyncTask<Void, Void, Void>() {
            @SuppressLint("WrongThread")
            @Override
            protected Void doInBackground(Void... voids) {
                db.studentDao().insert(student);
                return null;
            }
        }.execute();
    }
}

