package com.example.studentmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
      ListView listView;
      EditText et1, et2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                // TODO Auto-generated method stub

                Student sv_click= (Student) arg0.getItemAtPosition(arg2);
                et1.setText(sv_click.getStudentID()+"");
                et2.setText(sv_click.getStudentName());
            }
        });
    }
    public Student findStudentById(int id, ArrayList<Student> listStudent)
    {
        for (Student std : listStudent) {
            if(std.getStudentID()==id)
                return std;
        }
        return null;
    }
}
