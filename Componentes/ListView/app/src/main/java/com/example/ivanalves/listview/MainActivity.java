package com.example.ivanalves.listview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private ListView list;
    private String[] itens = {"arroz", "feijão", "macarrão", "farinhaa", "cuscuz",
            "café", "farinha de trigo","feijão", "macarrão", "farinhaa", "cuscuz", "café", "farinha de trigo"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = (ListView) findViewById(R.id.ListViewID);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>( getApplicationContext(), android.R.layout.simple_list_item_1, android.R.id.text1, itens );
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                int codigo_posicao = position;
                String valorClicado = list.getItemAtPosition(codigo_posicao).toString();
                Toast.makeText(getApplicationContext(), valorClicado, Toast.LENGTH_LONG).show();
            }
        });
    }



}
