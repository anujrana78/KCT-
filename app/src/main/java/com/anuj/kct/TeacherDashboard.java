package com.anuj.kct;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class TeacherDashboard extends AppCompatActivity   {

    CardView registerStudent,updateMarksheet,viewStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_dashboard);

        registerStudent = (CardView) findViewById(R.id.cardViewRegisterStudent);
        updateMarksheet = (CardView) findViewById(R.id.cardViewUpdateMarksheet);
        viewStudent = (CardView) findViewById(R.id.cardViewViewStudentInfo);


        registerStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TeacherDashboard.this,RegisterStudent.class));
            }
        });

        updateMarksheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TeacherDashboard.this,SubjectMarksheetUpdate.class));
            }
        });

        viewStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TeacherDashboard.this,StudentList.class));
            }
        });
    }
}