package com.example.luciano.red;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.luciano.red.fachada.Fachada;
import com.example.luciano.red.negocio.entidade.Cliente;
import com.example.luciano.red.negocio.entidade.Pergunta;

import java.util.ArrayList;

public class precoActivity extends AppCompatActivity {

    private Cliente c;
    private ListView listViewPerguntasPreco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preco);


        ArrayList<Pergunta> lista_perguntas = Fachada.getInstance().recuperarTodasPerguntas();
        listViewPerguntasPreco = (ListView) findViewById(R.id.listViewPreco);

        AdpterPerguntasPersonalizada listaPersonalizada = new AdpterPerguntasPersonalizada(lista_perguntas, this, c);

        listViewPerguntasPreco.setAdapter(listaPersonalizada);
    }
}
