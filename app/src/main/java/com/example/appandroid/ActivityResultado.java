package com.example.appandroid;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class ActivityResultado extends AppCompatActivity {

    TextView tvresultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_resultado);

        tvresultado = findViewById(R.id.tvresultado);
        var intent = getIntent();
        var num = intent.getIntExtra("numero", 1);
    }
}