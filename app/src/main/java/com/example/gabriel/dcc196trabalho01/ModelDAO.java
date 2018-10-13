package com.example.gabriel.dcc196trabalho01;

import java.util.ArrayList;
import java.util.List;

public class ModelDAO {

    public static List<Participante> participanteList;
    private static List<Evento> eventoList;

    public static List getParticipanteInstance()
    {
        if (participanteList == null)
        {
            //Evento e1 = new Evento("Palestra de jogos", )
            participanteList = new ArrayList<Participante>();
            Participante p1 = new Participante("Mateus", "mateusgon57@gmail.com", "00000000000", null);
            Participante p2 = new Participante("Gabriel", "gabrielmsanta97@gmail.com", "00000000000", null);
            participanteList.add(p1);
            participanteList.add(p2);
        }
        return participanteList;
    }
}
