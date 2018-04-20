package com.example.luciano.red.negocio;

import com.example.luciano.red.negocio.entidade.Ativacao;
import com.example.luciano.red.negocio.entidade.Pergunta;
import com.example.luciano.red.negocio.entidade.GDM;
import com.example.luciano.red.negocio.entidade.Preco;
import com.example.luciano.red.negocio.entidade.SKU;
import com.example.luciano.red.negocio.entidade.Sovi;
import com.example.luciano.red.negocio.entidade.TipoClienteEnum;
import com.example.luciano.red.negocio.entidade.TipoPerguntaEnum;
import com.example.luciano.red.repositorio.RepositorioPergunta;

import java.util.ArrayList;

/**
 * Created by luciano on 04/04/2018.
 */

public class NegocioPergunta {

    private RepositorioPergunta repositorioPergunta;
    private static NegocioPergunta mySelf;

    public NegocioPergunta() {
        this.repositorioPergunta = new RepositorioPergunta();
    }

    public static NegocioPergunta getInstance(){
        if(mySelf == null){
            mySelf = new NegocioPergunta();
        }
        return mySelf;
    }

    public void adicionarPergunta(Pergunta pergunta){
        repositorioPergunta.adicionarPergunta(pergunta);
    }

    public void adicionarVariasPerguntas(ArrayList<Pergunta> lista){
        for(Pergunta p: lista){
            repositorioPergunta.adicionarPergunta(p);
        }
    }

    public ArrayList<Pergunta> recuperarTodas(){
        return repositorioPergunta.recuperarTodaPerguntas();
    }

    public Pergunta verificaTipoPergunta(String pergunta, String pontos, String tipoCliente, String tipoPergunta){
        Pergunta p = null;
        Double pontuacao = Double.parseDouble(pontos);
        TipoClienteEnum tce = verificaTipoCliente(tipoCliente);

        if(tipoPergunta.equals(TipoPerguntaEnum.Ativacao.toString())){
            p = new Ativacao(pergunta, pontuacao, tce, TipoPerguntaEnum.Ativacao);
        }else if(tipoPergunta.equals(TipoPerguntaEnum.GDM.toString())){
            p = new GDM(pergunta, pontuacao, tce, TipoPerguntaEnum.GDM);
        }else if(tipoPergunta.equals(TipoPerguntaEnum.Portifolio.toString())){
            p = new SKU(pergunta,pontuacao,tce, TipoPerguntaEnum.Portifolio);
        }else if(tipoPergunta.equals(TipoPerguntaEnum.Sovi.toString())){
            p = new Sovi(pergunta,pontuacao, tce, TipoPerguntaEnum.Sovi);
        }else if(tipoPergunta.equals(TipoPerguntaEnum.Preco.toString())){
            p = new Preco(pergunta, pontuacao, tce, TipoPerguntaEnum.Preco);
        }
        return p;
    }

    public TipoClienteEnum verificaTipoCliente(String tipoCliente){

        if(TipoClienteEnum.mercearia.toString().equals(tipoCliente)){
            return TipoClienteEnum.mercearia;
        }else if(TipoClienteEnum.AS1a4.toString().equals(tipoCliente)){
            return TipoClienteEnum.AS1a4;
        }else if(TipoClienteEnum.bar.toString().equals(tipoCliente)){
            return TipoClienteEnum.bar;
        }else if(TipoClienteEnum.lanchonete.toString().equals(tipoCliente)){
            return TipoClienteEnum.lanchonete;
        }else if(TipoClienteEnum.restaurante.toString().equals(tipoCliente)){
            return TipoClienteEnum.restaurante;
        }else if(TipoClienteEnum.conveniencia.toString().equals(tipoCliente)){
            return TipoClienteEnum.conveniencia;
        }else if(TipoClienteEnum.atacado.toString().equals(tipoCliente)){
            return TipoClienteEnum.atacado;
        }
        return null;
    }

    public void deletarTudo(){
        repositorioPergunta.deletarTudo();
    }

}
