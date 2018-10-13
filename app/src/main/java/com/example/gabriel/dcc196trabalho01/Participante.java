package com.example.gabriel.dcc196trabalho01;

import java.util.List;

public class Participante {

    private String nome;
    private List<Evento> eventos;

    public Participante(String nome, List<Evento> eventos) {
        this.nome = nome;
        this.eventos = eventos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }
}
