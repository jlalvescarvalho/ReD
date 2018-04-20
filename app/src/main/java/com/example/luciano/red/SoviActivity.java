package com.example.luciano.red;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.luciano.red.fachada.Fachada;
import com.example.luciano.red.negocio.entidade.Cliente;
import com.example.luciano.red.negocio.entidade.Pergunta;

import java.util.ArrayList;

public class SoviActivity extends AppCompatActivity {

    private ListView listViewPerguntasSovi;
    private Cliente c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sovi);

        ArrayList<Pergunta> lista_perguntas = Fachada.getInstance().recuperarTodasPerguntas();
        listViewPerguntasSovi = (ListView) findViewById(R.id.listViewSovi);

        AdpterPerguntasPersonalizada listaPersonalizada = new AdpterPerguntasPersonalizada(lista_perguntas, this, c);

        listViewPerguntasSovi.setAdapter(listaPersonalizada);
    }
}
