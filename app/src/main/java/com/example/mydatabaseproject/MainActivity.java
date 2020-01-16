package com.example.mydatabaseproject;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText studentID, studentName;
    Button add, delete, load;
    ListView listDetails;
    Cursor cursor;
    listAdapter listAdapter;
    Context thisContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        studentID = findViewById(R.id.studentid);
        studentName = findViewById(R.id.studentname);

        add = findViewById(R.id.btnadd);
        delete = findViewById(R.id.btndelete);
        load = findViewById(R.id.loadbtn);
        listDetails = findViewById(R.id.detailList);

        load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadstudents(v);
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addStudent(v);
            }
        });

    }

    public void loadstudents(View view){
        MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);
        dbHandler.getWritableDatabase();

        studentID.setText("");
        studentName.setText("");
    }

    public void addStudent(View view) {
        MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);
        int id = Integer.parseInt(studentID.getText().toString());
        String name = studentName.getText().toString();
        Student student = new Student(id, name);
        dbHandler.addHandler(student);
        studentID.setText("");
        studentName.setText("");
    }
}
