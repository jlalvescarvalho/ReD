package com.example.luciano.red;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.luciano.red.fachada.Fachada;
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
        final Pergunta pergunta = perguntas.get(i);

        //pegando as referencias da view
        TextView txtPergunta = (TextView)v.findViewById(R.id.txt_perguta);
        final Button btResposta = (Button)v.findViewById(R.id.btResposta);

        //populando view
        txtPergunta.setText(pergunta.getPergunta());

        btResposta.setOnClickListener(new View.OnClickListener() {
            int cont = 0;

            @Override
            public void onClick(View view) {
                if(cont == 0){
                    btResposta.setText("Sim");
                    perguntas.get(i).setResposta(0);
                    cont++;
                }else if(cont == 1){
                    btResposta.setText("Não");
                    perguntas.get(i).setResposta(1);
                    cont++;
                }else if(cont == 2){
                    btResposta.setText("N/A");
                    perguntas.get(i).setResposta(2);
                    cont = 0;
                }

            }
            Auditoria auditoria = new Auditoria(perguntas.get(i), c);

        });


        return v;
    }

//    public void salvarPergunta(Pergunta p, Cliente c){
//
//        Auditoria aud = new Auditoria(p, c);
//        Fachada.getInstance().cadastrarAuditoria(aud);
//    }

}
