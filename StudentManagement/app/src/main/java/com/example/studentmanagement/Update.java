package com.example.studentmanagement;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

public class Update extends AppCompatActivity {
    StudentDatabase db;
    EditText editName;
    Button btnUpdate;
    int todoId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_main);

        db = Room.databaseBuilder(getApplicationContext(),
                StudentDatabase.class, "database-name").build();

        editName = findViewById(R.id.editName);
        btnUpdate = findViewById(R.id.btnUpdate);

        int id = getIntent().getIntExtra("id", 0);
        todoId = id;
        String name = getIntent().getStringExtra("name");

        editName.setText(name);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // updateStudent();
            }
        });

    }
}
