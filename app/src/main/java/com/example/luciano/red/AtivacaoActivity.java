package com.example.luciano.red;

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

public class AtivacaoActivity extends AppCompatActivity {

    private Cliente c;
    private ListView listViewPerguntasAtivacao;
    private Button btResposta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ativacao);

        btResposta = (Button)findViewById(R.id.bt_salvar_ativacao);

        c = (Cliente)getIntent().getSerializableExtra("cliente");

        ArrayList<Pergunta> lista_perguntas = Fachada.getInstance().retornaPerguntasPorTipoECanal(c.getSubCanal(), "Ativacao");
        listViewPerguntasAtivacao = (ListView) findViewById(R.id.listViewAtivacao);

        AdpterPerguntasPersonalizada listaPersonalizada = new AdpterPerguntasPersonalizada(lista_perguntas, this, c);

        listViewPerguntasAtivacao.setAdapter(listaPersonalizada);

        btResposta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(AtivacaoActivity.this, "Respotas salvas com sucesso !", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
