package com.example.luciano.red;

import com.example.luciano.red.negocio.NegocioCliente;
import com.example.luciano.red.negocio.NegocioPergunta;
import com.example.luciano.red.negocio.NegocioPesquisa;
import com.example.luciano.red.negocio.entidade.Cliente;
import com.example.luciano.red.negocio.entidade.Pergunta;
import com.example.luciano.red.negocio.entidade.Pesquisa;

import java.util.ArrayList;

/**
 * Created by luciano on 04/04/2018.
 */

public class Fachada {

    private NegocioCliente negocioCliente;
    private NegocioPergunta negocioPergunta;
    private NegocioPesquisa negocioPesquisa;


    public void cadastrarCliente(Cliente c){
        negocioCliente.cadastrarCliente(c);
    }

    public ArrayList<Cliente> recuperarTodosClientes(){
        return negocioCliente.recuperarTodos();
    }

    //----------------------

    public void cadastrarPergunta(Pergunta pergunta){
       negocioPergunta.adicionarPergunta(pergunta);
    }

    public void cadastrarVariasPerguntas(ArrayList<Pergunta> lista){
        for(Pergunta p: lista){
            negocioPergunta.adicionarPergunta(p);
        }
    }

    public ArrayList<Pergunta> recuperarTodasPerguntas(){
        return negocioPergunta.recuperarTodas();
    }

    //------------------------

    public void cadastrarPesquisa(ArrayList<Pergunta> listaPerguntas, Cliente cliente){
        negocioPesquisa.cadastrarPesquisa(listaPerguntas, cliente);
    }

    public Pesquisa recuperarPesquisa(int id){
        return negocioPesquisa.recuperarPesquisa(id);
    }

    public ArrayList<Pesquisa> recuperarTodasPesquisas(){
        return negocioPesquisa.recuperarTodas();
    }
}
