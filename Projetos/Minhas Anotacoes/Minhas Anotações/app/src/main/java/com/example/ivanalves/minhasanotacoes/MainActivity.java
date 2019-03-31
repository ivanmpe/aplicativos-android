package com.example.ivanalves.minhasanotacoes;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class MainActivity extends Activity {

    private EditText texto;
    private Button botaoSalvar;
    public static final String arquivo = "arquivo.txt";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        texto = (EditText) findViewById(R.id.textoID);
        botaoSalvar = (Button) findViewById(R.id.buttonSalvarID);
        botaoSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textoDigitado = texto.getText().toString();
                gravarArquivo(textoDigitado);
                Toast.makeText(MainActivity.this, " Texto salvo com sucesso.", Toast.LENGTH_SHORT).show();
            }
        });
        if( resultado() != null){
            texto.setText( resultado());
        }

    }

    public void gravarArquivo(String texto){
        try{
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter( openFileOutput(arquivo, Context.MODE_WORLD_WRITEABLE));
            outputStreamWriter.write(texto);
            outputStreamWriter.close();
        }catch (IOException e){
            Log.v("MainActivity", e.toString());
        }

    }

    public String resultado(){
        String resultado = "";
        try {
            InputStream arq = openFileInput(arquivo);
            if(arq != null){
                InputStreamReader inputStreamReader = new InputStreamReader(arq);
                //gerar buffer
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                //recuperar textos
                String linha = "";
                while ( (linha =  bufferedReader.readLine()) != null){
                    resultado +=linha;
                }
                arq.close();
            }

        }catch (IOException e){
            Log.v("MainActivity", e.toString());
        }

        return resultado;
    }
}
