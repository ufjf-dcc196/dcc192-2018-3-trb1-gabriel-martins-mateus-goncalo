package com.example.gabriel.dcc196trabalho01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnParticipantes;
    private Button btnEventos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnParticipantes = findViewById(R.id.btn_participantes);
        btnEventos = findViewById(R.id.btn_eventos);
    }
}
