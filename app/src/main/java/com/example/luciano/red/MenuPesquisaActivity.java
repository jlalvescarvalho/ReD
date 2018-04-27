package com.example.luciano.red;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.luciano.red.negocio.entidade.Cliente;

public class MenuPesquisaActivity extends AppCompatActivity {

    private GridView gridView;

    String [] web = {
            "SKU",
            "Ativacao",
            "SOVI",
            "GDM",
            "Preço"

    };

    int [] imageId = {
            R.drawable.cocacola_newcoca_sku,
            R.drawable.coca_cola_ativacao,
            R.drawable.coca_coletiva_produtos_sovi,
            R.drawable.gdm,
            R.drawable.preco
    };

    Object [] telas = {SKUActivity.class, AtivacaoActivity.class, SoviActivity.class, GDMActivity.class, precoActivity.class};


    Cliente cliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_pesquisa);



        cliente = (Cliente)getIntent().getSerializableExtra("cliente");

        setTitle(cliente.getNome().toString());

        CustomGrid adapter = new CustomGrid(MenuPesquisaActivity.this, web, imageId);
        gridView = (GridView)findViewById(R.id.gridMenuPesquisa);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent it = new Intent(MenuPesquisaActivity.this, (Class<Activity>) telas[position]);
                it.putExtra("cliente", cliente);
                startActivity(it);

            }
        });



    }
}
