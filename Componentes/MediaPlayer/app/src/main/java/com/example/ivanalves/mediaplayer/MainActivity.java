package com.example.ivanalves.mediaplayer;

import android.app.Activity;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    private Button botao;
    private MediaPlayer mediaPlayer;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botao = (Button) findViewById(R.id.buttonID);
        mediaPlayer = MediaPlayer.create( MainActivity.this, R.raw.toma_juizo);



        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mediaPlayer.isPlaying()){
                    pausaMusica();
                }else{
                    tocaMusica();
                }
            }
        });
    }

    private void tocaMusica(){
        if(mediaPlayer != null){
            mediaPlayer.start();
            botao.setText("Pausar");
        }

    }

    private void pausaMusica(){

        if(mediaPlayer != null){
            mediaPlayer.pause();
            botao.setText("Tocar");
        }

    }


    @Override
    protected void onDestroy() {
        if( mediaPlayer !=null && mediaPlayer.isPlaying()){
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }

        super.onDestroy();
    }

}



