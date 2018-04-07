package com.example.luciano.red;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class MenuPesquisaActivity extends AppCompatActivity {

    private GridView gridView;

    String [] web = {
            "SKU",
            "Ativação",
            "SOVI"

    };
    int [] imageId = {
            R.drawable.cocacola_newcoca_sku,
            R.drawable.coca_cola_ativacao,
            R.drawable.coca_coletiva_produtos_sovi
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_pesquisa);

        CustomGrid adapter = new CustomGrid(MenuPesquisaActivity.this, web, imageId);
        gridView = (GridView)findViewById(R.id.gridMenuPesquisa);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(MenuPesquisaActivity.this, "You Clicked at " +web[+ position], Toast.LENGTH_SHORT).show();

            }
        });



    }
}
