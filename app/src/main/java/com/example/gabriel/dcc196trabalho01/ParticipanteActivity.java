package com.example.gabriel.dcc196trabalho01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;

public class ParticipanteActivity extends AppCompatActivity {

    private Button btnCadastrarParticipante;
    private RecyclerView rvListaParticipantes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_participante);

        btnCadastrarParticipante = findViewById(R.id.btn_cadastrarParticipante);
        rvListaParticipantes = findViewById(R.id.rv_listaParticipantes);
    }
}
