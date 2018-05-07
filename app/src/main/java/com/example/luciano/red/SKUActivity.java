package com.example.luciano.red;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

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

        btResposta = (Button)findViewById(R.id.bt_salvar_sku);

        c = (Cliente) getIntent().getSerializableExtra("cliente");

        ArrayList<Pergunta> lista_perguntas = Fachada.getInstance().retornaPerguntasPorTipoECanal(c.getSubCanal(), "Portifolio");
        listViewPerguntas = (ListView) findViewById(R.id.listPerguntasSKU);

        AdpterPerguntasPersonalizada listaPersonalizada = new AdpterPerguntasPersonalizada(lista_perguntas, this, c);

        listViewPerguntas.setAdapter(listaPersonalizada);

        btResposta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SKUActivity.this, "Respostas salvas com sucesso !", Toast.LENGTH_SHORT).show();
                finish();
            }
        });




    }


}
