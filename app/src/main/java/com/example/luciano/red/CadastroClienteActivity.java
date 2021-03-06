package com.example.luciano.red;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.luciano.red.fachada.Fachada;
import com.example.luciano.red.negocio.entidade.Cliente;
import com.example.luciano.red.negocio.entidade.TipoClienteEnum;

public class CadastroClienteActivity extends AppCompatActivity {

    private EditText edt_codigo;
    private EditText edt_nome;
    private EditText edt_logradouro;
    private Spinner spn_cidade;
    private Spinner spn_subCanal;
    private Button bt_cancelar;
    private Button bt_salvar;

    private String[] subCanais;
    private String[] cidades;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_cliente);

        edt_codigo = (EditText)findViewById(R.id.edt_codigo);
        edt_nome = (EditText)findViewById(R.id.edt_nome_cliente);
        edt_logradouro = (EditText)findViewById(R.id.edt_logradouro);
        spn_cidade = (Spinner)findViewById(R.id.spn_cidade);
        spn_subCanal = (Spinner)findViewById(R.id.spn_canal);
        bt_salvar = (Button)findViewById(R.id.bt_salvar_cliente);
        bt_cancelar = (Button)findViewById(R.id.bt_cancelar_cliente);

        subCanais = new String[]{"Sub-Canal", TipoClienteEnum.AS1_4.toString(), TipoClienteEnum.Mercearia.toString(), TipoClienteEnum.Lanchonete.toString(), TipoClienteEnum.Bar.toString(),TipoClienteEnum.Restaurante.toString(),TipoClienteEnum.Atacado.toString(),TipoClienteEnum.Conveniencia.toString()};
        cidades = new String[]{"Cidades", "Aguas Belas", "Angelim", "Bom Conselho", "Brejão", "Caetes", "Calçado", "Canhotinho", "Capoeiras", "Correntes", "Garanhuns", "Iati", "Jucati", "Jupi", "Lagoa do Ouro", "Palmeirina", "Paranatama", "Saloá", "São João", "Terezinha"};

        final ArrayAdapter<String> AdapterSubCanal = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item, subCanais);
        final ArrayAdapter<String> AdapterCidades = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,cidades);

        spn_subCanal.setAdapter(AdapterSubCanal);
        spn_cidade.setAdapter(AdapterCidades);

        bt_salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {

                    int codigo = Integer.parseInt(edt_codigo.getText().toString());
                    String razao = edt_nome.getText().toString();
                    String logradouro = edt_logradouro.getText().toString();
                    String cidade = spn_cidade.getSelectedItem().toString();
                    String subcanal = spn_subCanal.getSelectedItem().toString();

                    Cliente c = new Cliente(codigo, razao, logradouro, cidade, verificaSubCanal(subcanal));

                    Fachada.getInstance().cadastrarCliente(c);

                    Toast.makeText(CadastroClienteActivity.this, "Cliente cadastrado com sucesso !", Toast.LENGTH_SHORT).show();
                }catch (Exception ex){
                    Toast.makeText(CadastroClienteActivity.this, ex.getMessage(), Toast.LENGTH_SHORT).show();
                }

                edt_codigo.setText("");
                edt_nome.setText("");
                edt_logradouro.setText("");
                spn_subCanal.setAdapter(AdapterSubCanal);
                spn_cidade.setAdapter(AdapterCidades);
            }
        });
        bt_cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    public int verificaSubCanal(String canal){

        if(TipoClienteEnum.AS1_4.toString().equals(canal)){
            return TipoClienteEnum.AS1_4.getSubcanal();
        }else if(canal.equals(TipoClienteEnum.Mercearia.toString())){
            return TipoClienteEnum.Mercearia.getSubcanal();
        }else if(canal.equals(TipoClienteEnum.Lanchonete.toString())){
            return TipoClienteEnum.Lanchonete.getSubcanal();
        }else if(canal.equals(TipoClienteEnum.Bar.toString())){
            return TipoClienteEnum.Bar.getSubcanal();
        }else if(canal.equals(TipoClienteEnum.Restaurante.toString())){
            return TipoClienteEnum.Restaurante.getSubcanal();
        }else if(canal.equals(TipoClienteEnum.Atacado.toString())){
            return TipoClienteEnum.Atacado.getSubcanal();
        }else if(canal.equals(TipoClienteEnum.Conveniencia.toString())){
            return TipoClienteEnum.Conveniencia.getSubcanal();
        }
        return 0;
    }
}
