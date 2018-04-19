package com.example.luciano.red.negocio;

import com.example.luciano.red.negocio.entidade.Cliente;
import com.example.luciano.red.repositorio.RepositorioCliente;

import java.util.ArrayList;

/**
 * Created by luciano on 04/04/2018.
 */

public class NegocioCliente {

    private RepositorioCliente repositorioCliente;
    private static NegocioCliente mySelf;

    public NegocioCliente() {
        this.repositorioCliente = new RepositorioCliente();
    }

    public static NegocioCliente getInstance(){
        if(mySelf == null){
            mySelf = new NegocioCliente();
        }
        return mySelf;
    }

    public void cadastrarCliente(Cliente cliente){
        repositorioCliente.cadastrar(cliente);
    }

    public Cliente recuperarCliente(int codigo){
        return repositorioCliente.recuperar(codigo);
    }

    public ArrayList<Cliente> recuperarTodos(){
        return repositorioCliente.recuperarTodos();
    }

    public void deletarTudo() {
        repositorioCliente.deletarTudo();
    }
}
