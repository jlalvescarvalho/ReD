package com.example.luciano.red.negocio;

import com.example.luciano.red.negocio.entidade.Ativacao;
import com.example.luciano.red.negocio.entidade.Cliente;
import com.example.luciano.red.negocio.entidade.GDM;
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

        int indice = repositorioAuditoria.recuperarIndice(auditoria.getCliente().getCodigo());

            if(auditoria.getPergunta().getResposta() == 1){
                auditoria.getPergunta().setPontuacao(0.0);
            }else if(auditoria.getPergunta().getResposta() == 2){
                auditoria.getPergunta().setPontuacao(0.0);
            }

        repositorioAuditoria.adicionar(indice, auditoria);
    }

    public Auditoria recuperarPesquisa(int id){
        return repositorioAuditoria.recuperarPesquisa(id);
    }

    public ArrayList<Auditoria> recuperarTodas(){
        return repositorioAuditoria.recuperarTodasPesquisas();
    }

    public double calcularNotaPorCliente(int codigo){
        ArrayList<Auditoria> listaPesquisas = repositorioAuditoria.recuperarTodasPesquisas();
        double posiveis = 0.0, realizados = 0.0;

        for(Auditoria a: listaPesquisas){
            if(a.getCliente().getCodigo() == codigo) {
                if (a.getPergunta().getResposta() == 0 || a.getPergunta().getResposta() == 1) {
                    posiveis += a.getPergunta().getPontuacao();
                }
                if (a.getPergunta().getResposta() == 0) {
                    realizados += a.getPergunta().getPontuacao();
                }
            }
        }

        return (realizados / posiveis)*100;
    }

    public ArrayList<Ativacao> retornarPesquiasPorClienteAtivacao(int codigo){
        ArrayList<Auditoria> listaPesquisas = repositorioAuditoria.recuperarTodasPesquisas();
        ArrayList<Ativacao> listaAtivacao = new ArrayList<>();

        for (Auditoria a:listaPesquisas) {
            if(a.getCliente().getCodigo() == codigo) {
                if(a.getPergunta() instanceof Ativacao){
                    listaAtivacao.add((Ativacao) a.getPergunta());
                }
            }
        }
        return listaAtivacao;
    }

    public ArrayList<SKU> retornarPesquiasPorClienteSKU(int codigo){
        ArrayList<Auditoria> listaPesquisas = repositorioAuditoria.recuperarTodasPesquisas();
        ArrayList<SKU> listaSKU = new ArrayList<>();

        for (Auditoria a:listaPesquisas) {
            if(a.getCliente().getCodigo() == codigo) {
                if(a.getPergunta() instanceof SKU){
                    listaSKU.add((SKU) a.getPergunta());
                }
            }
        }
        return listaSKU;
    }

    public ArrayList<Sovi> retornarPesquiasPorClienteSovi(int codigo){
        ArrayList<Auditoria> listaPesquisas = repositorioAuditoria.recuperarTodasPesquisas();
        ArrayList<Sovi> listaSovi = new ArrayList<>();

        for (Auditoria a:listaPesquisas) {
            if(a.getCliente().getCodigo() == codigo) {
                if(a.getPergunta() instanceof Sovi){
                    listaSovi.add((Sovi) a.getPergunta());
                }
            }
        }
        return listaSovi;
    }

    public ArrayList<Preco> retornarPesquiasPorClientePreco(int codigo){
        ArrayList<Auditoria> listaPesquisas = repositorioAuditoria.recuperarTodasPesquisas();
        ArrayList<Preco> listaPreco = new ArrayList<>();

        for (Auditoria a:listaPesquisas) {
            if(a.getCliente().getCodigo() == codigo) {
                if(a.getPergunta() instanceof Preco){
                    listaPreco.add((Preco) a.getPergunta());
                }
            }
        }
        return listaPreco;
    }

    public ArrayList<GDM> retornarPesquiasPorClienteGDM(int codigo){
        ArrayList<Auditoria> listaPesquisas = repositorioAuditoria.recuperarTodasPesquisas();
        ArrayList<GDM> listaGDM = new ArrayList<>();

        for (Auditoria a:listaPesquisas) {
            if(a.getCliente().getCodigo() == codigo) {
                if(a.getPergunta() instanceof GDM){
                    listaGDM.add((GDM) a.getPergunta());
                }
            }
        }
        return listaGDM;
    }


}
