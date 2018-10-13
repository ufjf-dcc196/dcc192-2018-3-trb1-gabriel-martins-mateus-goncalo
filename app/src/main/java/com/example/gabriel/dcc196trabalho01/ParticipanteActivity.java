package com.example.gabriel.dcc196trabalho01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ParticipanteActivity extends AppCompatActivity {

    private static final int REQUEST_CADPARTICIPANTE = 1;

    private Button btnCadastrarParticipante;
    private RecyclerView rvListaParticipantes;
    private TextView txtTotalParticipantes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_participante);

        btnCadastrarParticipante = findViewById(R.id.btn_cadastrarParticipante);
        rvListaParticipantes = findViewById(R.id.rv_listaParticipantes);
        txtTotalParticipantes = findViewById(R.id.txt_totalParticipantes);

        btnCadastrarParticipante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ParticipanteActivity.this, CadastroParticipanteActivity.class);
                startActivityForResult(intent, ParticipanteActivity.REQUEST_CADPARTICIPANTE);
            }
        });
    }
}
