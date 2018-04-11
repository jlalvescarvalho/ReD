package com.example.luciano.red.negocio.entidade;

public abstract class Pergunta {

    private int id;
    private String pergunta;
    private double pontuacao;
    private boolean resposta;
    private TipoClienteEnum tipoCliente;
    private TipoPerguntaEnum tipoPergunta;

    public Pergunta(String pergunta, double pontuacao, TipoClienteEnum tipoCliente, TipoPerguntaEnum tipoPergunta) {
        this.pergunta = pergunta;
        this.pontuacao = pontuacao;
        this.tipoCliente = tipoCliente;
        this.tipoPergunta = tipoPergunta;
    }

    public void importar(){

    }

    public double getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(double pontuacao) {
        this.pontuacao = pontuacao;
    }

    public int getId() {
        return id;
    }

    public String getPergunta() {
        return pergunta;
    }

    public boolean getResposta() {
        return resposta;
    }

    public void setResposta(boolean resposta) {
        this.resposta = resposta;
    }

    @Override
    public String toString() {
        return this.pergunta+" ";
    }



}
