package com.example.adoni.projetofinalandroid;

import android.content.DialogInterface;
import android.content.Intent;
import android.opengl.Visibility;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
    RelativeLayout tela1;
    RelativeLayout telaprincipal;

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
        setContentView(R.layout.activity_main);
        final EditText logindigitado = (EditText) findViewById(R.id.login);
        final EditText senhadigitada = (EditText) findViewById(R.id.senha);
        this.tela1 = (RelativeLayout) findViewById(R.id.tela1);
        this.telaprincipal = (RelativeLayout) findViewById(R.id.telaprincipal);
        Button semsenha = (Button) findViewById(R.id.semsenha);
        Button btlogar = (Button) findViewById(R.id.buttonlogin);

        tela1.setVisibility(View.GONE);
        semsenha.setOnClickListener(new
                View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        tela1.setVisibility(View.VISIBLE);
                    }
                }

        );
        btlogar.setOnClickListener(new
            View.OnClickListener(){
                public void onClick(View v) {
                    final String login = "aluno";
                    String senha = "aluno";
                    double teste = 0;

                    if (logindigitado.getText().toString().equals(login) && senhadigitada.getText().toString().equals(senha)) {
                        AlertDialog.Builder dialog = new
                                AlertDialog.Builder(MainActivity.this);
                        dialog.setTitle("Login");
                        dialog.setMessage("Login e senha certos");
                        dialog.setNeutralButton("OK", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        Intent secondActivity = new Intent(MainActivity.this, Main2Activity.class);
                                        secondActivity.putExtra("nome",login);
                                        startActivity(secondActivity);
                                    }
                                }
                        );
                        dialog.show();
                    } else {
                        AlertDialog.Builder dialog = new
                                AlertDialog.Builder(MainActivity.this);
                        dialog.setTitle("Login");
                        dialog.setMessage("Login ou senha errados, tente novamente");
                        dialog.setNeutralButton("OK", null);
                        dialog.show();
                        teste = 1;
                    }

                }
            }

        );

    }
}
