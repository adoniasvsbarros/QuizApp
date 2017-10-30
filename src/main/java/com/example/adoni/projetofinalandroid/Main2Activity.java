package com.example.adoni.projetofinalandroid;

import android.content.DialogInterface;
import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Main2Activity extends AppCompatActivity {
    public ListView lista;
    String [] temas = {"Informática","Ciências","Matemática","Física","Português","Lógica"};
    String temaescolhido;

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mymenu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case R.id.botaosair:
                finish();
                System.exit(0);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main2);
            Intent intent = getIntent();
            String name = intent.getStringExtra("nome");

            ArrayAdapter<String> adapter = new
                    ArrayAdapter<String>(this,R.layout.activity_main2,R.id.textView3,temas);
            lista = (ListView) findViewById(R.id.listatemas);
            lista.setAdapter(adapter);
            lista.setOnItemClickListener(new
                    AdapterView.OnItemClickListener(){

                        public void onItemClick(AdapterView parent, View view, int position, long id) {
                            AlertDialog.Builder dialogo = new
                                    AlertDialog.Builder(Main2Activity.this);
                            dialogo.setTitle("Tema selecionado");
                            TextView txtview = (TextView) view.findViewById(R.id.textView3);
                            dialogo.setMessage(txtview.getText().toString());
                            temaescolhido = txtview.getText().toString();
                            dialogo.setNeutralButton("OK",new DialogInterface.OnClickListener(){
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            Intent PerguntasActivity = new Intent(Main2Activity.this,PerguntasActivity.class);
                                            PerguntasActivity.putExtra("temaescolhido",temaescolhido);
                                            startActivity(PerguntasActivity);
                                        }
                                    }
                                    );
                            dialogo.show();

                        }
                    });

        }
}
