package com.example.ivanalves.todolist;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
//atributo da classe.

public class MainActivity extends Activity {

    private EditText textoTarefa;
    private Button botaoAdicionar;
    private ListView lista;
    private SQLiteDatabase banco;
    private ArrayAdapter<String> itensAdaptador;
    private ArrayList<String> itens;
    private ArrayList<Integer> ids;
    private AlertDialog alerta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            textoTarefa = (EditText) findViewById(R.id.editTextId);
            botaoAdicionar = (Button) findViewById(R.id.botaoAdicionarID);
            lista = (ListView) findViewById(R.id.ListViewId);

            banco = openOrCreateDatabase("apptarefas", MODE_PRIVATE, null);
            banco.execSQL("CREATE TABLE IF NOT EXISTS tarefas(id INTEGER PRIMARY KEY AUTOINCREMENT, tarefa VARCHAR(100) )");

            botaoAdicionar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                     String textoDigitado = textoTarefa.getText().toString();
                    if (textoDigitado.equals("")) {
                            Toast.makeText( MainActivity.this, "Digite uma tarefa.", Toast.LENGTH_SHORT).show();
                    } else {
                        salvaTarefa(textoDigitado);
                    }
                }
            });

            lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    alertDelete(i);
                }
            });

            //recupera Tarefas
            recuperaTarefas();

        } catch(Exception e ){
            e.printStackTrace();
        }
    }


    private void salvaTarefa( String texto) {
        try {
            banco.execSQL("INSERT INTO tarefas (tarefa) VALUES('" + texto + "')");
            Toast.makeText(MainActivity.this, " Tarefa inserida com sucesso.", Toast.LENGTH_SHORT).show();
            recuperaTarefas();
            textoTarefa.setText("");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void deletaTarefa(int id) {
        try {
            banco.execSQL("DELETE FROM tarefas WHERE id=" + id );
            recuperaTarefas();
            Toast.makeText(MainActivity.this, " Tarefa deletada com sucesso.", Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void recuperaTarefas(){
        try {
            //recupera as tarefas
            Cursor cursor = banco.rawQuery("SELECT * FROM tarefas ORDER BY id DESC", null);
            String id , tarefa, resultado;
            int indiceColunaId = cursor.getColumnIndex("id");
            int indiceColunaTarefa = cursor.getColumnIndex("tarefa");

            itens = new ArrayList<String>();
            ids = new ArrayList<Integer>();


            itensAdaptador = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_2, android.R.id.text2, itens);
            lista.setAdapter(itensAdaptador);

            cursor.moveToFirst();

            while (cursor != null) {
                id = cursor.getString(indiceColunaId);
                tarefa = cursor.getString(indiceColunaTarefa);
                resultado = id + tarefa;
                itens.add(tarefa);
                ids.add(Integer.parseInt(cursor.getString(indiceColunaId)));
                cursor.moveToNext();
            }
        }catch ( Exception e ){
            e.printStackTrace();
        }

    }

    private void alertDelete(final int i) {

        //Cria o gerador do AlertDialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //define o titulo
        builder.setTitle("Delete");
        //define a mensagem
        builder.setMessage("Deseja deletar esse item? ");
        //define um botão como positivo
        builder.setPositiveButton("Sim", new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface arg0, int arg1) {
                deletaTarefa( ids.get( i ));
            }
        });
        //define um botão como negativo.
        builder.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
            }
        });
        //cria o AlertDialog
        alerta = builder.create();
        //Exibe
        alerta.show();
    }
}
