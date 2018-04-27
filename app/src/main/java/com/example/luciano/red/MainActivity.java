package com.example.luciano.red;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.luciano.red.fachada.Fachada;

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

    public void OnClickBtNotas(View view){
        Intent it = new Intent(this, NotaClientesActivity.class);
        startActivity(it);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // ação para para opção add do meniu
            case R.id.menu_main_item:
                Intent it = new Intent(this,  DadosActivity.class);
                startActivity(it);
                break;
            case R.id.menu_main_sobre:
                break;

        }

        return true;
    }
}
