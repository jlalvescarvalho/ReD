package com.example.luciano.red.negocio;

import com.example.luciano.red.negocio.entidade.Cliente;
import com.example.luciano.red.negocio.entidade.Pergunta;
import com.example.luciano.red.negocio.entidade.Auditoria;
import com.example.luciano.red.repositorio.RepositorioAuditoria;

import java.util.ArrayList;

/**
 * Created by luciano on 04/04/2018.
 */

public class NegocioAuditoria {

    private RepositorioAuditoria repositorioAuditoria;
    private static NegocioAuditoria mySelf;

    public NegocioAuditoria() {
        this.repositorioAuditoria = new RepositorioAuditoria();
    }

    public static NegocioAuditoria getInstance(){
        if(mySelf == null){
            mySelf = new NegocioAuditoria();
        }
        return mySelf;
    }

    public void cadastrarAuditoria(Auditoria auditoria){
            if(auditoria.getPergunta().getResposta() == 1){
                auditoria.getPergunta().setPontuacao(0.0);
            }

        repositorioAuditoria.adicionar(auditoria);
    }

    public Auditoria recuperarPesquisa(int id){
        return repositorioAuditoria.recuperarPesquisa(id);
    }

    public ArrayList<Auditoria> recuperarTodas(){
        return repositorioAuditoria.recuperarTodasPesquisas();
    }
}
