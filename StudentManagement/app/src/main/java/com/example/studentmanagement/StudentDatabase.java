package com.example.studentmanagement;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Student.class}, version = 4)
public abstract class StudentDatabase extends RoomDatabase {
    abstract StudentDao studentDao();


}
