package com.example.ivanalves.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.ivanalves.dialog.R;


public class MainActivity extends Activity {

    private Button botao;
    private AlertDialog.Builder dialog;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        botao = (Button) findViewById(R.id.buttonID);

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dialog = new AlertDialog.Builder( MainActivity.this);
                dialog.setTitle("Titulo dialog");
                dialog.setMessage("Mensage");
                dialog.setCancelable(false);
                dialog.setIcon(android.R.drawable.ic_delete);

                dialog.setNegativeButton("Não", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText( MainActivity.this, "Pressionado o botao nao", Toast.LENGTH_LONG).show();
                    }
                });

                dialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText( MainActivity.this, "Pressionado o botao sim", Toast.LENGTH_LONG).show();
                    }
                });
                dialog.create().show();
            }
        });
     }

}




















