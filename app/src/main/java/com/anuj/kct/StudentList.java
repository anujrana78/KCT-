package com.anuj.kct;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class StudentList extends AppCompatActivity {

    RecyclerView recyView;
    MyAdapter newadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list);

        recyView = (RecyclerView) findViewById(R.id.recyclerView);
        recyView.setLayoutManager(new LinearLayoutManager(this));

                FirebaseRecyclerOptions<Students> options =
                        new FirebaseRecyclerOptions.Builder<Students>()
                                .setQuery(FirebaseDatabase.getInstance().getReference()
                                        .child("students"), Students.class)
                                .build();

                newadapter = new MyAdapter(options);

                recyView.setAdapter(newadapter);


    }
    @Override
    protected void onStart() {
        super.onStart();
        newadapter.startListening();
    }
    @Override
    protected void onStop() {
        super.onStop();
        newadapter.stopListening();
    }

}