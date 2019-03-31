package com.example.ivanalves.preferenciascor;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends Activity {

    private RadioGroup radioGroup;
    private RadioButton selecionado;
    private Button botaoSalvar;
    private ConstraintLayout layout;
    private static final String ARQUIVO_PREFERENCIA = "ArqPreferencia";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        botaoSalvar = (Button) findViewById(R.id.buttonSalvarID);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroupID);
        layout = (ConstraintLayout) findViewById(R.id.layoutID);

        botaoSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int idRadioButtonEscolhido = radioGroup.getCheckedRadioButtonId();
                selecionado = (RadioButton) findViewById(idRadioButtonEscolhido);
                //0 = Arquivo privado
                SharedPreferences sharedPreferences = getSharedPreferences(ARQUIVO_PREFERENCIA, 0);
                SharedPreferences.Editor editor  = sharedPreferences.edit();

                String corEscolhida = selecionado.getText().toString();

                editor.putString("corEscolhida", corEscolhida);
                //Finalizando usando commit
                editor.commit();
                setBackground(corEscolhida);


            }
        });
        //recuperar a cor salva
        SharedPreferences sharedPreferences = getSharedPreferences(ARQUIVO_PREFERENCIA, 0);
        if(sharedPreferences.contains("corEscolhida")){
            String corRecuperada = sharedPreferences.getString("corEscolhida", "Verde");
            setBackground(corRecuperada);
        }


    }


    public void setBackground(String cor){

        if(cor.equals("Azul")){
            layout.setBackgroundColor(Color.parseColor("#0288d1"));
        }else if(cor.equals("Verde")){
            layout.setBackgroundColor(Color.parseColor("#1b5e20"));
        }else if(cor.equals("Vermelho")){
            layout.setBackgroundColor(Color.parseColor("#bf360c"));
        }else{
            layout.setBackgroundColor(Color.parseColor("#ffff00"));
        }
    }
}
