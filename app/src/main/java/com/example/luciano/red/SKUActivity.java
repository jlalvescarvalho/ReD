package com.example.luciano.red;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.luciano.red.fachada.Fachada;
import com.example.luciano.red.negocio.entidade.Auditoria;

import java.util.ArrayList;

public class SKUActivity extends AppCompatActivity {
    private Fachada fachada;
    private ListView listViewPerguntas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sku);
        ArrayList<Auditoria> lista_auditorias = Fachada.getInstance().recuperarTodasPerguntas();
        listViewPerguntas = (ListView) findViewById(R.id.listPerguntasSKU);

        AdpterPerguntasPersonalizada listaPersonalizada = new AdpterPerguntasPersonalizada(lista_auditorias, this);

        listViewPerguntas.setAdapter(listaPersonalizada);


    }


}
