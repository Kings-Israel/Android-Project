package com.example.mydatabaseproject;

public class Student {
    private int studentID;
    private String studentName;

    public Student(int studentID, String studentName){
        this.studentID = studentID;
        this.studentName = studentName;
    }

    public int getStudentID(){
        return this.studentID;
    }

    public String getStudentName(){
        return this.studentName;
    }
}
