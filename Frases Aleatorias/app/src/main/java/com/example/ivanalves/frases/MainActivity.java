package com.example.ivanalves.frases;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {


    private TextView textoNovaFrase;
    private Button botaoNovaFrase;
    private String[] frases = { "Imagine uma nova história para sua vida e acredite nela.", "Tudo o que um sonho precisa para ser realizado é alguém que acredite que ele possa ser realizado.", "A amizade desenvolve a felicidade e reduz o sofrimento, duplicando a nossa alegria e dividindo a nossa dor.", "Ser feliz sem motivo é a mais autêntica forma de felicidade."};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textoNovaFrase = (TextView) findViewById(R.id.textoNovaFraseID);
        botaoNovaFrase = (Button) findViewById(R.id.botaoNovaFraseID);

        botaoNovaFrase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Random ran = new Random();
                int num = ran.nextInt(frases.length);

                textoNovaFrase.setText("" + frases[num]);
            }
        });

    }
}
