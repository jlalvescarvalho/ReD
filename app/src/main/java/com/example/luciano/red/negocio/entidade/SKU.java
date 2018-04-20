package com.example.luciano.red.negocio.entidade;

/**
 * Created by luciano on 07/04/2018.
 */

public class SKU extends Pergunta {

    public SKU(String pergunta, double pontuacao, TipoClienteEnum tipoCliente, TipoPerguntaEnum tipoPergunta) {
        super(pergunta, pontuacao, tipoCliente, tipoPergunta);
    }

    @Override
    public String toString() {
        return this.getPergunta();
    }
}
