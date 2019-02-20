package com.example.ivanalves.tooglebuttons;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {


    private ImageView imagem;
    private ToggleButton togglebutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        togglebutton = (ToggleButton) findViewById(R.id.toggleButtonID);
        imagem = (ImageView) findViewById(R.id.imageViewID);
        togglebutton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if( b) {
                    imagem.setImageResource( R.drawable.on );
                }else {
                    imagem.setImageResource( R.drawable.off );
                }

            }
        });

    }
}
