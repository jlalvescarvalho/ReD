package com.example.luciano.red;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DadosActivity extends AppCompatActivity {

    private Button btPerguntas;
    private Button btClientes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados);

        ActionBar bar = getSupportActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#000000")));

        btPerguntas = (Button)findViewById(R.id.btPerguntas);
        btClientes = (Button)findViewById(R.id.btClientes);

        btPerguntas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(DadosActivity.this, CrudPerguntasActivity.class);
                startActivity(it);
            }
        });

        btClientes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(DadosActivity.this, CrudClienteActivity.class);
                startActivity(it);
            }
        });

    }
}
