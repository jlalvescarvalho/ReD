package com.example.luciano.red;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.luciano.red.fachada.Fachada;
import com.example.luciano.red.negocio.entidade.Cliente;

import java.io.Serializable;
import java.util.ArrayList;

public class ClienteActivity extends AppCompatActivity {
    private Button btSearch;
    private ListView listViewCliente;
    private Cliente cliente;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cliente);

        btSearch = findViewById(R.id.btSearch);
        listViewCliente = findViewById(R.id.lstViewCliente);

        ArrayList<Cliente> clientes = Fachada.getInstance().recuperarTodosClientes();
        ArrayAdapter<Cliente> AdapterClientes = new ArrayAdapter<Cliente>(ClienteActivity.this, android.R.layout.simple_list_item_1, clientes);
        listViewCliente.setAdapter(AdapterClientes);

        listViewCliente.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                cliente = (Cliente) listViewCliente.getItemAtPosition(i);

                Intent it = new Intent(ClienteActivity.this, MenuPesquisaActivity.class);
                it.putExtra("cliente", cliente);
                startActivity(it);
            }
        });
    }
}