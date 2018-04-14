package com.example.luciano.red.repositorio;

import com.example.luciano.red.negocio.entidade.Auditoria;

import java.util.ArrayList;

/**
 * Created by luciano on 04/04/2018.
 */

public class RepositorioPergunta {

    private ArrayList<Auditoria> listaAuditorias;

    public RepositorioPergunta() {
        this.listaAuditorias = new ArrayList<>();
    }

    public void adicionarPergunta(Auditoria p){
        this.listaAuditorias.add(p);
    }

    public Auditoria recuperarPergunta(int id) {
        for(Auditoria p: listaAuditorias){
            if(p.getId() == id){
                return p;
            }
        }
        return null;
    }

    public void atualizarPergunta(int indice, Auditoria p){
        this.listaAuditorias.set(indice, p);
    }


    public void excluirPergunta(Auditoria p){
        if(listaAuditorias.contains(p)){
            listaAuditorias.remove(p);
        }
    }

    public ArrayList<Auditoria> recuperarTodaPerguntas(){
        return this.listaAuditorias;
    }
}
