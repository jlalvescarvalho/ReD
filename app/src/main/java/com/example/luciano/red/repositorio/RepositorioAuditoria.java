package com.example.luciano.red.repositorio;

import com.example.luciano.red.negocio.entidade.Auditoria;
import com.example.luciano.red.negocio.entidade.Cliente;
import com.example.luciano.red.negocio.entidade.Pergunta;

import java.util.ArrayList;

/**
 * Created by luciano on 04/04/2018.
 */

public class RepositorioAuditoria {

    private ArrayList<Pergunta> perguntasTemp;
    private ArrayList<Auditoria> listAuditorias;

    public RepositorioAuditoria() {
        this.perguntasTemp = new ArrayList<>();
        this.listAuditorias = new ArrayList<>();
    }

    public void adicionarPerguntaTemp(int indice, Pergunta p){
        if(perguntasTemp.contains(p)){
            this.perguntasTemp.set(indice, p);
        }else {
            this.perguntasTemp.add(p);
        }
    }
    public ArrayList<Pergunta> retornaPerguntasTemp(){
        return this.perguntasTemp;
    }

    private void zerarPerguntasTemp(){
        this.perguntasTemp = new ArrayList<>();
    }

    public Auditoria recuperarPesquisa(int id){
        for(Auditoria p: listAuditorias){
            if(p.getId() == id){
                return p;
            }
        }
        return null;
    }

    public void cadastrarAuditoria(Auditoria a){
        this.listAuditorias.add(a);
        zerarPerguntasTemp();
    }

    public void excluirPesquisa(Auditoria p){
        if(perguntasTemp.contains(p)){
            perguntasTemp.remove(p);
        }
    }

    public ArrayList<Auditoria> recuperarTodasPesquisas(){
        return this.listAuditorias;
    }

    public ArrayList<Pergunta> recuperarPerguntasPorCliente(int codigo){

        for (int i = 0; i < listAuditorias.size(); i++){
            if (listAuditorias.get(i).getCliente().getCodigo() == codigo){
                return listAuditorias.get(i).getPerguntasAuditadas();
            }
        }
        return null;
    }

}
