package com.example.luciano.red;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.example.luciano.red.fachada.Fachada;
import com.example.luciano.red.negocio.entidade.Cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CrudClienteActivity extends AppCompatActivity {

    ImageButton btSearch;
    EditText edtPesquisaCliente;
    ListView listViewClientes;

    private static final int READ_REQUEST_CODE = 42;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crud_cliente);

        btSearch = (ImageButton)findViewById(R.id.imgBt_pesquisa);
        edtPesquisaCliente = (EditText)findViewById(R.id.edt_cliente);
        listViewClientes = (ListView)findViewById(R.id.lst_Crud_Cliente);

       preencherListView();
    }

    public void preencherListView(){

        ArrayList<Cliente> listaClientes = Fachada.getInstance().recuperarTodosClientes();
        ArrayAdapter<Cliente> adapterClientes = new ArrayAdapter<Cliente>(this, android.R.layout.simple_list_item_1,listaClientes);
        listViewClientes.setAdapter(adapterClientes);
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
                Intent it = new Intent(this,  CadastroClienteActivity.class);
                startActivity(it);
                preencherListView();
                break;
            // ação para opção importar do menu
            case R.id.importCliente:
                Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
                intent.addCategory(Intent.CATEGORY_OPENABLE);
                intent.setType("text/*");
                startActivityForResult(intent, READ_REQUEST_CODE);

                break;
            // ação para opção apagar tudo do menu
            case R.id.deletCliente:
                Fachada.getInstance().deletarTudoCliente();
                preencherListView();
                Toast.makeText(this, "Tudo Apagado", Toast.LENGTH_SHORT)
                        .show();
                break;
            default:
                break;
        }

        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == READ_REQUEST_CODE && resultCode == Activity.RESULT_OK) {

            Uri uri = null;
            if(data != null) {
                uri = data.getData();
                try {
                    readTextFromUri(uri);
                    Toast.makeText(this, "Clientes importadas com sucesso !", Toast.LENGTH_SHORT).show();
                    preencherListView();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    private void readTextFromUri(Uri uri) throws IOException {

        InputStream inputStream = getContentResolver().openInputStream(uri);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line;

        while ((line = reader.readLine()) != null) {
            String[] dados = line.split(";"); //Separa os campos através do separador ';'
            String codigo = dados[0];
            String razao = dados[1];
            String logradouro = dados[2];
            String cidade = dados[3];
            String subCanal = dados[4];

            Cliente c = new Cliente(Integer.parseInt(codigo),razao,logradouro,cidade,Integer.parseInt(subCanal));

            Fachada.getInstance().cadastrarCliente(c);



        }


    }
}
