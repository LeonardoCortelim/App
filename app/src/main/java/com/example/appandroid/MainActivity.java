package com.example.appandroid;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase db;
    Button button;
    EditText editText;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        // Correct resource reference
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.buttonSalvar);
        editText = findViewById(R.id.editTextText);
        listView = findViewById(R.id.listView);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        db = openOrCreateDatabase("app_database", MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS notas (id INTEGER PRIMARY KEY AUTOINCREMENT, titulo VARCHAR, txt TEXT)");

        carregarListagem();

        button.setOnClickListener(v -> {
            String titulo = editText.getText().toString();

            ContentValues cv = new ContentValues();
            cv.put("titulo", titulo);

            db.insert("notas", null, cv);

            carregarListagem();
        });

        listView.setOnItemClickListener((parent,view,position,id) -> {
            String titulo = (String) parent.getItemAtPosition(position);
            Intent intent = new Intent(MainActivity.this, ExibeItem.class);
            intent.putExtra("titulo",titulo);
            startActivity(intent);

        });

    }

    private void carregarListagem() {
        Cursor cursor = db.rawQuery("SELECT * FROM notas", null);

        ArrayList<String> titulos = new ArrayList<>();

        if (cursor.moveToFirst()) {
            do {
                int columnIndex = cursor.getColumnIndex("titulo");
                if (columnIndex >= 0) {
                    titulos.add(cursor.getString(columnIndex));
                }
            } while (cursor.moveToNext());
        }

        cursor.close();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                titulos
        );

        listView.setAdapter(adapter);
    }
}
