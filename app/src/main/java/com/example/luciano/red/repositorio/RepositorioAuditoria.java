package com.example.luciano.red.repositorio;

import com.example.luciano.red.negocio.entidade.Auditoria;

import java.util.ArrayList;

/**
 * Created by luciano on 04/04/2018.
 */

public class RepositorioAuditoria {

    ArrayList<Auditoria> listaAuditorias;

    public RepositorioAuditoria() {
        this.listaAuditorias = new ArrayList<>();
    }

    public void adicionar(Auditoria p){
        this.listaAuditorias.add(p);
    }

    public Auditoria recuperarPesquisa(int id){
        for(Auditoria p: listaAuditorias){
            if(p.getId() == id){
                return p;
            }
        }
        return null;
    }

    public void atualizarPesquisa(int indice, Auditoria p){
        this.listaAuditorias.set(indice, p);
    }


    public void excluirPesquisa(Auditoria p){
        if(listaAuditorias.contains(p)){
            listaAuditorias.remove(p);
        }
    }

    public ArrayList<Auditoria> recuperarTodasPesquisas(){
        return this.listaAuditorias;
    }


}
