package com.example.luciano.red.negocio.entidade;

import java.io.Serializable;

public class Cliente implements Serializable{

    private int codigo;
    private String nome;
    private String logradouro;
    private String cidade;
    private int subCanal;

    public Cliente(int codigo, String nome, String logradouro, String cidade, int subCanal) {
        this.codigo = codigo;
        this.nome = nome;
        this.logradouro = logradouro;
        this.cidade = cidade;
        this.subCanal = subCanal;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public int getSubCanal() {
        return subCanal;
    }

    public void setSubCanal(int subCanal) {
        this.subCanal = subCanal;
    }

    @Override
    public String toString() {
        return ""+this.codigo+" |  "+this.nome;
    }
}
