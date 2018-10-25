package com.example.gabriel.dcc196trabalho01;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
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
    private ParticipanteInformacaoAdapter adapter;
    private ParticipanteInformacaoAdapter adapter2;
    private List<Evento> eventosInscritos;
    private List<Evento> eventosTodos;
    private List<Evento> eventosDisponiveis;

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

        for (int i = 0; i < ModelDAO.getParticipanteInstance().size(); i++)
        {
            List<Participante> parts = ModelDAO.getParticipanteInstance();
            if (parts.get(i).getCpf().equals(participante.getCpf()))
            {
                participante = parts.get(i);
                break;
            }
        }

        eventosInscritos = participante.getEventos();
        eventosTodos = ModelDAO.getEventoInstance();

        rvListaEventosInscrito.setLayoutManager(new LinearLayoutManager(this));
        rvListaEventosNaoInscrito.setLayoutManager(new LinearLayoutManager(this));

        adapter = new ParticipanteInformacaoAdapter(eventosInscritos);
        if (participante.getEventos().size() == 0)
        {
            adapter2 = new ParticipanteInformacaoAdapter(ModelDAO.getEventoInstance());
            eventosDisponiveis = ModelDAO.getEventoInstance();
        }
        else
        {
            List<Evento> eventos3 = new ArrayList<>();
            for (int i = 0; i < ModelDAO.getEventoInstance().size(); i++)
            {
                Boolean inserir = true;
                for (int j = 0; j < participante.getEventos().size(); j++)
                {
                    if (eventosTodos.get(i).getNome().equals(participante.getEventos().get(j).getNome()))
                    {
                        inserir = false;
                    }
                }
                if (inserir)
                {
                    eventos3.add(eventosTodos.get(i));
                }
            }
            eventosDisponiveis = eventos3;
            adapter2 = new ParticipanteInformacaoAdapter(eventosDisponiveis);
        }

        adapter.setOnParticipanteLongClickListener(new ParticipanteInformacaoAdapter.OnParticipanteLongClickListener() {
            @Override
            public void onParticipanteLongClick(View participanteView, int position) {
                List<Participante> partis = new ArrayList<>();
                Evento e = eventosInscritos.get(position);
                e.setNumInscritos(e.getNumInscritos() - 1);
                for (int i = 0; i < e.getParticipanteList().size(); i++)
                {
                    if (!e.getParticipanteList().get(i).getCpf().equals(participante.getCpf()))
                    {
                        partis.add(e.getParticipanteList().get(i));
                    }
                }
                e.setParticipanteList(partis);
                List <Evento> eventosInscritos2 = new ArrayList<>();
                for (int i = 0; i < eventosInscritos.size(); i++)
                {
                    if (i != position)
                    {
                        eventosInscritos2.add(eventosInscritos.get(i));
                    }
                }
                eventosInscritos = eventosInscritos2;
                participante.setEventos(eventosInscritos);
                adapter.setEventos(eventosInscritos);
                adapter.notifyDataSetChanged();
                eventosDisponiveis = new ArrayList<>();
                for (int i = 0; i < ModelDAO.getEventoInstance().size(); i++)
                {
                    Boolean inserir = true;
                    for (int j = 0; j < participante.getEventos().size(); j++)
                    {
                        if (eventosTodos.get(i).getNome().equals(participante.getEventos().get(j).getNome()))
                        {
                            inserir = false;
                        }
                    }
                    if (inserir)
                    {
                        eventosDisponiveis.add(eventosTodos.get(i));
                    }
                }
                adapter2.setEventos(eventosDisponiveis);
                adapter2.notifyDataSetChanged();
                return;
            }
        });
        rvListaEventosInscrito.setAdapter(adapter);

        adapter2.setOnParticipanteLongClickListener(new ParticipanteInformacaoAdapter.OnParticipanteLongClickListener() {
            @Override
            public void onParticipanteLongClick(View participanteView, int position) {
                if (eventosDisponiveis.get(position).getNumInscritos()+1 <= eventosDisponiveis.get(position).getNumMaximoInscritos())
                {
                    eventosDisponiveis.get(position).setNumInscritos(eventosDisponiveis.get(position).getNumInscritos() + 1);
                    participante.getEventos().add(eventosDisponiveis.get(position));
                    eventosDisponiveis.get(position).getParticipanteList().add(participante);
                    eventosDisponiveis = new ArrayList<>();
                    for (int i = 0; i < ModelDAO.getEventoInstance().size(); i++)
                    {
                        Boolean inserir = true;
                        for (int j = 0; j < participante.getEventos().size(); j++)
                        {
                            if (eventosTodos.get(i).getNome().equals(participante.getEventos().get(j).getNome()))
                            {
                                inserir = false;
                            }
                        }
                        if (inserir)
                        {
                            eventosDisponiveis.add(eventosTodos.get(i));
                        }
                    }
                    adapter2.setEventos(eventosDisponiveis);
                    adapter2.notifyDataSetChanged();
                    adapter.notifyDataSetChanged();
                }
                else
                {
                    // Colocar mensagem de evento cheio
                }
                return;
            }
        });
        rvListaEventosNaoInscrito.setAdapter(adapter2);
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
