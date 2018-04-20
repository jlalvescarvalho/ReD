package com.example.luciano.red.fachada;

import com.example.luciano.red.negocio.NegocioCliente;
import com.example.luciano.red.negocio.NegocioPergunta;
import com.example.luciano.red.negocio.NegocioAuditoria;
import com.example.luciano.red.negocio.entidade.Cliente;
import com.example.luciano.red.negocio.entidade.Pergunta;
import com.example.luciano.red.negocio.entidade.Auditoria;

import java.util.ArrayList;

/**
 * Created by luciano on 04/04/2018.
 */

public class Fachada {

    private NegocioCliente negocioCliente;
    private NegocioPergunta negocioPergunta;
    private NegocioAuditoria negocioAuditoria;

    private static Fachada mySelf;

    public Fachada() {
        this.negocioCliente = new NegocioCliente();
        this.negocioPergunta = new NegocioPergunta();
        this.negocioAuditoria = new NegocioAuditoria();
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
    public void deletarTudoCliente() {
        negocioCliente.deletarTudo();
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

    public Pergunta verificaTipoPergunta(String pergunta, String pontos, String tipoCliente, String tipoPergunta){
        return negocioPergunta.verificaTipoPergunta(pergunta,pontos,tipoCliente,tipoPergunta);
    }
    public void deletarTudoAuditoria(){
        negocioPergunta.deletarTudo();
    }


    //------------------------

    public void cadastrarAuditoria(Auditoria auditoria){
        negocioAuditoria.cadastrarAuditoria(auditoria);
    }

    public Auditoria recuperarPesquisa(int id){
        return negocioAuditoria.recuperarPesquisa(id);
    }

    public ArrayList<Auditoria> recuperarTodasPesquisas(){
        return negocioAuditoria.recuperarTodas();
    }


}
