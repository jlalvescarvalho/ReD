package com.example.luciano.red.repositorio;

import com.example.luciano.red.negocio.entidade.Cliente;

import java.util.ArrayList;

public class RepositorioCliente {

    private ArrayList<Cliente> listaClientes = new ArrayList<>();

    public RepositorioCliente() {
        this.listaClientes = new ArrayList<>();
    }

    public void cadastrar(Cliente cliente){
        this.listaClientes.add(cliente);
    }

    public ArrayList<Cliente> recuperarTodos(){
        return this.listaClientes;
    }

    public Cliente recuperar(int codigo){
        for (Cliente c: listaClientes){
            if(c.getCodigo() == codigo){
                return c;
            }
        }
        return null;
    }

    public void atualizarCliente(int indice, Cliente c){
        this.listaClientes.set(indice, c);
    }

    public int deletar(Cliente cliente){
        for (Cliente c: listaClientes){
            if (c.getCodigo() == cliente.getCodigo()){
                listaClientes.remove(c);
                return 0;
            }
        }
        return 1;
    }

    public void deletarTudo() {
        this.listaClientes = new ArrayList<>();
    }
}
