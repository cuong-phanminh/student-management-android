package com.example.studentmanagement;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Student {
    @PrimaryKey()
    private int studentID;
    private String studentName;
    static public int soluong;

        //Hàm tạo không đối số

        public Student()
        {

            studentID=0;
            studentName="";
        }
        //Hàm tạo 2 đối số
        public Student(int id, String name)
        {
            studentID=id;
            studentName=name;
        }
        //Phương thức get, set
        public int getStudentID()
        {
            return studentID;
        }
        public String getStudentName()
        {
            return studentName;
        }
        public void setStudentID(int id)
        {
            this.studentID= id;
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
}
