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

        Log.d("TESTE", "INTENT: " + intent.toString());

        var num = intent.getIntExtra("NUMERO", 1);

        Log.d("TESTE", "NUMERO: " + num);

        var tabuada = gerarTabuada(num);

        Log.d("TESTE", "TABUADA: " + tabuada);

        tvresultado.setText(tabuada);
    }

    private String gerarTabuada(int numero) {
        var stringBuilderTabuada = new StringBuilder();

        for (int i = 1; i <= numero; i++) {
            stringBuilderTabuada.append(numero).append(" X ").append(i).append(" = ").append(i * numero);
            stringBuilderTabuada.append("\n");
        }

        return stringBuilderTabuada.toString();
    }
}