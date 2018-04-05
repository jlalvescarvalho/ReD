package com.example.luciano.red.negocio.entidade;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by luciano on 04/04/2018.
 */

public class Pesquisa {

    private int id;
    private ArrayList<Pergunta> listaPerguntas;
    private Cliente cliente;
    private Date data;

    public Pesquisa(ArrayList<Pergunta> listaPerguntas, Cliente cliente) {
        this.listaPerguntas = listaPerguntas;
        this.cliente = cliente;
        this.data = new Date();
    }

    public Date getData() {
        return data;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public ArrayList<Pergunta> getListaPerguntas() {
        return listaPerguntas;
    }

    public int getId() {
        return id;
    }
}
