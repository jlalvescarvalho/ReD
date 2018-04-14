package com.example.luciano.red.negocio;

import com.example.luciano.red.negocio.entidade.Auditoria;
import com.example.luciano.red.repositorio.RepositorioPergunta;

import java.util.ArrayList;

/**
 * Created by luciano on 04/04/2018.
 */

public class NegocioPergunta {

    private RepositorioPergunta repositorioPergunta;
    private static NegocioPergunta mySelf;

    public NegocioPergunta() {
        this.repositorioPergunta = new RepositorioPergunta();
    }

    public static NegocioPergunta getInstance(){
        if(mySelf == null){
            mySelf = new NegocioPergunta();
        }
        return mySelf;
    }

    public void adicionarPergunta(Auditoria auditoria){
        repositorioPergunta.adicionarPergunta(auditoria);
    }

    public void adicionarVariasPerguntas(ArrayList<Auditoria> lista){
        for(Auditoria p: lista){
            repositorioPergunta.adicionarPergunta(p);
        }
    }

    public ArrayList<Auditoria> recuperarTodas(){
        return repositorioPergunta.recuperarTodaPerguntas();
    }
}
