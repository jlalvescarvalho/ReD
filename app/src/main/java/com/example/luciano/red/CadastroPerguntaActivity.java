package com.example.luciano.red;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.luciano.red.fachada.Fachada;
import com.example.luciano.red.negocio.entidade.Auditoria;
import com.example.luciano.red.negocio.entidade.TipoClienteEnum;
import com.example.luciano.red.negocio.entidade.TipoPerguntaEnum;

public class CadastroPerguntaActivity extends AppCompatActivity {

    private EditText edt_pergunta;
    private EditText edt_pontuacao;
    private Spinner spn_tipoPergunta;
    private Spinner spn_subCanal;
    private Button btSalvar;

    private String[] tipoPergunta;
    private String[] subCanal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_pergunta);

        edt_pergunta = (EditText) findViewById(R.id.edt_pergunta);
        edt_pontuacao = (EditText) findViewById(R.id.edtPontuacaoP);
        spn_tipoPergunta = (Spinner)findViewById(R.id.spn_TipoPergunta);
        spn_subCanal = (Spinner)findViewById(R.id.spn_subCanal);
        btSalvar = (Button)findViewById(R.id.btSalvarPergunta);
        tipoPergunta = new String[]{"Tipo da pergunta",TipoPerguntaEnum.Portifolio.toString(), TipoPerguntaEnum.Ativacao.toString(), TipoPerguntaEnum.Sovi.toString(), TipoPerguntaEnum.Preco.toString(), TipoPerguntaEnum.GDM.toString()};
        subCanal = new String[]{"Sub-Canal",TipoClienteEnum.AS1a4.toString(), TipoClienteEnum.mercearia.toString(), TipoClienteEnum.lanchonete.toString(), TipoClienteEnum.bar.toString(),TipoClienteEnum.restaurante.toString(),TipoClienteEnum.atacado.toString(),TipoClienteEnum.conveniencia.toString()};




        final ArrayAdapter<String> adapterTipoPergunta = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,tipoPergunta);
        final ArrayAdapter<String> adapterTipoCliente = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,subCanal);

        spn_tipoPergunta.setAdapter(adapterTipoPergunta);
        spn_subCanal.setAdapter(adapterTipoCliente);

        btSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tipoPergunta = (String) spn_tipoPergunta.getSelectedItem();
                String tipoCliente = (String) spn_subCanal.getSelectedItem();
                String pergunta = edt_pergunta.getText().toString();
                String pontuacao = edt_pontuacao.getText().toString();

                Auditoria aud = Fachada.getInstance().verificaTipoPergunta(pergunta,pontuacao,tipoCliente,tipoPergunta);

                Fachada.getInstance().cadastrarPergunta(aud);

                edt_pergunta.setText("");
                edt_pontuacao.setText("");
                spn_tipoPergunta.setAdapter(adapterTipoPergunta);
                spn_subCanal.setAdapter(adapterTipoCliente);

                Toast.makeText(CadastroPerguntaActivity.this, "Pergunta cadastrada com sucesso !", Toast.LENGTH_SHORT).show();


            }
        });
    }
}