package com.example.luciano.red;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.luciano.red.fachada.Fachada;
import com.example.luciano.red.negocio.entidade.Auditoria;

import java.util.ArrayList;

public class SoviActivity extends AppCompatActivity {

    private Fachada fachada;
    private ListView listViewPerguntasSovi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sovi);

        fachada = new Fachada();
        ArrayList<Auditoria> lista_auditorias = fachada.recuperarTodasPerguntas();
        listViewPerguntasSovi = (ListView) findViewById(R.id.listViewSovi);

        AdpterPerguntasPersonalizada listaPersonalizada = new AdpterPerguntasPersonalizada(lista_auditorias, this);

        listViewPerguntasSovi.setAdapter(listaPersonalizada);
    }
}
