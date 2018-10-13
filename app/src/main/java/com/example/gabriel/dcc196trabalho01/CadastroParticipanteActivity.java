package com.example.gabriel.dcc196trabalho01;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CadastroParticipanteActivity extends AppCompatActivity {

    private Button btnConfimaCadastro;
    private EditText txtNomeParticipante;
    private EditText txtEmail;
    private EditText txtCPF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_participante);
        btnConfimaCadastro = findViewById(R.id.btn_confirmaCadPart);
        txtNomeParticipante = (EditText) findViewById(R.id.txt_nomeParticipante);
        txtEmail = (EditText) findViewById(R.id.txt_email);
        txtCPF = (EditText) findViewById(R.id.txt_cpf);

        btnConfimaCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Participante participante = new Participante(txtNomeParticipante.getText().toString(), txtEmail.getText().toString(), txtCPF.getText().toString(), null);
                ModelDAO.getParticipanteInstance().add(participante);
                setResult(Activity.RESULT_OK);
                finish();
            }
        });
    }
}
