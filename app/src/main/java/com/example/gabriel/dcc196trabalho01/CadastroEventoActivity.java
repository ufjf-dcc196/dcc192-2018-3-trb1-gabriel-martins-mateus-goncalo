package com.example.gabriel.dcc196trabalho01;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CadastroEventoActivity extends AppCompatActivity {

    private Button btnConfirmaCadEvento;
    private TextView txtTitulo;
    private TextView txtData;
    private TextView txtFacilitador;
    private TextView txtDescicao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_evento);

        btnConfirmaCadEvento = findViewById(R.id.btn_confirmaCadEvento);
        txtTitulo = findViewById(R.id.txt_titulo);
        txtData = findViewById(R.id.txt_data);
        txtFacilitador = findViewById(R.id.txt_facilitador);
        txtDescicao = findViewById(R.id.txt_descricao);

        btnConfirmaCadEvento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(Activity.RESULT_OK);
                finish();
            }
        });
    }
}
