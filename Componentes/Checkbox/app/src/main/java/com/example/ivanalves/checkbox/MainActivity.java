package com.example.ivanalves.checkbox;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends Activity {


    private CheckBox checkBoxFortaleza;
    private CheckBox checkBoxCeara;
    private CheckBox checkBoxFer;

    private TextView textExibido;
    private Button botaoMostrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkBoxCeara = (CheckBox) findViewById(R.id.checkBoxCearaID);
        checkBoxFortaleza = (CheckBox) findViewById(R.id.checkBoxFortaleaID);
        checkBoxFer = (CheckBox) findViewById(R.id.checkBoxFerrinID);

        textExibido = (TextView) findViewById(R.id.textViewID);
        botaoMostrar = (Button) findViewById(R.id.botaoID);


        botaoMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String itensSelecionados = "";
                itensSelecionados += "\nValor: " + checkBoxFortaleza.getText() + " Status: " + checkBoxFortaleza.isChecked();
                itensSelecionados += "\nValor: " + checkBoxCeara.getText() + " Status: " + checkBoxCeara.isChecked();
                itensSelecionados += "\nValor: " + checkBoxFer.getText() + " Status: " + checkBoxFer.isChecked();
                textExibido.setText(itensSelecionados);
            }
        });



    }







}
