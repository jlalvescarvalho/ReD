package com.example.luciano.red.negocio;

import com.example.luciano.red.negocio.entidade.Cliente;
import com.example.luciano.red.negocio.entidade.Pergunta;
import com.example.luciano.red.negocio.entidade.Pesquisa;
import com.example.luciano.red.repositorio.RepositorioPesquisa;

import java.util.ArrayList;

/**
 * Created by luciano on 04/04/2018.
 */

public class NegocioPesquisa {

    private RepositorioPesquisa repositorioPesquisa;
    private static NegocioPesquisa mySelf;

    public NegocioPesquisa() {
        this.repositorioPesquisa = new RepositorioPesquisa();
    }

    public static NegocioPesquisa getInstance(){
        if(mySelf == null){
            mySelf = new NegocioPesquisa();
        }
        return mySelf;
    }

    public void cadastrarPesquisa(ArrayList<Pergunta> listaPerguntas, Cliente cliente){
        for(Pergunta p: listaPerguntas){
            if(!p.getResposta()){
                p.setPontuacao(0.0);
            }
        }
        Pesquisa pesquisa = new Pesquisa(listaPerguntas,cliente);
        repositorioPesquisa.adicionar(pesquisa);
    }

    public Pesquisa recuperarPesquisa(int id){
        return repositorioPesquisa.recuperarPesquisa(id);
    }

    public ArrayList<Pesquisa> recuperarTodas(){
        return repositorioPesquisa.recuperarTodasPesquisas();
    }
}
