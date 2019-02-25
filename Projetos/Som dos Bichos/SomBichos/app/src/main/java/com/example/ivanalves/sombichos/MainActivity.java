package com.example.ivanalves.sombichos;
import android.app.Activity;
import android.media.Image;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView cao;
    private ImageView gato;
    private ImageView leao;
    private ImageView macaco;
    private ImageView ovelha;
    private ImageView vaca;
    private MediaPlayer mediaPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cao = (ImageView) findViewById(R.id.imageViewCaoID);
        gato = (ImageView) findViewById(R.id.imageViewGatoID);
        leao = (ImageView) findViewById(R.id.imageViewLeaoID);
        macaco = (ImageView) findViewById(R.id.imageViewMacacoID);
        ovelha = (ImageView) findViewById(R.id.imageViewOvelhaID);
        vaca = (ImageView) findViewById(R.id.imageViewVacaID);

        cao.setOnClickListener(this);
        gato.setOnClickListener(this);
        leao.setOnClickListener(this);
        macaco.setOnClickListener(this);
        ovelha.setOnClickListener(this);
        vaca.setOnClickListener(this);


    }

    @Override
    protected void onDestroy() {
        if(mediaPlayer != null){
            mediaPlayer.release();
            mediaPlayer = null;
        }

        super.onDestroy();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.imageViewCaoID:
                mediaPlayer  = MediaPlayer.create(MainActivity.this, R.raw.cao);
                toca();
                break;
            case R.id.imageViewGatoID:
                mediaPlayer  = MediaPlayer.create(MainActivity.this, R.raw.gato);
                toca();
                break;
            case R.id.imageViewLeaoID:
                mediaPlayer  = MediaPlayer.create(MainActivity.this, R.raw.leao);
                toca();
                break;
            case R.id.imageViewMacacoID:
                mediaPlayer  = MediaPlayer.create(MainActivity.this, R.raw.macaco);
                toca();
                break;
            case R.id.imageViewOvelhaID:
                mediaPlayer  = MediaPlayer.create(MainActivity.this, R.raw.ovelha);
                toca();
                break;
            case R.id.imageViewVacaID:
                mediaPlayer  = MediaPlayer.create(MainActivity.this, R.raw.vaca);
                toca();
                break;


        }
    }

    private void toca(){
        if(mediaPlayer != null){
            mediaPlayer.start();
        }
    }





}
