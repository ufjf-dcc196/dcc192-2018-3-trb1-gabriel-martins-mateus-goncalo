package com.example.gabriel.dcc196trabalho01;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class ParticipanteActivity extends AppCompatActivity {

    private static final int REQUEST_CADPARTICIPANTE = 1;

    private Button btnCadastrarParticipante;
    private RecyclerView rvListaParticipantes;
    private TextView txtTotalParticipantes;

    private int totalParticipantes = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_participante);

        btnCadastrarParticipante = findViewById(R.id.btn_cadastrarParticipante);
        rvListaParticipantes = findViewById(R.id.rv_listaParticipantes);
        txtTotalParticipantes = findViewById(R.id.txt_totalParticipantes);

        ArrayList<Participante> participantes = new ArrayList<>();
        ParticipanteAdapter adapter = new ParticipanteAdapter();
        rvListaParticipantes.setAdapter(adapter);
        rvListaParticipantes.setLayoutManager(new LinearLayoutManager(this));

        btnCadastrarParticipante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ParticipanteActivity.this, CadastroParticipanteActivity.class);
                startActivityForResult(intent, ParticipanteActivity.REQUEST_CADPARTICIPANTE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == ParticipanteActivity.REQUEST_CADPARTICIPANTE && resultCode == Activity.RESULT_OK){
            totalParticipantes++;
            txtTotalParticipantes.setText("Total de Participantes: " + totalParticipantes);
        }
    }
}
