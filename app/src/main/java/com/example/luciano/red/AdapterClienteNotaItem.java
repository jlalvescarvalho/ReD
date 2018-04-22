package com.example.luciano.red;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.luciano.red.fachada.Fachada;
import com.example.luciano.red.negocio.entidade.Cliente;

import java.util.ArrayList;

/**
 * Created by lucia on 21/04/2018.
 */

public class AdapterClienteNotaItem extends BaseAdapter {

    private ArrayList<Cliente> listaClientes;
    private Activity act;

    public AdapterClienteNotaItem(ArrayList<Cliente> listaClientes, Activity act) {
        this.listaClientes = listaClientes;
        this.act = act;
    }

    @Override
    public int getCount() {
        return this.listaClientes.size();
    }

    @Override
    public Object getItem(int i) {
        return this.listaClientes.get(i);
    }

    @Override
    public long getItemId(int i) {
        return this.listaClientes.get(i).getCodigo();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = act.getLayoutInflater().inflate(R.layout.layout_item_clientes_notas, viewGroup, false);
        Cliente c = listaClientes.get(i);

        //Pegando referencias da vivew
        TextView txtCliente = (TextView)v.findViewById(R.id.txt_cliente_nota);
        TextView txtNota = (TextView)v.findViewById(R.id.txt_nota_notas);

        //Populando view
        txtCliente.setText(c.toString());
        txtNota.setText(String.valueOf(recuperarNotaCliente(c.getCodigo()))+" %");


        return v;
    }

    public double recuperarNotaCliente(int codigo){
        return Fachada.getInstance().calcularNotaPorCliente(codigo);
    }
}
