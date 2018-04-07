package com.example.luciano.red;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

import com.example.luciano.red.fachada.Fachada;
import com.example.luciano.red.negocio.entidade.Cliente;

import java.util.ArrayList;

public class ClienteActivity extends AppCompatActivity {

    private Button btSearch;
    private ListView listViewCliente;
    private Fachada fachada;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cliente);

        btSearch = findViewById(R.id.btSearch);
        listViewCliente = findViewById(R.id.lstViewCliente);
        ArrayList<Cliente> clientes = fachada.getInstance().recuperarTodosClientes();
        ArrayAdapter<Cliente> AdapterClientes = new ArrayAdapter<Cliente>(ClienteActivity.this, android.R.layout.simple_expandable_list_item_2);

        listViewCliente.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });
    }

    public void OnClick(View view){
        Intent it = new Intent(this, MenuPesquisaActivity.class);
        startActivity(it);
    }
}
