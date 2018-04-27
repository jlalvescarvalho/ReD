package com.example.luciano.red;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.luciano.red.fachada.Fachada;
import com.example.luciano.red.negocio.entidade.Auditoria;

import java.util.ArrayList;

/**
 * Created by lucia on 21/04/2018.
 */

public class AdapterClienteNotaItem extends BaseAdapter {

    private ArrayList<Auditoria> listaClientesAuditados;
    private Activity act;

    public AdapterClienteNotaItem(ArrayList<Auditoria> listaClientesAuditados, Activity act) {
        this.listaClientesAuditados = listaClientesAuditados;
        this.act = act;
    }

    @Override
    public int getCount() {
        return this.listaClientesAuditados.size();
    }

    @Override
    public Object getItem(int i) {
        return this.listaClientesAuditados.get(i);
    }

    @Override
    public long getItemId(int i) {
        return this.listaClientesAuditados.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = act.getLayoutInflater().inflate(R.layout.layout_item_clientes_notas, viewGroup, false);
        Auditoria a = listaClientesAuditados.get(i);

        //Pegando referencias da vivew
        TextView txtCliente = (TextView)v.findViewById(R.id.txt_cliente_nota);
        TextView txtNota = (TextView)v.findViewById(R.id.txt_nota_notas);

        //Populando view
        txtCliente.setText(a.getCliente().toString());
        txtNota.setText(String.valueOf(recuperarNotaCliente(a.getCliente().getCodigo()))+" %");


        return v;
    }

    public double recuperarNotaCliente(int codigo){
        return Fachada.getInstance().calcularNotaPorCliente(codigo);
    }
}
