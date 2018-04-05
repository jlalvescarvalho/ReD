package com.example.luciano.red.repositorio;

import com.example.luciano.red.negocio.entidade.Pesquisa;

import java.util.ArrayList;

/**
 * Created by luciano on 04/04/2018.
 */

public class RepositorioPesquisa {

    ArrayList<Pesquisa> listaPesquisas;

    public RepositorioPesquisa() {
        this.listaPesquisas = new ArrayList<>();
    }

    public void adicionar(Pesquisa p){
        this.listaPesquisas.add(p);
    }

    public Pesquisa recuperarPesquisa(int id){
        for(Pesquisa p: listaPesquisas){
            if(p.getId() == id){
                return p;
            }
        }
        return null;
    }

    public void atualizarPesquisa(int indice, Pesquisa p){
        this.listaPesquisas.set(indice, p);
    }


    public void excluirPesquisa(Pesquisa p){
        if(listaPesquisas.contains(p)){
            listaPesquisas.remove(p);
        }
    }

    public ArrayList<Pesquisa> recuperarTodasPesquisas(){
        return this.listaPesquisas;
    }


}
