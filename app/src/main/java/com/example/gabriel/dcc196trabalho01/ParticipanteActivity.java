package com.example.gabriel.dcc196trabalho01;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

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
        txtTotalParticipantes = findViewById(R.id.txt_totalParticipantes);

        List<Participante> participantes = new ArrayList<>();
        Participante p1 = new Participante("Mateus", "mateusgon57@gmail.com", "00000000000", null);
        Participante p2 = new Participante("Gabriel", "gabrielmsanta97@gmail.com", "00000000000", null);
        participantes.add(p1);
        participantes.add(p2);

        rvListaParticipantes = (RecyclerView) findViewById(R.id.rv_listaParticipantes);
        rvListaParticipantes.setLayoutManager(new LinearLayoutManager(this));
        rvListaParticipantes.setAdapter(new ParticipanteAdapter(ModelDAO.getParticipanteInstance()));

        final ParticipanteAdapter adapter = new ParticipanteAdapter(ModelDAO.getParticipanteInstance());

        int total = ModelDAO.getParticipanteInstance().size();
        txtTotalParticipantes.setText("Total de Participantes: " + total);

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
            int total = ModelDAO.getParticipanteInstance().size();
            txtTotalParticipantes.setText("Total de Participantes: " + total);
        }
        List<Participante> participantes = ModelDAO.getParticipanteInstance();
        ParticipanteAdapter adapter = new ParticipanteAdapter(participantes);
        rvListaParticipantes.setAdapter(adapter);
        rvListaParticipantes.setLayoutManager(new LinearLayoutManager(this));
    }
}
