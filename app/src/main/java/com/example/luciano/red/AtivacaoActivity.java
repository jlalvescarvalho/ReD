package com.example.luciano.red;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.luciano.red.fachada.Fachada;
import com.example.luciano.red.negocio.entidade.Auditoria;

import java.util.ArrayList;

public class AtivacaoActivity extends AppCompatActivity {

    private Fachada fachada;
    private ListView listViewPerguntasAtivacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ativacao);

        fachada = new Fachada();
        ArrayList<Auditoria> lista_auditorias = fachada.recuperarTodasPerguntas();
        listViewPerguntasAtivacao = (ListView) findViewById(R.id.listViewAtivacao);

        AdpterPerguntasPersonalizada listaPersonalizada = new AdpterPerguntasPersonalizada(lista_auditorias, this);

        listViewPerguntasAtivacao.setAdapter(listaPersonalizada);
    }
}
