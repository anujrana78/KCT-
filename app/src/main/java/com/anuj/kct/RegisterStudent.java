package com.anuj.kct;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthEmailException;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterStudent extends AppCompatActivity {

    EditText etFullname, etSymbol, etPassword, etEmail,etsemester;
    Button btnRegister;
    String selFaculty,selSemester,selBatch;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_student);
        getWindow().setFlags( WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        mAuth = FirebaseAuth.getInstance();

        etFullname = (EditText) findViewById(R.id.editTextFullName);
        etSymbol = (EditText) findViewById(R.id.editTextSymbol);
        btnRegister = (Button) findViewById(R.id.buttonRegisterUser);

        // SPINNER FOR FACULTY
        Spinner spinnerFaculty = (Spinner) findViewById(R.id.spinnerFaculty);

        String[] faculty = getResources().getStringArray(R.array.faculty_array);

        ArrayAdapter<CharSequence> adapterFaculty = new ArrayAdapter(this,android.R.layout.simple_spinner_item,faculty);
        adapterFaculty.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerFaculty.setAdapter(adapterFaculty);

        spinnerFaculty.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedFaculty = spinnerFaculty.getSelectedItem().toString();
                Toast.makeText(RegisterStudent.this, selectedFaculty, Toast.LENGTH_SHORT).show();
                selFaculty = selectedFaculty;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        // SPINNER FOR SEMESTER
        Spinner spinnerSemester = (Spinner) findViewById(R.id.spinnerSemester);

        String[] semester = getResources().getStringArray(R.array.semester_array);

        ArrayAdapter<CharSequence> adapterSemester = new ArrayAdapter(this,android.R.layout.simple_spinner_item,semester);
        adapterSemester.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSemester.setAdapter(adapterSemester);

        spinnerSemester.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedSemester = spinnerSemester.getSelectedItem().toString();
                Toast.makeText(RegisterStudent.this, selectedSemester, Toast.LENGTH_SHORT).show();
                selSemester = selectedSemester;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        // SPINNER FOR BATCH
        Spinner spinnerBatch = (Spinner) findViewById(R.id.spinnerBatch);

        String[] batch = getResources().getStringArray(R.array.batch_array);

        ArrayAdapter<CharSequence> adapterBatch = new ArrayAdapter(this,android.R.layout.simple_spinner_item,batch);
        adapterBatch.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerBatch.setAdapter(adapterBatch);

        spinnerBatch.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedBatch = spinnerBatch.getSelectedItem().toString();
                selBatch = selectedBatch;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });





        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerUser();
            }
        });



    }


    public void registerUser() {
        String fullName = etFullname.getText().toString().trim();
        String symbol = etSymbol.getText().toString().trim();
        String semester = selSemester;
        String faculty = selFaculty;


        if (fullName.isEmpty()) {
            etFullname.setError("First Name is required");
            etFullname.requestFocus();
            return;
        }
        if (symbol.isEmpty()) {
            etSymbol.setError("Last Name is required");
            etSymbol.requestFocus();
            return;
        }




                            Students students = new Students(fullName,symbol,faculty,semester);

                            FirebaseDatabase.getInstance().getReference("students").child(symbol)
                                    .setValue(students).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {

                                    if (task.isSuccessful()) {
                                        etFullname.setText("");
                                        etPassword.setText("");
                                        etEmail.setText("");
                                        etSymbol.setText("");



                                        Toast.makeText(getApplicationContext(), "Account Created", Toast.LENGTH_SHORT).show();


                                    } else {
                                        Toast.makeText(RegisterStudent.this, "Failed to register! Try Again", Toast.LENGTH_LONG).show();

                                    }
                                }
                            });


    }}


