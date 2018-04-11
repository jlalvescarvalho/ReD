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

import com.example.luciano.red.fachada.Fachada;
import com.example.luciano.red.negocio.entidade.Pergunta;
import com.example.luciano.red.negocio.entidade.SKU;
import com.example.luciano.red.negocio.entidade.TipoClienteEnum;
import com.example.luciano.red.negocio.entidade.TipoPerguntaEnum;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CrudPerguntasActivity extends AppCompatActivity {

    ImageButton imgSearch;
    EditText edtPergunta;
    ListView lstPerguntas;
    Fachada fachada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crud_perguntas);

        fachada = new Fachada();
        imgSearch = (ImageButton)findViewById(R.id.imgSearchPergunta);
        edtPergunta = (EditText)findViewById(R.id.edt_pergunta);
        lstPerguntas = (ListView)findViewById(R.id.lstPerguntas);
    }

    public void importarPerguntas(String nome){
        try {
            FileReader arq = new FileReader(nome);
            BufferedReader lerArq = new BufferedReader(arq);
            String linha = lerArq.readLine();
            while (linha != null) {

                String[] dados = linha.split(";"); //Separa os campos através do separador ';'
                String pergunta = dados[0];
                String postuacao = dados[1];
                String tipoCliente = dados[2];
                String tipoPergunta = dados[3];


                fachada.cadastrarPergunta(); //Aqui usa o método que fará um insert no banco

                linha = lerArq.readLine(); // lê da segunda até a última linha
            }
            arq.close();
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
        }
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
            // ação para para opção add do meniu
            case R.id.addPergunta:
                Toast.makeText(this, "Add selecionado", Toast.LENGTH_SHORT)
                        .show();
                break;
            // ação para opção importar do menu
            case R.id.importPergunta:
                Toast.makeText(this, "Importar selecionado", Toast.LENGTH_SHORT)
                        .show();
                break;
            // ação para opção apagar tudo do menu
            case R.id.deletPergunta:
                Toast.makeText(this, "Apagar tudo selecionado", Toast.LENGTH_SHORT)
                        .show();
                break;
            default:
                break;
        }

        return true;
    }
}
