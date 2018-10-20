package com.example.gabriel.dcc196trabalho01;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class ParticipanteInformacaoAdapter extends RecyclerView.Adapter<ParticipanteInformacaoAdapter.ViewHolder>{

    private List<Evento> eventoList;
    private OnLongClickListener listener;

    public interface OnLongClickListener{
        void onLongClickListener(View view, int position);
    }

    public void setOnLongClickListener(OnLongClickListener listener)
    {
        this.listener = listener;
    }

    public ParticipanteInformacaoAdapter (List<Evento> eventos)
    {
        this.eventoList = eventos;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View eventoView = inflater.inflate(R.layout.eventos_layout, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(eventoView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.nomeEvento.setText(eventoList.get(i).getNome());
    }

    @Override
    public int getItemCount() {
        return eventoList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnLongClickListener
    {
        public TextView nomeEvento;

        public ViewHolder (final View eventoView)
        {
            super(eventoView);
            nomeEvento = (TextView)eventoView.findViewById(R.id.txtEventoNome);
            eventoView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onLongClickListener(eventoView, position);
                        }
                    }
                    return false;
                }
            });

        }

        @Override
        public boolean onLongClick(View v) {
            int position = getAdapterPosition();
            if (position != RecyclerView.NO_POSITION)
            {
                listener.onLongClickListener(v, position);
            }
            return true;
        }
    }
}


