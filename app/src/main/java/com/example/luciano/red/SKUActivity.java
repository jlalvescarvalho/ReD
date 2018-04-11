package com.example.luciano.red;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;

import com.example.luciano.red.fachada.Fachada;
import com.example.luciano.red.negocio.entidade.Pergunta;

import java.util.ArrayList;

public class SKUActivity extends AppCompatActivity {
    Fachada fachada;
    ListView listViewPerguntas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sku);
        fachada = new Fachada();
        ArrayList<Pergunta> lista_perguntas = fachada.recuperarTodasPerguntas();
        listViewPerguntas = (ListView) findViewById(R.id.listPerguntasSKU);

        AdpterPerguntasPersonalizada listaPersonalizada = new AdpterPerguntasPersonalizada(lista_perguntas, this);

        listViewPerguntas.setAdapter(listaPersonalizada);


    }


}
