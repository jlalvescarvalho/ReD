package com.example.luciano.red.negocio.entidade;

/**
 * Created by luciano on 04/04/2018.
 */

public enum TipoClienteEnum {

    AS1a4(524), mercearia(39), lanchonete(534), bar(164), restaurante(525), conveniencia(0.0), atacado(11);

    private final double subcanal;

    private TipoClienteEnum(double subcanal){
        this.subcanal = subcanal;
    }

    public double getSubcanal(){
        return subcanal;
    }

}
