package com.example.gabriel.dcc196trabalho01;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import static com.example.gabriel.dcc196trabalho01.R.layout.participantes_layout;

public class EventoAdapter extends RecyclerView.Adapter<EventoAdapter.ViewHolder>{

    private List<Evento> eventoList;
    private OnItemClickListener listener;

    public interface OnItemClickListener{
        void onItemClick(View view, int position);
    }

    public void setOnClickListener(OnItemClickListener listener)
    {
        this.listener = listener;
    }

    public EventoAdapter (List<Evento> eventos)
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

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        public TextView nomeEvento;

        public ViewHolder (final View eventoView)
        {
            super(eventoView);
            nomeEvento = (TextView)eventoView.findViewById(R.id.txtEventoNome);
            eventoView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener != null)
                    {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION)
                        {
                            listener.onItemClick(eventoView, position);
                        }
                    }
                }
            });
        }

        @Override
        public void onClick(View v)
        {
            int position = getAdapterPosition();
            if (position != RecyclerView.NO_POSITION)
            {
                listener.onItemClick(v, position);
            }
        }
    }
}
