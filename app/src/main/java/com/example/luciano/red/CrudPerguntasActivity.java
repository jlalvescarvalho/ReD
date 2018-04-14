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
import com.example.luciano.red.negocio.entidade.Ativacao;
import com.example.luciano.red.negocio.entidade.GDM;
import com.example.luciano.red.negocio.entidade.Auditoria;
import com.example.luciano.red.negocio.entidade.Preco;
import com.example.luciano.red.negocio.entidade.SKU;
import com.example.luciano.red.negocio.entidade.Sovi;
import com.example.luciano.red.negocio.entidade.TipoClienteEnum;
import com.example.luciano.red.negocio.entidade.TipoPerguntaEnum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CrudPerguntasActivity extends AppCompatActivity {

    private ImageButton imgSearch;
    private EditText edtPergunta;
    private ListView lstPerguntas;
    private Fachada fachada;
    private static final int READ_REQUEST_CODE = 42;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crud_perguntas);

        fachada = new Fachada();
        imgSearch = (ImageButton)findViewById(R.id.imgSearchPergunta);
        edtPergunta = (EditText)findViewById(R.id.edt_pergunta);
        lstPerguntas = (ListView)findViewById(R.id.lstPerguntas);

        preencherListView();

    }

    public void preencherListView(){

        ArrayList<Auditoria> listaAuditorias = fachada.recuperarTodasPerguntas();
        ArrayAdapter<Auditoria> adapterPerguntas = new ArrayAdapter<Auditoria>(this,android.R.layout.simple_list_item_1, listaAuditorias);
        lstPerguntas.setAdapter(adapterPerguntas);
    }



    public Auditoria verificaTipoPergunta(String pergunta, String pontos, String tipoCliente, String tipoPergunta){
        Auditoria p = null;
        Double pontuacao = Double.parseDouble(pontos);
        TipoClienteEnum tce = verificaTipoCliente(tipoCliente);

        if(tipoPergunta.equals(TipoPerguntaEnum.ativação.toString())){
            p = new Ativacao(pergunta, pontuacao, tce, TipoPerguntaEnum.ativação);
        }else if(tipoPergunta.equals(TipoPerguntaEnum.GDM.toString())){
            p = new GDM(pergunta, pontuacao, tce, TipoPerguntaEnum.GDM);
        }else if(tipoPergunta.equals(TipoPerguntaEnum.Portifólio.toString())){
            p = new SKU(pergunta,pontuacao,tce, TipoPerguntaEnum.Portifólio);
        }else if(tipoPergunta.equals(TipoPerguntaEnum.sovi.toString())){
            p = new Sovi(pergunta,pontuacao, tce, TipoPerguntaEnum.sovi);
        }else if(tipoPergunta.equals(TipoPerguntaEnum.preco.toString())){
            p = new Preco(pergunta, pontuacao, tce, TipoPerguntaEnum.preco);
        }
        return p;
    }

    public TipoClienteEnum verificaTipoCliente(String tipoCliente){

        if(TipoClienteEnum.mercearia.toString().equals(tipoCliente)){
            return TipoClienteEnum.mercearia;
        }else if(TipoClienteEnum.AS1a4.toString().equals(tipoCliente)){
            return TipoClienteEnum.AS1a4;
        }else if(TipoClienteEnum.bar.toString().equals(tipoCliente)){
            return TipoClienteEnum.bar;
        }else if(TipoClienteEnum.lanchonete.toString().equals(tipoCliente)){
            return TipoClienteEnum.lanchonete;
        }else if(TipoClienteEnum.restaurante.toString().equals(tipoCliente)){
            return TipoClienteEnum.restaurante;
        }else if(TipoClienteEnum.conveniencia.toString().equals(tipoCliente)){
            return TipoClienteEnum.conveniencia;
        }else if(TipoClienteEnum.atacado.toString().equals(tipoCliente)){
            return TipoClienteEnum.atacado;
        }
        return null;
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
                Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
                intent.addCategory(Intent.CATEGORY_OPENABLE);
                intent.setType("text/*");
                startActivityForResult(intent, READ_REQUEST_CODE);

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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == READ_REQUEST_CODE && resultCode == Activity.RESULT_OK) {

            Uri uri = null;
            if(data != null) {
                uri = data.getData();
                try {
                    readTextFromUri(uri);
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

            Auditoria p = verificaTipoPergunta(pergunta,postuacao,tipoCliente, tipoPergunta);

            fachada.cadastrarPergunta(p);//Aqui usa o método que fará um insert no banco

            preencherListView();
        }



    }


}
