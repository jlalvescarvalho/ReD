package com.example.luciano.red;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.luciano.red.fachada.Fachada;
import com.example.luciano.red.negocio.entidade.Cliente;

import java.util.ArrayList;

public class NotaClientesActivity extends AppCompatActivity {

    private ListView listView;
    private EditText edt_pesquisa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nota_clientes);

        listView = (ListView)findViewById(R.id.listView_Clientes_Notas);
        edt_pesquisa = (EditText)findViewById(R.id.edt_pesquisa_cliente_nota);

        ArrayList<Cliente> listaClientes = Fachada.getInstance().recuperarTodosClientes();

        AdapterClienteNotaItem notaItem = new AdapterClienteNotaItem(listaClientes, this);
        listView.setAdapter(notaItem);
    }
}
