package com.example.luciano.red.negocio.entidade;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by luciano on 04/04/2018.
 */

public class Auditoria {

    private int id;
    private ArrayList<Pergunta> perguntasAuditadas;
    private Date data;
    private Cliente cliente;
    private int cont = 0;

    public Auditoria(ArrayList<Pergunta> perguntasAuditadas, Cliente cliente) {
        this.id = cont;
        this.perguntasAuditadas = perguntasAuditadas;
        this.data = new Date();
        this.cliente = cliente;
        this.cont++;
    }

    public ArrayList<Pergunta> getPerguntasAuditadas() {
        return perguntasAuditadas;
    }

    public void setPerguntasAuditadas(ArrayList<Pergunta> perguntasAuditadas) {
        this.perguntasAuditadas = perguntasAuditadas;
    }

    public Date getData() {
        return data;
    }

    public int getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }
}
