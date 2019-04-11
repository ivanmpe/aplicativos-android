package com.example.ivanalves.sqllite;

import android.app.Activity;
import android.content.ContentResolver;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {

            //cria banco de dados
            SQLiteDatabase banco = openOrCreateDatabase("app", MODE_PRIVATE, null);
            banco.execSQL("DROP TABLE pessoas");
            //cria table
            banco.execSQL("CREATE TABLE IF NOT EXISTS pessoas( id INTEGER PRIMARY KEY AUTOINCREMENT, nome VARCHAR(20), idade INT(3) )");
            //banco.execSQL("DROP TABLE pessoas");
            //inserir dados
            banco.execSQL("INSERT INTO pessoas(nome, idade) VALUES('Ivan Alves', 24)");
            banco.execSQL("INSERT INTO pessoas(nome, idade) VALUES('Ana', 20)");
            banco.execSQL("INSERT INTO pessoas(nome, idade) VALUES('José', 38)");
            banco.execSQL("UPDATE pessoas SET idade = 25, nome = 'Ivan' WHERE id = 1");
            //banco.execSQL("UPDATE pessoas SET idade=25 WHERE nome='José'");

            //banco.execSQL("DELETE FROM pessoas WHERE nome='José'");

            //Cursor cursor = banco.rawQuery("SELECT nome,idade FROM pessoas WHERE idade > 18", null );
            //Cursor cursor = banco.rawQuery("SELECT nome,idade FROM pessoas WHERE nome LIKE '%an%'", null );

            Cursor cursor = banco.rawQuery("SELECT * FROM pessoas WHERE nome LIKE '%an%'", null );


            int indiceColunaNome = cursor.getColumnIndex("nome");
            int indiceColunaId = cursor.getColumnIndex("id");
            int indiceColunaIdade = cursor.getColumnIndex("idade");
            String nome ;
            String id ;
            String idade;
            String resultado;


            cursor.moveToFirst();
            while(cursor != null){
                nome = cursor.getString(indiceColunaNome);
                id = cursor.getString(indiceColunaId);
                idade = cursor.getString(indiceColunaIdade);
                resultado = "ID: " + id + " nome: " + nome + " idade: " + idade;
                Toast.makeText(MainActivity.this, resultado, Toast.LENGTH_LONG).show();
                cursor.moveToNext();
            }

        }catch (Exception   e){
            e.printStackTrace();
        }

    }
}
