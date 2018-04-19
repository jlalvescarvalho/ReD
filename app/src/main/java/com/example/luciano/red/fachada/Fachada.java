package com.example.luciano.red.fachada;

import com.example.luciano.red.negocio.NegocioCliente;
import com.example.luciano.red.negocio.NegocioAuditoria;
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
    private NegocioAuditoria negocioAuditoria;
    private NegocioPesquisa negocioPesquisa;

    private static Fachada mySelf;

    public Fachada() {
        this.negocioCliente = new NegocioCliente();
        this.negocioAuditoria = new NegocioAuditoria();
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
    public void deletarTudoCliente() {
        negocioCliente.deletarTudo();
    }

    //----------------------

    public void cadastrarPergunta(Auditoria auditoria){
       negocioAuditoria.adicionarPergunta(auditoria);
    }

    public void cadastrarVariasPerguntas(ArrayList<Auditoria> lista){
        for(Auditoria p: lista){
            negocioAuditoria.adicionarPergunta(p);
        }
    }

    public ArrayList<Auditoria> recuperarTodasPerguntas(){
        return negocioAuditoria.recuperarTodas();
    }

    public Auditoria verificaTipoPergunta(String pergunta, String pontos, String tipoCliente, String tipoPergunta){
        return negocioAuditoria.verificaTipoPergunta(pergunta,pontos,tipoCliente,tipoPergunta);
    }
    public void deletarTudoAuditoria(){
        negocioAuditoria.deletarTudo();
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
