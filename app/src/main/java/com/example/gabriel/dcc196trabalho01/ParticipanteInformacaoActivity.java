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
import android.widget.Toast;

import java.util.List;

public class ParticipanteInformacaoActivity extends AppCompatActivity {

    private static final int REQUEST_EDITINFO = 1;
    private Participante participante;

    private Button btnEditarInformacoes;
    private RecyclerView rvListaEventosInscrito;
    private RecyclerView rvListaEventosNaoInscrito;
    private TextView txtNomeParticipante;
    private TextView txtEmailParticipante;
    private TextView txtCPFParticipante;
    private TextView txtEventoCadastrados;
    private TextView txtEventosNaoCadastrados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_participante_informacao);

        btnEditarInformacoes = (Button) findViewById(R.id.btn_EditInfo2);
        txtNomeParticipante = findViewById(R.id.txt_NomeParticipanteInfo2);
        txtCPFParticipante = findViewById(R.id.txt_CPFParticipanteInfo2);
        txtEmailParticipante = findViewById(R.id.txt_EmailParticipanteInfo2);
        txtEventoCadastrados = findViewById(R.id.txt_EventosCadastrados2);
        txtEventosNaoCadastrados = findViewById(R.id.txt_EventosDisponiveis2);
        rvListaEventosInscrito = (RecyclerView) findViewById(R.id.rv_ListaEventosCadastrados);
        rvListaEventosNaoInscrito = (RecyclerView) findViewById(R.id.rv_ListaEventosDisponíveis);


        Intent intent = getIntent();
        participante = (Participante) intent.getSerializableExtra("participante");

        txtNomeParticipante.setText("Nome: " +participante.getNome());
        txtEmailParticipante.setText("Email: " + participante.getEmail());
        txtCPFParticipante.setText("CPF: " + participante.getCpf());

        btnEditarInformacoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ParticipanteInformacaoActivity.this, ParticipanteEditActivity.class);
                intent.putExtra("participante", participante);
                startActivityForResult(intent, ParticipanteInformacaoActivity.REQUEST_EDITINFO);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == ParticipanteInformacaoActivity.REQUEST_EDITINFO && resultCode == Activity.RESULT_OK){
            Participante p = (Participante) data.getSerializableExtra("participante");
            List<Participante> participanteList = ModelDAO.getParticipanteInstance();
            for (Participante parts: participanteList) {
                if (parts.getNome().equals(participante.getNome()) && parts.getCpf().equals(participante.getCpf()) && parts.getEmail().equals(participante.getEmail()))
                {
                    parts.setNome(p.getNome());
                    parts.setCpf(p.getCpf());
                    parts.setEmail(p.getEmail());
                    txtNomeParticipante.setText("Nome: " +p.getNome());
                    txtEmailParticipante.setText("Email: " + p.getEmail());
                    txtCPFParticipante.setText("CPF: " + p.getCpf());
                    break;
                }
            }
        }
    }
}
