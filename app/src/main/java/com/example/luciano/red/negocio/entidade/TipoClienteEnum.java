package com.example.luciano.red.negocio.entidade;

/**
 * Created by luciano on 04/04/2018.
 */

public enum TipoClienteEnum {

    AS1_4(524), Mercearia(39), Lanchonete(534), Bar(164), Restaurante(525), Conveniencia(32), Atacado(11);

    private final int subcanal;

    private TipoClienteEnum(int subcanal){
        this.subcanal = subcanal;
    }

    public int getSubcanal(){
        return subcanal;
    }

}
