package com.example.vision;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.textfield.TextInputEditText;

/**
 * Actividad encargada de gestionar el registro de nuevos usuarios 
 * en el módulo móvil del proyecto Vision.
 * 
 * Implementa validaciones de campos y manejo de eventos para los 
 * elementos definidos en activity_register.xml.
 * 
 * @author Elber Julián Abril Cano
 * @version 1.0
 */
public class RegisterActivity extends AppCompatActivity {

    // Declaración de componentes de la interfaz de usuario (UI)
    private ImageView btnBack;
    private TextInputEditText etName, etEmail, etPassword, etConfirmPassword;
    private Button btnRegister, btnLoginNavigate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Inicializar vistas enlazándolas con los IDs del XML
        inicializarVistas();

        // Configurar los listeners (escuchadores de eventos de clic)
        configurarEventos();
    }

    /**
     * Vincula las variables de Java con los elementos gráficos definidos en el XML.
     */
    private void inicializarVistas() {
        btnBack = findViewById(R.id.btnBack);
        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        etConfirmPassword = findViewById(R.id.etConfirmPassword);
        btnRegister = findViewById(R.id.btnRegister);
        btnLoginNavigate = findViewById(R.id.btnLoginNavigate);
    }

    /**
     * Configura la lógica de interacción para los botones de la pantalla.
     */
    private void configurarEventos() {
        // Botón de retroceso
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Cierra la actividad actual y regresa a la anterior
            }
        });

        // Botón principal de registro
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validarYRegistrar();
            }
        });

        // Botón para navegar hacia la vista de inicio de sesión
        btnLoginNavigate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Ejemplo de navegación (Asegúrate de tener creada tu LoginActivity si deseas usarlo)
                // Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                // startActivity(intent);
                Toast.makeText(RegisterActivity.this, "Redirigiendo al login...", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * Valida que los campos obligatorios estén llenos y que las contraseñas coincidan.
     */
    private void validarYRegistrar() {
        String nombre = etName.getText() != null ? etName.getText().toString().trim() : "";
        String correo = etEmail.getText() != null ? etEmail.getText().toString().trim() : "";
        String password = etPassword.getText() != null ? etPassword.getText().toString().trim() : "";
        String confirmPassword = etConfirmPassword.getText() != null ? etConfirmPassword.getText().toString().trim() : "";

        // Validar campos vacíos
        if (nombre.isEmpty() || correo.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            Toast.makeText(this, "Por favor, completa todos los campos.", Toast.LENGTH_SHORT).show();
            return;
        }

        // Validar coincidencia de contraseñas
        if (!password.equals(confirmPassword)) {
            Toast.makeText(this, "Las contraseñas no coinciden.", Toast.LENGTH_SHORT).show();
            etPassword.requestFocus();
            return;
        }

        // Simulación de registro exitoso vinculado a la lógica del proyecto
        Toast.makeText(this, "¡Registro exitoso para " + nombre + "!", Toast.LENGTH_LONG).show();
        
        // Limpiar formulario o redirigir
        limpiarCampos();
    }

    /**
     * Restablece los campos del formulario a su estado vacío.
     */
    private void limpiarCampos() {
        etName.setText("");
        etEmail.setText("");
        etPassword.setText("");
        etConfirmPassword.setText("");
        etName.requestFocus();
    }
}