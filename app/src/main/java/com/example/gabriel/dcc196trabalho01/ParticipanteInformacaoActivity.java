package com.example.gabriel.dcc196trabalho01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ParticipanteInformacaoActivity extends AppCompatActivity {

    private static final int REQUEST_EDITINFO = 1;

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
        rvListaEventosInscrito.setLayoutManager(new LinearLayoutManager(this));
        rvListaEventosInscrito.setAdapter(new ParticipanteInformacaoAdapter(ModelDAO.getEventoInstance()));
        rvListaEventosNaoInscrito = (RecyclerView) findViewById(R.id.rv_ListaEventosDisponíveis);

        final ParticipanteInformacaoAdapter adapter = new ParticipanteInformacaoAdapter(ModelDAO.getEventoInstance());
        adapter.setOnLongClickListener(new ParticipanteInformacaoAdapter.OnLongClickListener() {
            @Override
            public void onLongClickListener(View view, int position) {
                Toast.makeText(ParticipanteInformacaoActivity.this, "oi", Toast.LENGTH_SHORT).show();
            }
        });

        Bundle bundleExtras = getIntent().getExtras();
        if(bundleExtras!=null)
        {
            Integer idParticipante = bundleExtras.getInt("participante");
            Participante p = (Participante) ModelDAO.getParticipanteInstance().get(idParticipante);
            preencheInfos(p);
        }
    }

    public void preencheInfos(Participante participante)
    {
        txtNomeParticipante.setText(participante.getNome());
        txtEmailParticipante.setText(participante.getEmail());
        txtCPFParticipante.setText(participante.getCpf());
    }
}
