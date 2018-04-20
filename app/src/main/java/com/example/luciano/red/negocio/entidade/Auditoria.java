package com.example.luciano.red.negocio.entidade;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by luciano on 04/04/2018.
 */

public class Auditoria {

    private int id;
    private Pergunta pergunta;
    private Cliente cliente;
    private Date data;
    private int cont = 0;

    public Auditoria(Pergunta p, Cliente cliente) {
        this.cliente = cliente;
        this.pergunta = p;
        this.data = new Date();
        this.id = cont++;
    }



    public Date getData() {
        return data;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Pergunta getPergunta() {
        return pergunta;
    }

    public void setPergunta(Pergunta pergunta) {
        this.pergunta = pergunta;
    }

    public int getId() {
        return id;
    }
}
