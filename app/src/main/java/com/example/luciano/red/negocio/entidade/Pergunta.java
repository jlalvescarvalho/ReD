package com.example.luciano.red.negocio.entidade;

public abstract class Pergunta {

    private int id;
    private String pergunta;
    private double pontuacao;
    private  int resposta;
    private TipoClienteEnum tipoCliente;
    private TipoPerguntaEnum tipoPergunta;
    private int cont = 0;

    public Pergunta(String pergunta, double pontuacao, TipoClienteEnum tipoCliente, TipoPerguntaEnum tipoPergunta) {
        this.id = ++cont;
        this.pergunta = pergunta;
        this.pontuacao = pontuacao;
        this.tipoCliente = tipoCliente;
        this.tipoPergunta = tipoPergunta;
    }

    public double getPontuacao() {
        return pontuacao;
    }

    public int getId() {
        return id;
    }

    public String getPergunta() {
        return pergunta;
    }

    public void setResposta(int resposta) {

        if (resposta > 0){ this.pontuacao = 0;}

        this.resposta = resposta;

    }

    public TipoClienteEnum getTipoCliente() {
        return tipoCliente;
    }

    public TipoPerguntaEnum getTipoPergunta() {
        return tipoPergunta;
    }

    @Override
    public String toString() {
        return this.pergunta+" ";
    }



}
