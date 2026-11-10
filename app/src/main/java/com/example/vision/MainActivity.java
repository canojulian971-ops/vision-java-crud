package com.example.vision;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        findViewById(R.id.btnLogin).setOnClickListener(v -> 
            startActivity(new Intent(this, HomeActivity.class))
        );

        findViewById(R.id.btnCreateAccount).setOnClickListener(v -> 
            startActivity(new Intent(this, RegisterActivity.class))
        );

        findViewById(R.id.tvForgotPassword).setOnClickListener(v -> 
            Toast.makeText(this, "Forgot Password clicked", Toast.LENGTH_SHORT).show()
        );
    }
}