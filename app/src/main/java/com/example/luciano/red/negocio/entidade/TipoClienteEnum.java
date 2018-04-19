package com.example.luciano.red.negocio.entidade;

/**
 * Created by luciano on 04/04/2018.
 */

public enum TipoClienteEnum {

    AS1a4(524), mercearia(39), lanchonete(534), bar(164), restaurante(525), conveniencia(32), atacado(11);

    private final int subcanal;

    private TipoClienteEnum(int subcanal){
        this.subcanal = subcanal;
    }

    public int getSubcanal(){
        return subcanal;
    }

}
