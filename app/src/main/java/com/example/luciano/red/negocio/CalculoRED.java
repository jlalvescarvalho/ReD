package com.example.luciano.red.negocio;

import com.example.luciano.red.fachada.Fachada;
import com.example.luciano.red.negocio.entidade.Ativacao;
import com.example.luciano.red.negocio.entidade.Auditoria;
import com.example.luciano.red.negocio.entidade.GDM;
import com.example.luciano.red.negocio.entidade.Preco;
import com.example.luciano.red.negocio.entidade.SKU;
import com.example.luciano.red.negocio.entidade.Sovi;

import java.util.ArrayList;

/**
 * Created by luciano on 21/04/2018.
 */

public class CalculoRED {

    private ArrayList<Auditoria> listaPesquisas = Fachada.getInstance().recuperarTodasPesquisas();


    public double calcularNotaPorCliente(int codigo){
        double red = 0.0, posiveis = 0.0, realizados = 0.0;

        for(Auditoria a: listaPesquisas){
            if(a.getCliente().getCodigo() == codigo) {
                if (a.getPergunta().getResposta() == 0 || a.getPergunta().getResposta() == 1) {
                    posiveis += a.getPergunta().getPontuacao();
                } else if (a.getPergunta().getResposta() == 0) {
                    realizados += a.getPergunta().getPontuacao();
                }
            }
        }
        red = (realizados / posiveis)*100;

        return red;
    }

    public ArrayList<Ativacao> retornarPesquiasPorClienteAtivacao(int codigo){
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
