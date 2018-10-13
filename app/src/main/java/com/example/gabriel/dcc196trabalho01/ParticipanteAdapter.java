package com.example.gabriel.dcc196trabalho01;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class ParticipanteAdapter extends RecyclerView.Adapter<ParticipanteAdapter.ViewHolder>{

    private List<Participante> participanteList;

    public ParticipanteAdapter (List<Participante> participantes)
    {
        this.participanteList = participantes;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View participanteView = inflater.inflate(R.layout.viewparticipantes, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(participanteView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        String nome = participanteList.get(i).getNome();
        TextView participanteNome = viewHolder.nomeParticipante;
        participanteNome.setText(nome);
    }

    @Override
    public int getItemCount() {
        return participanteList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        public TextView nomeParticipante;

        public ViewHolder (final View participanteView)
        {
            super(participanteView);
            nomeParticipante = (TextView)participanteView.findViewById(R.id.txtNomeParticipante);
        }
    }
}
