package com.example.luciano.red.repositorio;

import com.example.luciano.red.negocio.entidade.Ativacao;
import com.example.luciano.red.negocio.entidade.GDM;
import com.example.luciano.red.negocio.entidade.Pergunta;
import com.example.luciano.red.negocio.entidade.Preco;
import com.example.luciano.red.negocio.entidade.SKU;
import com.example.luciano.red.negocio.entidade.Sovi;

import java.util.ArrayList;

/**
 * Created by luciano on 04/04/2018.
 */

public class RepositorioPergunta {

    private ArrayList<Pergunta> listaPerguntas;

    public RepositorioPergunta() {
        this.listaPerguntas = new ArrayList<>();
    }

    public void adicionarPergunta(Pergunta p){
        this.listaPerguntas.add(p);
    }

    public Pergunta recuperarPergunta(int id) {
        for(Pergunta p: listaPerguntas){
            if(p.getId() == id){
                return p;
            }
        }
        return null;
    }

    public void atualizarPergunta(int indice, Pergunta p){
        this.listaPerguntas.set(indice, p);
    }


    public void excluirPergunta(Pergunta p){
        if(listaPerguntas.contains(p)){
            listaPerguntas.remove(p);
        }
    }

    public ArrayList<Pergunta> recuperarTodaPerguntas(){
        return this.listaPerguntas;
    }

    public void deletarTudo(){
        listaPerguntas = new ArrayList<>();
    }

    public ArrayList<Pergunta> recuraTodasPerguntasSovi(){
        ArrayList<Pergunta> listaSovi = new ArrayList<>();

            for (int i = 0; i < listaPerguntas.size(); i++){
                if(listaPerguntas.get(i) instanceof  Sovi){
                    listaSovi.add((Sovi) listaPerguntas.get(i));
                }
            }
            return listaSovi;
    }

    public ArrayList<Pergunta> recuraTodasPerguntasSku(){
        ArrayList<Pergunta> listaSKU = new ArrayList<>();

        for (int i = 0; i < listaPerguntas.size(); i++){
            if(listaPerguntas.get(i) instanceof SKU){
                listaSKU.add((SKU) listaPerguntas.get(i));
            }
        }
        return listaSKU;
    }
    public ArrayList<Pergunta> recuraTodasPerguntasPreco(){
        ArrayList<Pergunta> listaPreco = new ArrayList<>();

        for (int i = 0; i < listaPerguntas.size(); i++){
            if(listaPerguntas.get(i) instanceof Preco){
                listaPreco.add((Preco) listaPerguntas.get(i));
            }
        }
        return listaPreco;
    }

    public ArrayList<Pergunta> recuraTodasPerguntasGDM(){
        ArrayList<Pergunta> listaGDM = new ArrayList<>();

        for (int i = 0; i < listaPerguntas.size(); i++){
            if(listaPerguntas.get(i) instanceof GDM){
                listaGDM.add((GDM) listaPerguntas.get(i));
            }
        }
        return listaGDM;
    }
    public ArrayList<Pergunta> recuraTodasPerguntasAtivacao(){
        ArrayList<Pergunta> listaAtivacao = new ArrayList<>();

        for (int i = 0; i < listaPerguntas.size(); i++){
            if(listaPerguntas.get(i) instanceof Ativacao){
                listaAtivacao.add((Ativacao) listaPerguntas.get(i));
            }
        }
        return listaAtivacao;
    }
}
