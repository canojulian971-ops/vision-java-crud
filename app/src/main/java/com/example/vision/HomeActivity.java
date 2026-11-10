package com.example.vision;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Set up menu item clicks
        findViewById(R.id.menuSearchRoute).setOnClickListener(v -> 
            startActivity(new Intent(this, SearchRouteActivity.class))
        );

        findViewById(R.id.menuNearbyStops).setOnClickListener(v -> 
            showToast("Paradas cercanas seleccionado")
        );

        findViewById(R.id.menuNotifications).setOnClickListener(v -> 
            showToast("Notificaciones seleccionado")
        );

        findViewById(R.id.menuProfile).setOnClickListener(v -> 
            showToast("Mi perfil seleccionado")
        );

        findViewById(R.id.btnHelp).setOnClickListener(v -> 
            showToast("¿Necesitas ayuda? seleccionado")
        );
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}