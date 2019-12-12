package com.example.studentmanagement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    EditText et1, et2;
    StudentDatabase db;
    Button btnAdd;
    private TextView txtStudents;
    RecyclerView rvStudent;
    StudentAdapter studentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = Room.databaseBuilder(getApplicationContext(),
                StudentDatabase.class, "database-name").build();

        btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSecondScreen();
            }
        });

        rvStudent = findViewById(R.id.rvStudent);
        rvStudent.setLayoutManager(new LinearLayoutManager(this));
        final StudentAdapter adapter = new StudentAdapter();

        new AsyncTask<Void, Void, Void>() {
            @SuppressLint("WrongThread")
            @Override
            protected Void doInBackground(Void... voids) {
               studentAdapter.data = db.studentDao().getAll();
                final List<Student> studentList = new ArrayList<>();
                rvStudent.setAdapter(adapter);

                Log.i("database1", "size" + studentList.size());

                return null;
            }
        }.execute();

    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    //cach chuyen screen
    private void openSecondScreen(){
        Intent intent=new Intent(this, Add.class);
        startActivity(intent);
    }
}

