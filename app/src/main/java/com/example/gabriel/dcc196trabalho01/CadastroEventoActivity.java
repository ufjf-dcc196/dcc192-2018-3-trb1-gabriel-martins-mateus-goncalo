package com.example.gabriel.dcc196trabalho01;

import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CadastroEventoActivity extends AppCompatActivity {

    private Button btnConfirmaCadEvento;
    private EditText txtTitulo;
    private EditText txtLocal;
    private EditText txtData;
    private EditText txtNumMaximoInscritos;
    private EditText txtFacilitador;
    private EventoDbHelper dbHelper;
    private EditText txtDescicao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_evento);

        dbHelper = new EventoDbHelper(getApplicationContext());

        btnConfirmaCadEvento = findViewById(R.id.btn_confirmaCadEvento);
        txtTitulo = findViewById(R.id.txt_titulo2);
        txtLocal = findViewById(R.id.txt_local);
        txtData = findViewById(R.id.txt_dataHora);
        txtNumMaximoInscritos = findViewById(R.id.txt_NumMaxInscritos);
        txtFacilitador = findViewById(R.id.txt_facilitador);
        txtDescicao = findViewById(R.id.txt_descricao);

        btnConfirmaCadEvento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = txtData.getText().toString();
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
                Calendar cal = Calendar.getInstance();
                try {
                    cal.setTime(sdf.parse(data));
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                Evento evento = new Evento(txtTitulo.getText().toString(), txtLocal.getText().toString(), cal, txtFacilitador.getText().toString(), txtDescicao.getText().toString(), null, Integer.parseInt(txtNumMaximoInscritos.getText().toString()), 0);
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                ContentValues valores = new ContentValues();
                valores.put(AppContract.Evento.COLUMN_NAME_NOME, evento.getNome());
                valores.put(AppContract.Evento.COLUMN_NAME_DATA, String.valueOf(evento.getDataEvento()));
                valores.put(AppContract.Evento.COLUMN_NAME_LOCAL, evento.getLocal());
                valores.put(AppContract.Evento.COLUMN_NAME_DESCRICAO, evento.getDescricao());
                valores.put(AppContract.Evento.COLUMN_NAME_FACILITADOR, evento.getFacilitador());
                valores.put(AppContract.Evento.COLUMN_NAME_MAXINSCRITOS, evento.getNumMaximoInscritos());
                valores.put(AppContract.Evento.COLUMN_NAME_INSCRITOS, 0);

                long id = db.insert(AppContract.Evento.TABLE_NAME,null, valores);
                Log.i("DBINFO", "registro criado com id: "+id);
                setResult(Activity.RESULT_OK);
                finish();
            }
        });
    }
}
