package com.example.luciano.red;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.luciano.red.fachada.Fachada;
import com.example.luciano.red.negocio.entidade.Cliente;
import com.example.luciano.red.negocio.entidade.Pergunta;

import java.util.ArrayList;

public class GDMActivity extends AppCompatActivity {

    private Cliente c;
    private ListView listViewPerguntasGMD;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gdm);


        ArrayList<Pergunta> lista_perguntas = Fachada.getInstance().recuperarTodasPerguntas();
        listViewPerguntasGMD = (ListView) findViewById(R.id.listViewGMD);

        AdpterPerguntasPersonalizada listaPersonalizada = new AdpterPerguntasPersonalizada(lista_perguntas, this, c);

        listViewPerguntasGMD.setAdapter(listaPersonalizada);
    }
}
