package com.example.luciano.red.negocio.entidade;

/**
 * Created by luciano on 11/04/2018.
 */

public class GDM extends Pergunta {

    public GDM(String pergunta, double pontuacao, TipoClienteEnum tipoCliente, TipoPerguntaEnum tipoPergunta) {
        super(pergunta, pontuacao, tipoCliente, tipoPergunta);
    }

    @Override
    public String toString() {
        return this.getPergunta();
    }
}
