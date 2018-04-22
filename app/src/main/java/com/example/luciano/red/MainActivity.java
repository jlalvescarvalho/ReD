package com.example.luciano.red;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btAuditoria;
    private Button btDados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btAuditoria = findViewById(R.id.btAuditoria);
        btDados = findViewById(R.id.btDados);
    }

    public void OnClickBtAuditoria(View view){
        Intent it = new Intent(this, ClienteActivity.class);
        startActivity(it);
    }
    public void OnClickBtDados(View view){
        Intent it = new Intent(this, DadosActivity.class);
        startActivity(it);
    }
    public void OnClickBtNotas(View view){
        Intent it = new Intent(this, NotaClientesActivity.class);
        startActivity(it);
    }
}
