package com.example.ivanalves.idadecachorro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button botaoIdade ;
    TextView resultado;
    EditText caixaIdade;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        caixaIdade = (EditText) findViewById(R.id.textIdadeID);
        botaoIdade = (Button) findViewById(R.id.botaoIdadeID);
        resultado = (TextView) findViewById(R.id.resultadoIdadeID);

        botaoIdade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Recuperar o que foi digitado
                String idade =  caixaIdade.getText().toString();
                if(idade.isEmpty()){
                    resultado.setText("Nenhum valor foi digitado. ");
                }else{
                    int valor = Integer.parseInt(idade);
                    valor = valor * 7;
                    resultado.setText("Idade em anos humanos é: " + valor);
                }
            }
        });





    }
}
