package com.example.ivanalves.navegandoentreactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActivityDois extends Activity {
    private Button botaoDois;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dois);

        botaoDois = (Button) findViewById(R.id.botaoDoisID);
        botaoDois.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity( new Intent( ActivityDois.this, MainActivity.class));            }
            });
    }

}
