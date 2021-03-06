package com.example.luciano.red;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.v7.app.ActionBar;
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
import com.example.luciano.red.negocio.entidade.Pergunta;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CrudPerguntasActivity extends AppCompatActivity {

    private EditText edtPergunta;
    private ListView lstPerguntas;
    private static final int READ_REQUEST_CODE = 42;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crud_perguntas);

        ActionBar bar = getSupportActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#000000")));

        edtPergunta = (EditText)findViewById(R.id.edt_pergunta);
        lstPerguntas = (ListView)findViewById(R.id.lstPerguntas);

        preencherListView();

    }

    public void preencherListView(){

        ArrayList<Pergunta> listaPerguntas = Fachada.getInstance().recuperarTodasPerguntas();
        ArrayAdapter<Pergunta> adapterPerguntas = new ArrayAdapter<Pergunta>(this,android.R.layout.simple_list_item_1, listaPerguntas);
        lstPerguntas.setAdapter(adapterPerguntas);
    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menuperguntas, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.addPergunta:
                Intent it = new Intent(this, CadastroPerguntaActivity.class);
                startActivity(it);
                preencherListView();
                break;
            case R.id.importPergunta:
                Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
                intent.addCategory(Intent.CATEGORY_OPENABLE);
                intent.setType("text/*");
                startActivityForResult(intent, READ_REQUEST_CODE);

                break;
            // ação para opção apagar tudo do menu
            case R.id.deletPergunta:
                Toast.makeText(this, "Apagar tudo", Toast.LENGTH_SHORT)
                        .show();
                Fachada.getInstance().deletarTudoAuditoria();
                preencherListView();
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
                    Toast.makeText(this, "Perguntas importadas com sucesso !", Toast.LENGTH_SHORT).show();
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
            String pergunta = dados[0];
            String postuacao = dados[1];
            String tipoCliente = dados[2];
            String tipoPergunta = dados[3];

            Pergunta p = Fachada.getInstance().verificaTipoPergunta(pergunta,postuacao,tipoCliente,tipoPergunta);

            Fachada.getInstance().cadastrarPergunta(p);


        }


    }



}
