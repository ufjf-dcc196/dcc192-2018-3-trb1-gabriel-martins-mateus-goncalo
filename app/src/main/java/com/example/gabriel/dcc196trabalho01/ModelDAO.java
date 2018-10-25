package com.example.gabriel.dcc196trabalho01;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ModelDAO {

    public static List<Participante> participanteList;
    private static List<Evento> eventoList;

    public static List getParticipanteInstance()
    {
        if (participanteList == null)
        {
            participanteList = new ArrayList<Participante>();
            Participante p1 = new Participante("Mateus", "mateusgon57@gmail.com", "00000000000", null);
            Participante p2 = new Participante("Gabriel", "gabrielmsanta97@gmail.com", "00123456789", null);
            participanteList.add(p1);
            participanteList.add(p2);
        }
        return participanteList;
    }

    public static List getEventoInstance()
    {
        if (eventoList == null)
        {
            String data = "26/10/2018 20:30";
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
            Calendar cal = Calendar.getInstance();
            try {
                cal.setTime(sdf.parse(data));
            } catch (ParseException e) {
                e.printStackTrace();
            }

            eventoList = new ArrayList<Evento>();
            Evento e1 = new Evento("Palestra de jogos", "S205", cal, "Mateus Gonçalo", "Abordará o desenvolvimento de jogos", null, 30, 0);
            Evento e2 = new Evento("Selenium Web Driver", "L107", cal, "Gabriel Martins", "Abordará o uso do Selenium", null, 40, 0);
            eventoList.add(e1);
            eventoList.add(e2);
        }
        return eventoList;
    }
}
