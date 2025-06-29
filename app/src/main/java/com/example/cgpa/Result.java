package com.example.cgpa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Result extends AppCompatActivity {

    TextView tvCGPA,tvComment,tvQ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        tvCGPA = findViewById(R.id.tvCGPA);
        tvComment = findViewById(R.id.tvComment);
        tvQ = findViewById(R.id.tvQ);


        Intent intent = getIntent();
        double result = intent.getDoubleExtra("Result", 0.0); // Use 0.0 as a default

        if (result>=2.8 && result<=3.3){
            tvComment.setText("Satisfactory");
            tvQ.setText("\"Don't give up on what you want most for what you want now.\"");
        } else if (result>3.3 && result<=3.6) {
            tvComment.setText("Good");
            tvQ.setText("\"It does not matter how slowly you go as long as you do not stop.\" ");
        } else if (result>3.6 && result<=3.8) {
            tvComment.setText("Excellent");
            tvQ.setText("\"Believe in yourself, and the rest will fall into place.\"");
        }
        else if (result>3.8 && result<=4.0) {
            tvComment.setText("Brilliant");
            tvQ.setText("\"The only way to do great work is to love what you do.” ");
        }
        String formattedResult = String.format("%.2f", result);

        // Display the formatted result
        tvCGPA.setText(formattedResult);
    }
}