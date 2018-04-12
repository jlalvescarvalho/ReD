package com.example.luciano.red;

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
import com.example.luciano.red.negocio.entidade.Pergunta;
import com.example.luciano.red.negocio.entidade.Preco;
import com.example.luciano.red.negocio.entidade.SKU;
import com.example.luciano.red.negocio.entidade.Sovi;
import com.example.luciano.red.negocio.entidade.TipoClienteEnum;
import com.example.luciano.red.negocio.entidade.TipoPerguntaEnum;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CrudPerguntasActivity extends AppCompatActivity {

    private ImageButton imgSearch;
    private EditText edtPergunta;
    private ListView lstPerguntas;
    private Fachada fachada;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crud_perguntas);

        fachada = new Fachada();
        imgSearch = (ImageButton)findViewById(R.id.imgSearchPergunta);
        edtPergunta = (EditText)findViewById(R.id.edt_pergunta);
        lstPerguntas = (ListView)findViewById(R.id.lstPerguntas);

        ArrayList<Pergunta> listaPerguntas = fachada.recuperarTodasPerguntas();
        ArrayAdapter<Pergunta> adapterPerguntas = new ArrayAdapter<Pergunta>(this, android.R.layout.simple_list_item_1);
        lstPerguntas.setAdapter(adapterPerguntas);
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

                Pergunta p = verificaTipoPergunta(pergunta,postuacao,tipoCliente, tipoPergunta);

                fachada.cadastrarPergunta(p);//Aqui usa o método que fará um insert no banco

                linha = lerArq.readLine(); // lê da segunda até a última linha
            }

            arq.close();
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
        }
    }

    public Pergunta verificaTipoPergunta(String pergunta, String pontos,String tipoCliente, String tipoPergunta){
        Pergunta p = null;
        Double pontuacao = Double.parseDouble(pontos);
        TipoClienteEnum tce = verificaTipoCliente(tipoCliente);

        if(TipoPerguntaEnum.ativação.toString().equals(tipoPergunta)){
            p = new Ativacao(pergunta, pontuacao, tce, TipoPerguntaEnum.ativação);
        }else if(TipoPerguntaEnum.GDM.toString().equals(tipoPergunta)){
            p = new GDM(pergunta, pontuacao, tce, TipoPerguntaEnum.GDM);
        }else if(TipoPerguntaEnum.Portifólio.toString().equals(tipoPergunta)){
            p = new SKU(pergunta,pontuacao,tce, TipoPerguntaEnum.Portifólio);
        }else if(TipoPerguntaEnum.sovi.toString().equals(tipoPergunta)){
            p = new Sovi(pergunta,pontuacao, tce, TipoPerguntaEnum.sovi);
        }else if(TipoPerguntaEnum.preço.toString().equals(tipoPergunta)){
            p = new Preco(pergunta, pontuacao, tce, TipoPerguntaEnum.preço);
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
                String arq = "";
                importarPerguntas(arq);
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
