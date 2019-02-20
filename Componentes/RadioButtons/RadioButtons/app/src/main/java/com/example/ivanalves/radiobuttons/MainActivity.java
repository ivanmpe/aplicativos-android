package com.example.ivanalves.radiobuttons;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {



    private TextView escolha;
    private Button botaoEscolher;
    private RadioGroup radionGroup;
    private RadioButton escolhido;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        radionGroup = (RadioGroup) findViewById(R.id.radioGroupID);
        escolha = (TextView) findViewById(R.id.TextViewEscolhaID);
        botaoEscolher = (Button) findViewById(R.id.botaoEscolherID);

        botaoEscolher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int idRadioButtonEscolhido = radionGroup.getCheckedRadioButtonId();
                escolha.setText("id: " + R.id.radioGroupID);


                if(idRadioButtonEscolhido > 0){
                    escolhido = (RadioButton) findViewById( idRadioButtonEscolhido );
                    escolhido.getText();
                    escolha.setText( "Opção escolhida foi: " + escolhido.getText() );

                }
            }
        });

    }
}
