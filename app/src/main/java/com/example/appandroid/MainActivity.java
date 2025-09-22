package com.example.appandroid;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText texto;
    Button gerar;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        texto = findViewById(R.id.texto);
        gerar = findViewById(R.id.gerar);

        gerar.setOnClickListener(v -> {
            var numero = 0;
            try {
                numero = Integer.parseInt(texto.getText().toString());
            } catch (Exception e) {
                System.out.println(e.toString());
            }
            var intent = new Intent(this, ActivityResultado.class);
            intent.putExtra("numero", numero);
            startActivity(intent);
        });
    }
}