package com.anuj.kct;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;



public class Marksheet extends AppCompatActivity {

    Spinner spinnerSemester;
    String semesterStore;
    ListView listView;
    EditText etSymbol;
    Button search;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marksheet);

        listView = (ListView) findViewById(R.id.listView);
        etSymbol = (EditText) findViewById(R.id.editTextSymbol);
        search = (Button) findViewById(R.id.search);


        //SPinner for SEmester
        spinnerSemester = (Spinner) findViewById(R.id.spinnerSemester);

        String[] semester = getResources().getStringArray(R.array.semester_array);

        ArrayAdapter<CharSequence> adapterSemester = new ArrayAdapter(this, android.R.layout.simple_spinner_item, semester);
        adapterSemester.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSemester.setAdapter(adapterSemester);

        spinnerSemester.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedSemester = spinnerSemester.getSelectedItem().toString();

                semesterStore = selectedSemester;

                Toast.makeText(Marksheet.this, semesterStore, Toast.LENGTH_SHORT).show();


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



            search.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String symbol = etSymbol.getText().toString();


                    if(symbol.isEmpty()){
                        etSymbol.setError("Can't be empty");
                        etSymbol.requestFocus();
                        return;
                    }else {
                        Intent intent = new Intent(Marksheet.this, MarksheetList.class);
                        intent.putExtra("semesterSel", semesterStore);
                        intent.putExtra("symbolSel", symbol);
                        startActivity(intent);
                    }

                }
                });



    }
}