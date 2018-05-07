package com.example.luciano.red.negocio;

import com.example.luciano.red.fachada.Fachada;
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

        if(TipoClienteEnum.Mercearia.toString().equals(tipoCliente)){
            return TipoClienteEnum.Mercearia;
        }else if(TipoClienteEnum.AS1_4.toString().equals(tipoCliente)){
            return TipoClienteEnum.AS1_4;
        }else if(TipoClienteEnum.Bar.toString().equals(tipoCliente)){
            return TipoClienteEnum.Bar;
        }else if(TipoClienteEnum.Lanchonete.toString().equals(tipoCliente)){
            return TipoClienteEnum.Lanchonete;
        }else if(TipoClienteEnum.Restaurante.toString().equals(tipoCliente)){
            return TipoClienteEnum.Restaurante;
        }else if(TipoClienteEnum.Conveniencia.toString().equals(tipoCliente)){
            return TipoClienteEnum.Conveniencia;
        }else if(TipoClienteEnum.Atacado.toString().equals(tipoCliente)){
            return TipoClienteEnum.Atacado;
        }
        return null;
    }

    public void deletarTudo(){
        repositorioPergunta.deletarTudo();
    }



    public ArrayList retornaPerguntasPorTipoECanal(int subCanal, String tipoPergunta){

        ArrayList<Pergunta> todasPerguntas = recuperarTodas();
        ArrayList perguntasFiltradas = new ArrayList();

        for (int i = 0; i < todasPerguntas.size(); i++){
            if(todasPerguntas.get(i).getTipoCliente().getSubcanal() == subCanal){
                if(tipoPergunta.equals(todasPerguntas.get(i).getTipoPergunta().toString())){
                    perguntasFiltradas.add(todasPerguntas.get(i));
                }

            }
        }
        return perguntasFiltradas;
    }

    public ArrayList<Pergunta> retornarPerguntaPorSubCanal(int subcanal){

        ArrayList<Pergunta> perguntasPorSubCanal = recuperarTodas();
        ArrayList<Pergunta> perguntasFiltradasPorSubcanal = new ArrayList<>();

        for (int i = 0; i < perguntasPorSubCanal.size(); i++){
            if(perguntasPorSubCanal.get(i).getTipoCliente().getSubcanal() == subcanal){
                    perguntasFiltradasPorSubcanal.add(perguntasPorSubCanal.get(i));
            }
        }
        return perguntasFiltradasPorSubcanal;
    }

}
