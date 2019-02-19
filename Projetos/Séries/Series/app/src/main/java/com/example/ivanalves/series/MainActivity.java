package com.example.ivanalves.series;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {


    private ImageView imagem;
    private SeekBar seekbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        imagem = (ImageView) findViewById(R.id.imageViewID);
        seekbar = (SeekBar) findViewById(R.id.seekBarID);

        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                if( progress ==1){
                    imagem.setImageResource(R.drawable.pouco);
                }else if( progress ==2){
                    imagem.setImageResource(R.drawable.medio);
                }else if( progress ==3 ){
                    imagem.setImageResource(R.drawable.muito);

                }else if( progress ==4 ){
                    imagem.setImageResource(R.drawable.susto);

                }

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}
