package com.example.luciano.red;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btAuditoria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btAuditoria = findViewById(R.id.btAuditoria);
    }

    public void OnClick(View view){
        Intent it = new Intent(this, ClienteActivity.class);
        startActivity(it);
    }
}
