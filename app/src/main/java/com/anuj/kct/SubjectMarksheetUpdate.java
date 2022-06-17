package com.anuj.kct;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

public class SubjectMarksheetUpdate extends AppCompatActivity {


    Spinner spinnerSemester;
     String semester;
    TextView sub1,sub2,sub3,sub4,sub5;
    EditText subject1,subject2,subject3,subject4,subject5;
    EditText symbol;
    Button update;
    String semesterStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject_marksheet_update);


        update = findViewById(R.id.updatebtn);
        sub1 = findViewById(R.id.textViewSubject1);
        sub2 = findViewById(R.id.textViewSubject2);
        sub3 = findViewById(R.id.textViewSubject3);
        sub4 = findViewById(R.id.textViewSubject4);
        sub5 = findViewById(R.id.textViewSubject5);

        subject1 = (EditText) findViewById(R.id.editTextSub1);
        subject2 = (EditText) findViewById(R.id.editTextSub2);
        subject3 = (EditText) findViewById(R.id.editTextSub3);
        subject4 = (EditText) findViewById(R.id.editTextSub4);
        subject5 = (EditText) findViewById(R.id.editTextSub5);

        symbol = (EditText) findViewById(R.id.editTextSymbol);






        // SPINNER FOR SEMESTER
       spinnerSemester = (Spinner) findViewById(R.id.spinnerSemester);

        String[] semester = getResources().getStringArray(R.array.semester_array);

        ArrayAdapter<CharSequence> adapterSemester = new ArrayAdapter(this,android.R.layout.simple_spinner_item,semester);
        adapterSemester.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSemester.setAdapter(adapterSemester);

        spinnerSemester.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedSemester = spinnerSemester.getSelectedItem().toString();
                Toast.makeText(SubjectMarksheetUpdate.this, selectedSemester, Toast.LENGTH_SHORT).show();
                semesterStore = selectedSemester;


                if(selectedSemester.equalsIgnoreCase("1")) {
                    sub1.setText("Computer Fundamental");
                    sub2.setText("Digital Logics");
                    sub3.setText("English-I");
                    sub4.setText("Society & Technology");
                    sub5.setText("Mathematics I");
                }
                if(selectedSemester.equalsIgnoreCase("2")) {
                    sub1.setText("C Programming");
                    sub2.setText("Financial Accounting");
                    sub3.setText("English II");
                    sub4.setText("Mathematics II");
                    sub5.setText("Microprocessor");
                }
                if(selectedSemester.equalsIgnoreCase("3")) {
                    sub1.setText("Data Structure");
                    sub2.setText("Probability & Statistics");
                    sub3.setText("System Analysis & Design");
                    sub4.setText("OOP in JAVA");
                    sub5.setText("Web Technology");
                }if(selectedSemester.equalsIgnoreCase("4")) {
                    sub1.setText("Opertaing System");
                    sub2.setText("Numerical Methods");
                    sub3.setText("Software Engineering");
                    sub4.setText("DBMS");
                    sub5.setText("Scripting Language");
                }if(selectedSemester.equalsIgnoreCase("5")) {
                    sub1.setText("MIS & E-Business");
                    sub2.setText("DotNet Technology");
                    sub3.setText("Computer Networking");
                    sub4.setText("Intro to Management");
                    sub5.setText("Computer Graphics");
                }if(selectedSemester.equalsIgnoreCase("6")) {
                    sub1.setText("Mobile Programming");
                    sub2.setText("Distributed System");
                    sub3.setText("Applied Economics");
                    sub4.setText("Advanced Java");
                    sub5.setText("Network Programming");
                }if(selectedSemester.equalsIgnoreCase("7")) {
                    sub1.setText("Cyber Law & Ethics");
                    sub2.setText("Cloud Computing");
                    sub3.setText("Internship");
                    sub4.setText("ELective I");
                    sub5.setText("Elective II");
                }if(selectedSemester.equalsIgnoreCase("8")) {
                    sub1.setText("Operation Research");
                    sub2.setText("Project III");
                    sub3.setText("Elective III");
                    sub4.setText("ELective IV");
                    sub5.setText("");
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String symbolStored;
                symbolStored = symbol.getText().toString();

                update.setText(symbolStored);


                String subject1Store = subject1.getText().toString();
                String subject2Store = subject2.getText().toString();
                String subject3Store = subject3.getText().toString();
                String subject4Store = subject4.getText().toString();
                String subject5Store = subject5.getText().toString();

                if(semesterStore.equalsIgnoreCase("1")) {
                    FirebaseDatabase.getInstance().getReference("students").child(symbolStored).child("Semester").child("1")
                            .child("Subject").child("Computer Fundamental").setValue(subject1Store);
                    FirebaseDatabase.getInstance().getReference("students").child(symbolStored).child("Semester").child("1")
                            .child("Subject").child("Digital Logic").setValue(subject2Store);
                    FirebaseDatabase.getInstance().getReference("students").child(symbolStored).child("Semester").child("1")
                            .child("Subject").child("English-I").setValue(subject3Store);
                    FirebaseDatabase.getInstance().getReference("students").child(symbolStored).child("Semester").child("1")
                            .child("Subject").child("Society & Technology").setValue(subject4Store);
                    FirebaseDatabase.getInstance().getReference("students").child(symbolStored).child("Semester").child("1")
                            .child("Subject").child("Mathematics-I").setValue(subject5Store);
                }  else if(semesterStore.equalsIgnoreCase("2")) {
                    FirebaseDatabase.getInstance().getReference("students").child(symbolStored).child("Semester").child("2")
                            .child("Subject").child("cc").setValue(subject1Store);
                    FirebaseDatabase.getInstance().getReference("students").child(symbolStored).child("Semester").child("2")
                            .child("Subject").child("Digital Logic").setValue(subject2Store);
                    FirebaseDatabase.getInstance().getReference("students").child(symbolStored).child("Semester").child("2")
                            .child("Subject").child("English-I").setValue(subject3Store);
                    FirebaseDatabase.getInstance().getReference("students").child(symbolStored).child("Semester").child("2")
                            .child("Subject").child("Society & Technology").setValue(subject4Store);
                    FirebaseDatabase.getInstance().getReference("students").child(symbolStored).child("Semester").child("2")
                            .child("Subject").child("Mathematics-I").setValue(subject5Store);
                } else if(semesterStore.equalsIgnoreCase("3")) {
                    FirebaseDatabase.getInstance().getReference("students").child(symbolStored).child("Semester").child("3")
                            .child("Subject").child("Data Structure").setValue(subject1Store);
                    FirebaseDatabase.getInstance().getReference("students").child(symbolStored).child("Semester").child("3")
                            .child("Subject").child("Probability & Statistics").setValue(subject2Store);
                    FirebaseDatabase.getInstance().getReference("students").child(symbolStored).child("Semester").child("3")
                            .child("Subject").child("System Analysis & Design").setValue(subject3Store);
                    FirebaseDatabase.getInstance().getReference("students").child(symbolStored).child("Semester").child("3")
                            .child("Subject").child("OOP in JAVA").setValue(subject4Store);
                    FirebaseDatabase.getInstance().getReference("students").child(symbolStored).child("Semester").child("3")
                            .child("Subject").child("Web Technology").setValue(subject5Store);

                } else if(semesterStore.equalsIgnoreCase("4")) {
                    FirebaseDatabase.getInstance().getReference("students").child(symbolStored).child("Semester").child("4")
                            .child("Subject").child("Operating System").setValue(subject1Store);
                    FirebaseDatabase.getInstance().getReference("students").child(symbolStored).child("Semester").child("4")
                            .child("Subject").child("Numerical Methods").setValue(subject2Store);
                    FirebaseDatabase.getInstance().getReference("students").child(symbolStored).child("Semester").child("4")
                            .child("Subject").child("Software Engineering").setValue(subject3Store);
                    FirebaseDatabase.getInstance().getReference("students").child(symbolStored).child("Semester").child("4")
                            .child("Subject").child("DBMS").setValue(subject4Store);
                    FirebaseDatabase.getInstance().getReference("students").child(symbolStored).child("Semester").child("4")
                            .child("Subject").child("Scripting Language").setValue(subject5Store);
                } else if(semesterStore.equalsIgnoreCase("5")) {
                    FirebaseDatabase.getInstance().getReference("students").child(symbolStored).child("Semester").child("5")
                            .child("Subject").child("MIS & E-business").setValue(subject1Store);
                    FirebaseDatabase.getInstance().getReference("students").child(symbolStored).child("Semester").child("5")
                            .child("Subject").child("Dotnet Technology").setValue(subject2Store);
                    FirebaseDatabase.getInstance().getReference("students").child(symbolStored).child("Semester").child("5")
                            .child("Subject").child("Computer Networking").setValue(subject3Store);
                    FirebaseDatabase.getInstance().getReference("students").child(symbolStored).child("Semester").child("5")
                            .child("Subject").child("Intro to Management").setValue(subject4Store);
                    FirebaseDatabase.getInstance().getReference("students").child(symbolStored).child("Semester").child("5")
                            .child("Subject").child("Computer Graphics").setValue(subject5Store);
                } else if(semesterStore.equalsIgnoreCase("6")) {
                    FirebaseDatabase.getInstance().getReference("students").child(symbolStored).child("Semester").child("6")
                            .child("Subject").child("Mobile Programming").setValue(subject1Store);
                    FirebaseDatabase.getInstance().getReference("students").child(symbolStored).child("Semester").child("6")
                            .child("Subject").child("Distributed System").setValue(subject2Store);
                    FirebaseDatabase.getInstance().getReference("students").child(symbolStored).child("Semester").child("6")
                            .child("Subject").child("Applied Economics").setValue(subject3Store);
                    FirebaseDatabase.getInstance().getReference("students").child(symbolStored).child("Semester").child("6")
                            .child("Subject").child("Advanced Java").setValue(subject4Store);
                    FirebaseDatabase.getInstance().getReference("students").child(symbolStored).child("Semester").child("6")
                            .child("Subject").child("Network Programming").setValue(subject5Store);
                } else if(semesterStore.equalsIgnoreCase("7")) {
                    FirebaseDatabase.getInstance().getReference("students").child(symbolStored).child("Semester").child("7")
                            .child("Subject").child("Cyber Law & Ethics").setValue(subject1Store);
                    FirebaseDatabase.getInstance().getReference("students").child(symbolStored).child("Semester").child("7")
                            .child("Subject").child("Cloud computing").setValue(subject2Store);
                    FirebaseDatabase.getInstance().getReference("students").child(symbolStored).child("Semester").child("7")
                            .child("Subject").child("Internship").setValue(subject3Store);
                    FirebaseDatabase.getInstance().getReference("students").child(symbolStored).child("Semester").child("7")
                            .child("Subject").child("Elective-I").setValue(subject4Store);
                    FirebaseDatabase.getInstance().getReference("students").child(symbolStored).child("Semester").child("7")
                            .child("Subject").child("Elective-II").setValue(subject5Store);
                } else if(semesterStore.equalsIgnoreCase("8")) {
                    FirebaseDatabase.getInstance().getReference("students").child(symbolStored).child("Semester").child("8")
                            .child("Subject").child("Operation Research").setValue(subject1Store);
                    FirebaseDatabase.getInstance().getReference("students").child(symbolStored).child("Semester").child("8")
                            .child("Subject").child("Project-III").setValue(subject2Store);
                    FirebaseDatabase.getInstance().getReference("students").child(symbolStored).child("Semester").child("8")
                            .child("Subject").child("Electvie III").setValue(subject3Store);
                    FirebaseDatabase.getInstance().getReference("students").child(symbolStored).child("Semester").child("8")
                            .child("Subject").child("Elective-IV").setValue(subject4Store);
                }


            }
        });







    }
}