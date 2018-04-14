package com.example.luciano.red;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.luciano.red.fachada.Fachada;
import com.example.luciano.red.negocio.entidade.Auditoria;

import java.util.ArrayList;

public class precoActivity extends AppCompatActivity {

    private Fachada fachada;
    private ListView listViewPerguntasPreco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preco);

        fachada = new Fachada();
        ArrayList<Auditoria> lista_auditorias = fachada.recuperarTodasPerguntas();
        listViewPerguntasPreco = (ListView) findViewById(R.id.listViewPreco);

        AdpterPerguntasPersonalizada listaPersonalizada = new AdpterPerguntasPersonalizada(lista_auditorias, this);

        listViewPerguntasPreco.setAdapter(listaPersonalizada);
    }
}
