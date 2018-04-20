package com.example.luciano.red;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.luciano.red.fachada.Fachada;
import com.example.luciano.red.negocio.entidade.Cliente;
import com.example.luciano.red.negocio.entidade.Pergunta;

import java.util.ArrayList;

public class AtivacaoActivity extends AppCompatActivity {

    private Cliente c;
    private ListView listViewPerguntasAtivacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ativacao);


        ArrayList<Pergunta> lista_perguntas = Fachada.getInstance().recuperarTodasPerguntas();
        listViewPerguntasAtivacao = (ListView) findViewById(R.id.listViewAtivacao);

        AdpterPerguntasPersonalizada listaPersonalizada = new AdpterPerguntasPersonalizada(lista_perguntas, this, c);

        listViewPerguntasAtivacao.setAdapter(listaPersonalizada);
    }
}
