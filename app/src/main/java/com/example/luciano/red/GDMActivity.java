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

public class GDMActivity extends AppCompatActivity {

    private Cliente c;
    private ListView listViewPerguntasGMD;
    private Button btResposta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gdm);

        btResposta = (Button)findViewById(R.id.bt_salvar_gdm);

        c = (Cliente)getIntent().getSerializableExtra("cliente");


        ArrayList<Pergunta> lista_perguntas = Fachada.getInstance().retornaPerguntasPorTipoECanal(c.getSubCanal(), "GDM");
        listViewPerguntasGMD = (ListView) findViewById(R.id.listViewGMD);

        AdpterPerguntasPersonalizada listaPersonalizada = new AdpterPerguntasPersonalizada(lista_perguntas, this, c);

        listViewPerguntasGMD.setAdapter(listaPersonalizada);

        btResposta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(GDMActivity.this, "Respostas salvas com sucesso ! ", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
