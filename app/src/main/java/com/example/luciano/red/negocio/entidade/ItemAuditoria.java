package com.example.luciano.red.negocio.entidade;

/**
 * Created by luciano on 29/04/2018.
 */

public class ItemAuditoria {

    private int id;
    private Pergunta p;
    private Cliente c;
    private int cont = 0;

    public ItemAuditoria(Pergunta p, Cliente c) {
        this.cont ++;
        this.p = p;
        this.c = c;
    }

    public int getId() {
        return id;
    }

    public Pergunta getP() {
        return p;
    }

    public void setP(Pergunta p) {
        this.p = p;
    }

    public Cliente getC() {
        return c;
    }
}
