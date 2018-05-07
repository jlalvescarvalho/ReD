package com.example.luciano.red.negocio;

import com.example.luciano.red.fachada.Fachada;
import com.example.luciano.red.negocio.entidade.Ativacao;
import com.example.luciano.red.negocio.entidade.Cliente;
import com.example.luciano.red.negocio.entidade.GDM;
import com.example.luciano.red.negocio.entidade.ItemAuditoria;
import com.example.luciano.red.negocio.entidade.Pergunta;
import com.example.luciano.red.negocio.entidade.Auditoria;
import com.example.luciano.red.negocio.entidade.Preco;
import com.example.luciano.red.negocio.entidade.SKU;
import com.example.luciano.red.negocio.entidade.Sovi;
import com.example.luciano.red.repositorio.RepositorioAuditoria;

import java.util.ArrayList;

/**
 * Created by luciano on 04/04/2018.
 */

public class NegocioAuditoria {

    private RepositorioAuditoria repositorioAuditoria;
    private static NegocioAuditoria mySelf;
    private ArrayList<Pergunta> listaPerguntas;
    private Cliente cliente;

    public NegocioAuditoria() {
        this.repositorioAuditoria = new RepositorioAuditoria();
        this.listaPerguntas = new ArrayList<>();
    }

    public static NegocioAuditoria getInstance(){
        if(mySelf == null){
            mySelf = new NegocioAuditoria();
        }
        return mySelf;
    }

    public void cadastrarAuditoria(ArrayList<Pergunta> listaPerguntas, Cliente cliente){
        Auditoria auditoria = new Auditoria(listaPerguntas, cliente);
        repositorioAuditoria.cadastrarAuditoria(auditoria);
    }

    public Auditoria recuperarPesquisa(int id){
        return repositorioAuditoria.recuperarPesquisa(id);
    }

    public ArrayList<Auditoria> recuperarTodas(){
        return repositorioAuditoria.recuperarTodasPesquisas();
    }

    public double calcularNotaPorCliente(Cliente cliente){
        ArrayList<Pergunta> listPerguntasAuditadas = repositorioAuditoria.recuperarPerguntasPorCliente(cliente.getCodigo());
        double pontosPossiveis = 0.0, pontosRealizados = 0.0;

        pontosPossiveis = calcularPontosPossiveisCliente(cliente);

        for (int i=0;i < listPerguntasAuditadas.size(); i++){
            pontosRealizados += listPerguntasAuditadas.get(i).getPontuacao();
        }

        return (pontosRealizados/pontosPossiveis)*100;
    }

    private double calcularPontosPossiveisCliente(Cliente c){
        double soma = 0.0;
        ArrayList<Pergunta> perguntasCliente = Fachada.getInstance().retornarPerguntaPorSubCanal(c.getSubCanal());
            for (Pergunta p: perguntasCliente){
                soma += p.getPontuacao();
            }
        return soma;
    }



    public int recuperaIdPerguntaTemp(Pergunta p){
        ArrayList<Pergunta> perguntasTemp = repositorioAuditoria.retornaPerguntasTemp();

        for (int i = 0; i < perguntasTemp.size(); i++){
            if (perguntasTemp.get(i).getId() == p.getId()){
                return i;
            }
        }
        return -1;
    }


    public void addPerguntasTemp(Pergunta p){
        int indice = recuperaIdPerguntaTemp(p);
        repositorioAuditoria.adicionarPerguntaTemp(indice , p);
    }

    public ArrayList<Pergunta> retornarTodasPerguntasTemp(){
        return repositorioAuditoria.retornaPerguntasTemp();
    }








}
