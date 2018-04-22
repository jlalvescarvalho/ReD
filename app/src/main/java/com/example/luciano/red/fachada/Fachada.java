package com.example.luciano.red.fachada;

import com.example.luciano.red.negocio.CalculoRED;
import com.example.luciano.red.negocio.NegocioCliente;
import com.example.luciano.red.negocio.NegocioPergunta;
import com.example.luciano.red.negocio.NegocioAuditoria;
import com.example.luciano.red.negocio.entidade.Ativacao;
import com.example.luciano.red.negocio.entidade.Cliente;
import com.example.luciano.red.negocio.entidade.GDM;
import com.example.luciano.red.negocio.entidade.Pergunta;
import com.example.luciano.red.negocio.entidade.Auditoria;
import com.example.luciano.red.negocio.entidade.Preco;
import com.example.luciano.red.negocio.entidade.SKU;
import com.example.luciano.red.negocio.entidade.Sovi;

import java.util.ArrayList;

/**
 * Created by luciano on 04/04/2018.
 */

public class Fachada {

    private NegocioCliente negocioCliente;
    private NegocioPergunta negocioPergunta;
    private NegocioAuditoria negocioAuditoria;
    private CalculoRED calculoRED;

    private static Fachada mySelf;

    public Fachada() {
        this.negocioCliente = new NegocioCliente();
        this.negocioPergunta = new NegocioPergunta();
        this.negocioAuditoria = new NegocioAuditoria();
        this.calculoRED = new CalculoRED();
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

    public ArrayList<Pergunta> recuperarTodasPerguntas(){
        return negocioPergunta.recuperarTodas();
    }

    public Pergunta verificaTipoPergunta(String pergunta, String pontos, String tipoCliente, String tipoPergunta){
        return negocioPergunta.verificaTipoPergunta(pergunta,pontos,tipoCliente,tipoPergunta);
    }
    public void deletarTudoAuditoria(){
        negocioPergunta.deletarTudo();
    }

    public ArrayList<Pergunta> recuraTodasPerguntasSovi(){
        return negocioPergunta.recuraTodasPerguntasSovi();
    }

    public ArrayList<Pergunta> recuraTodasPerguntasSKU(){
        return negocioPergunta.recuraTodasPerguntasSKU();
    }
    public ArrayList<Pergunta> recuraTodasPerguntasPreco(){
        return negocioPergunta.recuraTodasPerguntasPreco();
    }
    public ArrayList<Pergunta> recuraTodasPerguntasGDM(){
        return negocioPergunta.recuraTodasPerguntasGDM();
    }
    public ArrayList<Pergunta> recuraTodasPerguntasAtivacao(){
        return negocioPergunta.recuraTodasPerguntasAtivacao();
    }

    //------------------------

    public void cadastrarAuditoria(int indice, Auditoria auditoria){
        negocioAuditoria.cadastrarAuditoria(indice, auditoria);
    }

    public ArrayList<Auditoria> recuperarTodasPesquisas(){
        return negocioAuditoria.recuperarTodas();
    }

    //-----------------------

    public double calcularNotaPorCliente(int codigo){
        return calculoRED.calcularNotaPorCliente(codigo);
    }

    public ArrayList<Ativacao> retornarPesquiasPorClienteAtivacao(int codigo){
        return calculoRED.retornarPesquiasPorClienteAtivacao(codigo);
    }
    public ArrayList<SKU> retornarPesquiasPorClienteSKU(int codigo){
        return calculoRED.retornarPesquiasPorClienteSKU(codigo);
    }
    public ArrayList<Sovi> retornarPesquiasPorClienteSovi(int codigo){
        return calculoRED.retornarPesquiasPorClienteSovi(codigo);
    }
    public ArrayList<Preco> retornarPesquiasPorClientePreco(int codigo){
        return calculoRED.retornarPesquiasPorClientePreco(codigo);
    }
    public ArrayList<GDM> retornarPesquiasPorClienteGDM(int codigo){
        return calculoRED.retornarPesquiasPorClienteGDM(codigo);
    }

}
