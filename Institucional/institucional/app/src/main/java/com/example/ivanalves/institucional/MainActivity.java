package com.example.ivanalves.institucional;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private ImageView empresa;
    private ImageView contato;
    private ImageView clientes;
    private ImageView servicos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        empresa = (ImageView) findViewById(R.id.imageEmpresaID);
        contato = (ImageView) findViewById(R.id.imageContatoID);
        servicos = (ImageView) findViewById(R.id.imageServicoID);
        clientes = (ImageView) findViewById(R.id.imageClienteID);


        empresa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent( MainActivity.this, EmpresActivity.class));
            }
        });

        clientes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent( MainActivity.this, ClienteActivity.class));
            }
        });

        servicos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               startActivity(new Intent( MainActivity.this, ServicoActivity.class));
            }
        });

        contato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent( MainActivity.this, ContatoActivity.class));
            }
        });


    }


}
