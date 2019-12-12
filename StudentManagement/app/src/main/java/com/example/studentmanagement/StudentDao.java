package com.example.studentmanagement;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;
@Dao
public interface StudentDao {
    @Query("SELECT * from student")
    List<Student> getAll();

    @Insert
    void insert(Student student);

    @Delete
    void delete(Student student);
}
