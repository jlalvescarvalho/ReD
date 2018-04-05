package com.example.luciano.red.repositorio;

import com.example.luciano.red.negocio.entidade.Pergunta;

import java.util.ArrayList;

/**
 * Created by luciano on 04/04/2018.
 */

public class RepositorioPergunta {

    private ArrayList<Pergunta> listaPerguntas;

    public RepositorioPergunta() {
        this.listaPerguntas = new ArrayList<>();
    }

    public void adicionarPergunta(Pergunta p){
        this.listaPerguntas.add(p);
    }

    public Pergunta recuperarPergunta(int id) {
        for(Pergunta p: listaPerguntas){
            if(p.getId() == id){
                return p;
            }
        }
        return null;
    }

    public void atualizarPergunta(int indice, Pergunta p){
        this.listaPerguntas.set(indice, p);
    }


    public void excluirPergunta(Pergunta p){
        if(listaPerguntas.contains(p)){
            listaPerguntas.remove(p);
        }
    }

    public ArrayList<Pergunta> recuperarTodaPerguntas(){
        return this.listaPerguntas;
    }
}
