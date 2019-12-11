package com.example.studentmanagement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
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
    Button btnAddStudent;
    private TextView txtStudents;
    RecyclerView rvStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvStudent = findViewById(R.id.rvStudent);

        db = Room.databaseBuilder(getApplicationContext(),
                StudentDatabase.class, "database-name").build();

        btnAddStudent = findViewById(R.id.btnAddStudent);
        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);

        btnAddStudent.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("StaticFieldLeak")
            @Override
            public void onClick(View view) {
                final Student student = new Student();
                student.setStudentID(Integer.parseInt(et1.getText().toString()));
                student.setStudentName(et2.getText().toString());

                new AsyncTask<Void, Void, Void>() {
                    @Override
                    protected Void doInBackground(Void... voids) {
                        db.studentDao().insert(student);
                        //Log.i("database1", "size" + students.size());
//                        runOnUiThread(new Runnable() {
//                            @Override
//                            public void run() {
//                                //displayStudent(students);
//                            }
//                        });
                        return null;
                    }
                }.execute();
            }
        });
    }


    void displayStudent(List<Student> students) {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                final List<Student> students = db.studentDao().getAll();
                for (int i =0; i< students.size(); i++){
                    System.out.println("name student: "+students.get(i).getStudentName());
                }
//               Log.i("database1", "size" + students.size());
//               runOnUiThread(new Runnable() {
//                @Override
//                    public void run() {
//                     String listStudent = "";
//                        for (int i = 0; i < students.size(); i++) {
//
//                        Student student = students.get(i);
//                        listStudent = listStudent + student.getStudentID() + student.getStudentName() + "\n";
//
//                          // rvStudent.setText(listStudent);
//                       }
//                      // displayStudent(students);
//                    }
//               });
               return null;
            }

        }.execute();


    }
}
