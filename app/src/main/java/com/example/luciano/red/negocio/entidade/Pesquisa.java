package com.example.luciano.red.negocio.entidade;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by luciano on 04/04/2018.
 */

public class Pesquisa {

    private int id;
    private ArrayList<Auditoria> listaAuditorias;
    private Cliente cliente;
    private Date data;

    public Pesquisa(ArrayList<Auditoria> listaAuditorias, Cliente cliente) {
        this.listaAuditorias = listaAuditorias;
        this.cliente = cliente;
        this.data = new Date();
    }

    public Date getData() {
        return data;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public ArrayList<Auditoria> getListaAuditorias() {
        return listaAuditorias;
    }

    public int getId() {
        return id;
    }
}
