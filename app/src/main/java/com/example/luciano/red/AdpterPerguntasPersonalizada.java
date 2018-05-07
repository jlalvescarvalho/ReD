package com.example.luciano.red;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.luciano.red.fachada.Fachada;
import com.example.luciano.red.negocio.NegocioAuditoria;
import com.example.luciano.red.negocio.entidade.Auditoria;
import com.example.luciano.red.negocio.entidade.Cliente;
import com.example.luciano.red.negocio.entidade.Pergunta;

import java.util.ArrayList;

/**
 * Created by luciano on 09/04/2018.
 */

public class AdpterPerguntasPersonalizada extends BaseAdapter{

    private final ArrayList<Pergunta> perguntas;
    private final Activity act;
    private final Cliente c;

    public AdpterPerguntasPersonalizada(ArrayList<Pergunta> perguntas, Activity act, Cliente cliente) {
        this.perguntas = perguntas;
        this.act = act;
        this.c = cliente;
    }

    @Override
    public int getCount() {
        return perguntas.size();
    }

    @Override
    public Object getItem(int i) {
        return perguntas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return perguntas.get(i).getId();
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        View v = act.getLayoutInflater().inflate(R.layout.layout_item_pergunta, viewGroup, false);
        Pergunta pergunta = perguntas.get(i);

        //pegando as referencias da view
        TextView txtPergunta = (TextView)v.findViewById(R.id.txt_perguta);
        TextView txtPontuacao = (TextView)v.findViewById(R.id.txt_Pontuacao);
        final Button btResposta = (Button)v.findViewById(R.id.btResposta);

        //populando view
        txtPergunta.setText(pergunta.getPergunta());
        txtPontuacao.setText(String.valueOf(pergunta.getPontuacao()));

        btResposta.setOnClickListener(new View.OnClickListener() {
            int cont = 0;

            @Override
            public void onClick(View view) {
                switch (cont){
                    case 0:
                        btResposta.setText("Sim");
                        Fachada.getInstance().addPerguntaTemp(perguntas.get(i));
                        cont++;
                    break;
                    case 1:
                        btResposta.setText("Não");
                        Fachada.getInstance().addPerguntaTemp(perguntas.get(i));
                        cont++;
                    break;
                    case 2:
                        btResposta.setText("N/A");
                        Fachada.getInstance().addPerguntaTemp(perguntas.get(i));
                        cont = 0;
                    break;
                }
            }

        });


        return v;
    }

}
