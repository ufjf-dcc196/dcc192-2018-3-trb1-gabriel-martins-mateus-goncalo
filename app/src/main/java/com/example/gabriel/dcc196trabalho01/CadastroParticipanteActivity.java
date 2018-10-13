package com.example.gabriel.dcc196trabalho01;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CadastroParticipanteActivity extends AppCompatActivity {

    private Button btnConfimaCadastro;
    private TextView txtNomeParticipante;
    private TextView txtEmail;
    private TextView txtCPF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_participante);
        btnConfimaCadastro = findViewById(R.id.btn_confirmaCadPart);
        txtNomeParticipante = findViewById(R.id.txt_nomeParticipante);
        txtEmail = findViewById(R.id.txt_email);
        txtCPF = findViewById(R.id.txt_cpf);

        btnConfimaCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(Activity.RESULT_OK);
                finish();
            }
        });
    }
}
