package com.example.luciano.red;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import com.example.luciano.red.fachada.Fachada;
import com.example.luciano.red.negocio.entidade.Cliente;
import com.example.luciano.red.negocio.entidade.Pergunta;

import java.util.ArrayList;

public class SKUActivity extends AppCompatActivity {

    private ListView listViewPerguntas;
    private Button btResposta;
    private Cliente c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sku);

        c = (Cliente) getIntent().getSerializableExtra("cliente");

        ArrayList<Pergunta> lista_perguntas = Fachada.getInstance().recuperarTodasPerguntas();
        listViewPerguntas = (ListView) findViewById(R.id.listPerguntasSKU);

        AdpterPerguntasPersonalizada listaPersonalizada = new AdpterPerguntasPersonalizada(lista_perguntas, this, c);

        listViewPerguntas.setAdapter(listaPersonalizada);



    }


}
