package com.example.studentmanagement;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Student {

    @PrimaryKey(autoGenerate = true)
    private int studentID;
    private String studentName;
    static public int soluong;
    public Student()
    {

    }
  //Hàm tạo 2 đối số
        public Student(String name)
        {
            this.studentName=name;
        }
        //Phương thức get, set

        public String getStudentName()
        {
            return studentName;
        }

        public void setStudentName(String name)
        {
            this.studentName= name;
        }
        //Trả về thông tin sinh viên
        public String toString()
        {
            return "Id:"+this.studentID+" - Name:"+this.studentName;
        }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }
}
