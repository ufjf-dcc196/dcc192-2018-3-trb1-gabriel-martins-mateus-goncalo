package com.example.gabriel.dcc196trabalho01;

import java.util.List;

public class Evento {

    private String nome;
    private List<Participante> participanteList;
    private Integer numMaximoInscritos;
    private Integer numInscritos;

    public Evento() {
    }

    public Evento(String nome, List<Participante> participanteList, Integer numMaximoInscritos, Integer numInscritos) {
        this.nome = nome;
        this.participanteList = participanteList;
        this.numMaximoInscritos = numMaximoInscritos;
        this.numInscritos = numInscritos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Participante> getParticipanteList() {
        return participanteList;
    }

    public void setParticipanteList(List<Participante> participanteList) {
        this.participanteList = participanteList;
    }

    public Integer getNumMaximoInscritos() {
        return numMaximoInscritos;
    }

    public void setNumMaximoInscritos(Integer numMaximoInscritos) {
        this.numMaximoInscritos = numMaximoInscritos;
    }

    public Integer getNumInscritos() {
        return numInscritos;
    }

    public void setNumInscritos(Integer numInscritos) {
        this.numInscritos = numInscritos;
    }
}
