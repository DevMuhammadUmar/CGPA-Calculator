package com.example.cgpa;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Splash extends AppCompatActivity {

    private static final int SPLASH_DISPLAY_LENGTH = 2000; // Duration of the splash screen in milliseconds (2 seconds)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Create a new Handler to transition to MainActivity after the splash display duration
        new Handler().postDelayed(() -> {
            // Start MainActivity
            Intent mainIntent = new Intent(Splash.this, MainActivity.class);
            startActivity(mainIntent);
            // Finish Splash activity so user can't return to it using the back button
            finish();
        }, SPLASH_DISPLAY_LENGTH);
    }
}
