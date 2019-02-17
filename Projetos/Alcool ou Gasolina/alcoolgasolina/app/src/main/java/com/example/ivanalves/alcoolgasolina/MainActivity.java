package com.example.ivanalves.alcoolgasolina;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    Button verifica;
    TextView resultado;
    EditText alcool;
    EditText gasolina;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        verifica = (Button) findViewById(R.id.botaoVerificarID);
        resultado = (TextView) findViewById(R.id.textViewResultadoID);
        alcool = (EditText) findViewById(R.id.editTextAlcoolID);
        gasolina = (EditText) findViewById(R.id.editTextGasolinaID);


        verifica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String precoAlcool = alcool.getText().toString();
                String precoGasolina = gasolina.getText().toString();

                //conversão
                double valorAlcool = Double.parseDouble( precoAlcool);
                double valorGasolina = Double.parseDouble(precoGasolina);

                // preco alcool / preco da gasolina
                Double valorResultado = valorAlcool/valorGasolina;

                if(valorResultado >= 0.7){
                    resultado.setText("Melhor utilizar Gasolina");
                } else{
                    resultado.setText("Melhor utilizar Alcool");
                }

            }
        });

    }
}
