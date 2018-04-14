package com.example.luciano.red.fachada;

import com.example.luciano.red.negocio.NegocioCliente;
import com.example.luciano.red.negocio.NegocioPergunta;
import com.example.luciano.red.negocio.NegocioPesquisa;
import com.example.luciano.red.negocio.entidade.Cliente;
import com.example.luciano.red.negocio.entidade.Auditoria;
import com.example.luciano.red.negocio.entidade.Pesquisa;

import java.util.ArrayList;

/**
 * Created by luciano on 04/04/2018.
 */

public class Fachada {

    private NegocioCliente negocioCliente;
    private NegocioPergunta negocioPergunta;
    private NegocioPesquisa negocioPesquisa;

    private static Fachada mySelf;

    public Fachada() {
        this.negocioCliente = new NegocioCliente();
        this.negocioPergunta = new NegocioPergunta();
        this.negocioPesquisa = new NegocioPesquisa();
    }

    public static Fachada getInstance(){
        if(mySelf == null){
            mySelf = new Fachada();
        }
        return mySelf;
    }

    public void cadastrarCliente(Cliente c){
        negocioCliente.cadastrarCliente(c);
    }

    public ArrayList<Cliente> recuperarTodosClientes(){
        return negocioCliente.recuperarTodos();
    }

    //----------------------

    public void cadastrarPergunta(Auditoria auditoria){
       negocioPergunta.adicionarPergunta(auditoria);
    }

    public void cadastrarVariasPerguntas(ArrayList<Auditoria> lista){
        for(Auditoria p: lista){
            negocioPergunta.adicionarPergunta(p);
        }
    }

    public ArrayList<Auditoria> recuperarTodasPerguntas(){
        return negocioPergunta.recuperarTodas();
    }

    //------------------------

    public void cadastrarPesquisa(ArrayList<Auditoria> listaAuditorias, Cliente cliente){
        negocioPesquisa.cadastrarPesquisa(listaAuditorias, cliente);
    }

    public Pesquisa recuperarPesquisa(int id){
        return negocioPesquisa.recuperarPesquisa(id);
    }

    public ArrayList<Pesquisa> recuperarTodasPesquisas(){
        return negocioPesquisa.recuperarTodas();
    }
}
