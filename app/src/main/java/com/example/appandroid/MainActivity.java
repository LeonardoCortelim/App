package com.example.appandroid;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appandroid.PlanetaController;
import com.example.appandroid.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private PlanetaController planetaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.idListView);

        planetaController = new PlanetaController();

        com.example.myapplication.PlanetaAdapter adapter = new com.example.myapplication.PlanetaAdapter(
                this,
                R.layout.item_lista,
                planetaController.getPlanetas()
        );

        listView.setAdapter(adapter);
    }
}
