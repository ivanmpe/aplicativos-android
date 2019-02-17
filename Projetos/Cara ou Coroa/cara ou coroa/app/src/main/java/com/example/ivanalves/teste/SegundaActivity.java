package com.example.ivanalves.teste;

import android.content.Intent;
import android.media.Image;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class SegundaActivity extends AppCompatActivity {


    private ImageView imagem;
    private ImageView voltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);


        voltar = (ImageView) findViewById(R.id.botaoVoltarID);
        imagem = (ImageView) findViewById(R.id.imagemID);


        Bundle extra  = getIntent().getExtras();

         if(extra != null){
            String opcaoEscolhida = extra.getString("opcao");
            if(opcaoEscolhida.equals("cara")){
               imagem.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.moeda_cara ));
            }else{
               imagem.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.moeda_coroa ));
            }

        }

        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity( new Intent( SegundaActivity.this, MainActivity.class));
            }
        });


    }




}
