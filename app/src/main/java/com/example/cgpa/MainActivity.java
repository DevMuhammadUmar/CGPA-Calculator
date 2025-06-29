package com.example.cgpa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    TextInputEditText etCGPA, etGPA, etSemester;
    Button btnCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Input Validation
                if (etCGPA.getText().toString().trim().isEmpty() ||
                        etGPA.getText().toString().trim().isEmpty() ||
                        etSemester.getText().toString().trim().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                    return; // Stop if fields are not filled
                }

                // Exception Handling within try-catch
                try {
                    double Cgpa = Double.parseDouble(etCGPA.getText().toString().trim());
                    double gpa = Double.parseDouble(etGPA.getText().toString().trim());
                    double sem = Double.parseDouble(etSemester.getText().toString().trim());

                    double a = Cgpa * (sem - 1);
                    double b = a + gpa;
                    double Result = b / sem;

                    Intent intent = new Intent(MainActivity.this, com.example.cgpa.Result.class);
                    intent.putExtra("Result", Result);
                    startActivity(intent);

                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "Invalid Input. Please enter numbers only.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void init() {
        etCGPA = findViewById(R.id.etCGPA);
        etGPA = findViewById(R.id.etGPA);
        etSemester = findViewById(R.id.etSemester);
        btnCalculate = findViewById(R.id.btnCalculate);
    }
}
