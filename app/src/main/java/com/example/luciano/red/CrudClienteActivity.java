package com.example.luciano.red;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

public class CrudClienteActivity extends AppCompatActivity {

    ImageButton btSearch;
    EditText edtPesquisaCliente;
    ListView listViewClientes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crud_cliente);

        btSearch = (ImageButton)findViewById(R.id.imgBt_pesquisa);
        edtPesquisaCliente = (EditText)findViewById(R.id.edt_cliente);
        listViewClientes = (ListView)findViewById(R.id.lst_Crud_Cliente);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.meumenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // ação para para opção add do meniu
            case R.id.addCliente:
                Toast.makeText(this, "Add selecionado", Toast.LENGTH_SHORT)
                        .show();
                break;
            // ação para opção importar do menu
            case R.id.importCliente:
                Toast.makeText(this, "Importar selecionado", Toast.LENGTH_SHORT)
                        .show();
                break;
            // ação para opção apagar tudo do menu
            case R.id.deletCliente:
                Toast.makeText(this, "Apagar tudo selecionado", Toast.LENGTH_SHORT)
                        .show();
                break;
            default:
                break;
        }

        return true;
    }
}
