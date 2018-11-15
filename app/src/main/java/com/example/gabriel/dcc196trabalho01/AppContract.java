package com.example.gabriel.dcc196trabalho01;

import android.provider.BaseColumns;

public class AppContract {

    public final class Evento implements BaseColumns {
        public final static String TABLE_NAME = "Evento";
        public final static String COLUMN_NAME_REGISTRO = "registro";
        public final static String COLUMN_NAME_NOME = "nome";
        public final static String COLUMN_NAME_LOCAL = "local";
        public final static String COLUMN_NAME_DATA = "data";
        public final static String COLUMN_NAME_FACILITADOR = "facilitador";
        public static final String COLUMN_NAME_DESCRICAO = "descricao";
        public static final String COLUMN_NAME_INSCRITOS = "inscritos";
        public static final String COLUMN_NAME_MAXINSCRITOS = "maxinscritos";
        public final static String CREATE_EVENTO  = "CREATE TABLE "+Evento.TABLE_NAME+" ("
                + Evento.COLUMN_NAME_REGISTRO + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + Evento.COLUMN_NAME_NOME+ " TEXT, "
                + Evento.COLUMN_NAME_LOCAL+ " TEXT, "
                + Evento.COLUMN_NAME_DATA+ " TEXT, "
                + Evento.COLUMN_NAME_FACILITADOR+ " TEXT, "
                + Evento.COLUMN_NAME_DESCRICAO+ " TEXT, "
                + Evento.COLUMN_NAME_INSCRITOS+ " INTEGER, "
                + Evento.COLUMN_NAME_MAXINSCRITOS+ " INTEGER"
                +")";
        public final static String DROP_EVENTO = "DROP TABLE IF EXISTS "+Evento.TABLE_NAME;
    }

}
