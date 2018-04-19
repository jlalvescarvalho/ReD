package com.example.luciano.red.negocio.entidade;

public abstract class Auditoria {

    private int id;
    private String pergunta;
    private double pontuacao;
    private boolean resposta;
    private TipoClienteEnum tipoCliente;
    private TipoPerguntaEnum tipoPergunta;
    private int cont = 0;

    public Auditoria(String pergunta, double pontuacao, TipoClienteEnum tipoCliente, TipoPerguntaEnum tipoPergunta) {
        this.id = ++cont;
        this.pergunta = pergunta;
        this.pontuacao = pontuacao;
        this.tipoCliente = tipoCliente;
        this.tipoPergunta = tipoPergunta;
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
