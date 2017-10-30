package com.example.adoni.projetofinalandroid;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class PerguntasActivity extends AppCompatActivity {

    //Perguntas
    String[] math = {"Quanto é: 2 * 2 ?","Quanto é: 3! ?","Quanto é: 0 / 1 ?","Quanto é: 5 mod 2 ?"};
    String[] sci = {"Quem descobriu o E = mc^2 ?","Qual é a lei de ohm? ","Quem come carne é ?","Qual é o planeta considerado vermelho ?"};
    String[] inf = {"Qual é a melhor linguagem ?","Quem é o pai do computador ?","Que atalho abre o gerenciador de tarefas do windows ?","Qual o SO do Macbook?"};
    String[] fis = {"R = V*I é a lei de: ","Se s = 36 km e t = 2s quanto vale a velocidade ?","Qual força não é uma força natural?","Que área não é da física ? "};
    String[] por = {"Código é: ","Árvore é: Heroico é: ","Piauí é:"};
    String[] log = {"1 AND 0 e 1 OR 0 =  ?","1 AND 1 e 1 OR 1 = ?","0 AND 0 e 0 OR 0 = ?","1 XOR 0 = ? "};

    // Map para as respostas
    Map<Number,String[]> sci2 = new HashMap<Number,String[]>();
    Map<Number,String[]> inf2 = new HashMap<Number,String[]>();
    Map<Number,String[]> fis2 = new HashMap<Number,String[]>();
    Map<Number,String[]> math2 = new HashMap<Number,String[]>();
    Map<Number,String[]> por2 = new HashMap<Number,String[]>();
    Map<Number,String[]> log2 = new HashMap<Number,String[]>();

    List<Integer> numeros = new ArrayList<Integer>();
    Random rand = new Random();
    int nrand;
    int acertos = 0;
    int j = 0;
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

    public void setaTextos(String[] math, Map<Number,String[]> math2, TextView viewpergunta,RadioButton p1, RadioButton p2,RadioButton p3,RadioButton p4){
        //Editando a pergunta
        nrand = numeros.get(j);
        viewpergunta.setText(math[nrand]);
        // Editando os textos dos RadioButtons da pergunta
        p1.setText(math2.get(nrand)[numeros.get(0)]);
        p2.setText(math2.get(nrand)[numeros.get(1)]);
        p3.setText(math2.get(nrand)[numeros.get(2)]);
        p4.setText(math2.get(nrand)[numeros.get(3)]);

    }


    public void setaTextos2(String[] sci, Map<Number,String[]> sci2, TextView viewpergunta,RadioButton p1, RadioButton p2,RadioButton p3,RadioButton p4){
        //Editando a pergunta
        nrand = numeros.get(j);
        viewpergunta.setText(sci[nrand]);
        // Editando os textos dos RadioButtons da pergunta
        p1.setText(sci2.get(nrand)[numeros.get(0)]);
        p2.setText(sci2.get(nrand)[numeros.get(1)]);
        p3.setText(sci2.get(nrand)[numeros.get(2)]);
        p4.setText(sci2.get(nrand)[numeros.get(3)]);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perguntas);
        TextView viewtema = (TextView) findViewById(R.id.viewtema);
        final RadioGroup rg = (RadioGroup) findViewById(R.id.rgopcoes);
        Button btresposta =(Button) findViewById(R.id.abutton);
        Intent intent = getIntent();
        String temaescolhido = intent.getStringExtra("temaescolhido");
        final TextView viewpergunta = (TextView) findViewById(R.id.viewpergunta);
        final RadioButton p1 = (RadioButton) findViewById(R.id.op1);
        final RadioButton p2 = (RadioButton) findViewById(R.id.op2);
        final RadioButton p3 = (RadioButton) findViewById(R.id.op3);
        final RadioButton p4 = (RadioButton) findViewById(R.id.op4);

        // respostas Matematica
        String[] q1 = {"4","2","1","nenhuma"};
        String[] q2 = {"6","3","9","nenhuma"};
        String[] q3 = {"0","1","-1","nenhuma"};
        String[] q4 = {"1","5","0","nenhuma"};
        math2.put(0,q1);
        math2.put(1,q2);
        math2.put(2,q3);
        math2.put(3,q4);
        // respostas Ciências

        String[] cq1 = {"Albert Einstein","Van Gogh","Nikola Tesla","Georg Simon Ohm"};
        String[] cq2 = {"R = V*I","R = V/I","R = V+I","R = I/V"};
        String[] cq3 = {"Carnívoro","Onívoro","Herbívoro","nenhuma"};
        String[] cq4 = {"Marte","Vênus","Plutão","Mercúrio"};
        sci2.put(0,cq1);
        sci2.put(1,cq2);
        sci2.put(2,cq3);
        sci2.put(3,cq4);
        // respostas Lógica

        String[] lq1 = {"0, 1","0, 0","1, 0","1, 1"};
        String[] lq2 = {"1, 1","1, 0","0, 0","0, 1"};
        String[] lq3 = {"0, 0","0, 1","1, 0","1, 1"};
        String[] lq4 = {"1","0","2","nenhuma"};
        log2.put(0,lq1);
        log2.put(1,lq2);
        log2.put(2,lq3);
        log2.put(3,lq4);
        //respostas Português

        String[] pq1 = {"Proparóxitona","Oxítona","Paroxítona","nenhuma"};
        String[] pq2 = {"Proparóxitona","Oxítona","Paroxítona","nenhuma"};
        String[] pq3 = {"Paroxítona","Proparóxitona","Oxítona","nenhuma"};
        String[] pq4 = {"Oxítona","Proparóxitona","Paroxítona","nenhuma"};
        por2.put(0,pq1);
        por2.put(1,pq2);
        por2.put(2,pq3);
        por2.put(3,pq4);
        //respostas Informatica

        String[] iq1 = {"Cada uma tem seu propósito","C","Java","Haskell"};
        String[] iq2 = {"Alan Turing","Bill Gates","Charles Babbage","Von Neumann"};
        String[] iq3 = {"CTRL + ALT + DEL","CTRL + DEL","CTRL + ALT","CTRL + X"};
        String[] iq4 = {"Mac OS","Linux","Windows","Android"};
        inf2.put(0,iq1);
        inf2.put(1,iq2);
        inf2.put(2,iq3);
        inf2.put(3,iq4);
        //respostas Fisica

        String[] fq1 = {"Ohm","Tesla","Murphy","Hess"};
        String[] fq2 = {"18 km/s","36 km/s","12 km/s","10 km/s"};
        String[] fq3 = {"mecânica","eletromagnética","forte","fraca"};
        String[] fq4 = {"Elaboral","Mecânica","Cinética","Elétrica"};
        fis2.put(0,fq1);
        fis2.put(1,fq2);
        fis2.put(2,fq3);
        fis2.put(3,fq4);

        //mudando tema
        viewtema.setText("TEMA: " + temaescolhido);

        // Criando vetor aleatorio de numeros 0 a 3 para embaralhar perguntas
        for(int i = 0; i < 4; i++ ){
            numeros.add(i);
        }
        Collections.shuffle(numeros);
                // mostrar primeira pergunta
                switch(temaescolhido){
                    case "Matemática":
                        setaTextos(math,math2,viewpergunta,p1,p2,p3,p4);
                        break;
                    case "Lógica":
                        setaTextos(log,log2,viewpergunta,p1,p2,p3,p4);
                        break;
                    case "Português":
                        setaTextos(por,por2,viewpergunta,p1,p2,p3,p4);
                        break;
                    case "Ciências":
                        setaTextos(sci,sci2,viewpergunta,p1,p2,p3,p4);
                        break;
                    case "Física":
                        setaTextos(fis,fis2,viewpergunta,p1,p2,p3,p4);
                        break;
                    case "Informática":
                        setaTextos(inf,inf2,viewpergunta,p1,p2,p3,p4);
                        break;
                }
                // outras perguntas
                btresposta.setOnClickListener(new
                View.OnClickListener() {
                  @Override
                  public void onClick(View v) {

                      Intent intent = getIntent();
                      String temaescolhido = intent.getStringExtra("temaescolhido");
                      int op = rg.getCheckedRadioButtonId();
                      // se eu selecionei a opcao e o texto dela é igual ao texto do primeiro membro do vetor da pergunta
                      switch(temaescolhido) {
                          case "Matemática":
                              if (j != 2) {

                                  if (op == R.id.op1) {
                                      if (p1.getText().toString().equals(math2.get(nrand)[0])) {
                                          acertos++;
                                          j++;
                                          setaTextos(math,math2,viewpergunta,p1,p2,p3,p4);
                                      } else {
                                          j++;
                                          setaTextos(math,math2,viewpergunta,p1,p2,p3,p4);
                                      }
                                  } else if (op == R.id.op2) {
                                      if (p2.getText().toString().equals(math2.get(nrand)[0])) {
                                          acertos++;
                                          j++;
                                          setaTextos(math,math2,viewpergunta,p1,p2,p3,p4);
                                      } else {
                                          j++;
                                          setaTextos(math,math2,viewpergunta,p1,p2,p3,p4);
                                      }
                                  } else if (op == R.id.op3) {
                                      if (p3.getText().toString().equals(math2.get(nrand)[0])) {
                                          acertos++;
                                          j++;
                                          setaTextos(math,math2,viewpergunta,p1,p2,p3,p4);
                                      } else {
                                          j++;
                                          setaTextos(math,math2,viewpergunta,p1,p2,p3,p4);
                                      }
                                  } else if (op == R.id.op4) {
                                      if (p4.getText().toString().equals(math2.get(nrand)[0])) {
                                          j++;
                                          acertos++;
                                          setaTextos(math,math2,viewpergunta,p1,p2,p3,p4);
                                      } else {
                                          j++;
                                          setaTextos(math,math2,viewpergunta,p1,p2,p3,p4);
                                      }
                                  }
                              } else {

                                  AlertDialog.Builder dialogo = new
                                          AlertDialog.Builder(PerguntasActivity.this);
                                  dialogo.setTitle("Resultado");
                                  dialogo.setMessage("Voce acertou: "+ acertos + " de 3 perguntas");
                                  dialogo.setNeutralButton("OK",new
                                          DialogInterface.OnClickListener(){
                                              @Override
                                              public void onClick(DialogInterface dialog, int which) {
                                                  Intent Main2Activity = new Intent(PerguntasActivity.this,Main2Activity.class);
                                                  startActivity(Main2Activity);
                                                  j = 0;
                                              }
                                          }
                                  );
                                  dialogo.show();
                              }
                              break;
                          case "Ciências":
                              if (j != 2) {

                                  if (op == R.id.op1) {
                                      if (p1.getText().toString().equals(sci2.get(nrand)[0])) {
                                          acertos++;
                                          j++;
                                          setaTextos(sci,sci2,viewpergunta,p1,p2,p3,p4);
                                      } else {
                                          j++;
                                          setaTextos(sci,sci2,viewpergunta,p1,p2,p3,p4);
                                      }
                                  } else if (op == R.id.op2) {
                                      if (p2.getText().toString().equals(sci2.get(nrand)[0])) {
                                          acertos++;
                                          j++;
                                          setaTextos(sci,sci2,viewpergunta,p1,p2,p3,p4);
                                      } else {
                                          j++;
                                          setaTextos(sci,sci2,viewpergunta,p1,p2,p3,p4);
                                      }
                                  } else if (op == R.id.op3) {
                                      if (p3.getText().toString().equals(sci2.get(nrand)[0])) {
                                          acertos++;
                                          j++;
                                          setaTextos(sci,sci2,viewpergunta,p1,p2,p3,p4);
                                      } else {
                                          j++;
                                          setaTextos(sci,sci2,viewpergunta,p1,p2,p3,p4);
                                      }
                                  } else if (op == R.id.op4) {
                                      if (p4.getText().toString().equals(sci2.get(nrand)[0])) {
                                          j++;
                                          acertos++;
                                          setaTextos(sci,sci2,viewpergunta,p1,p2,p3,p4);
                                      } else {
                                          j++;
                                          setaTextos(sci,sci2,viewpergunta,p1,p2,p3,p4);
                                      }
                                  }
                              } else {

                                  AlertDialog.Builder dialogo = new
                                          AlertDialog.Builder(PerguntasActivity.this);
                                  dialogo.setTitle("Resultado");
                                  dialogo.setMessage("Voce acertou: "+ acertos + " de 3 perguntas");
                                  dialogo.setNeutralButton("OK",new
                                          DialogInterface.OnClickListener(){
                                              @Override
                                              public void onClick(DialogInterface dialog, int which) {
                                                  Intent Main2Activity = new Intent(PerguntasActivity.this,Main2Activity.class);
                                                  startActivity(Main2Activity);
                                                  j = 0;
                                              }
                                          }
                                  );
                                  dialogo.show();
                              }
                              break;

                          case "Informática":
                              if (j != 2) {

                                  if (op == R.id.op1) {
                                      if (p1.getText().toString().equals(inf2.get(nrand)[0])) {
                                          acertos++;
                                          j++;
                                          setaTextos(inf,inf2,viewpergunta,p1,p2,p3,p4);
                                      } else {
                                          j++;
                                          setaTextos(inf,inf2,viewpergunta,p1,p2,p3,p4);
                                      }
                                  } else if (op == R.id.op2) {
                                      if (p2.getText().toString().equals(inf2.get(nrand)[0])) {
                                          acertos++;
                                          j++;
                                          setaTextos(inf,inf2,viewpergunta,p1,p2,p3,p4);
                                      } else {
                                          j++;
                                          setaTextos(inf,inf2,viewpergunta,p1,p2,p3,p4);
                                      }
                                  } else if (op == R.id.op3) {
                                      if (p3.getText().toString().equals(inf2.get(nrand)[0])) {
                                          acertos++;
                                          j++;
                                          setaTextos(inf,inf2,viewpergunta,p1,p2,p3,p4);
                                      } else {
                                          j++;
                                          setaTextos(inf,inf2,viewpergunta,p1,p2,p3,p4);
                                      }
                                  } else if (op == R.id.op4) {
                                      if (p4.getText().toString().equals(inf2.get(nrand)[0])) {
                                          j++;
                                          acertos++;
                                          setaTextos(inf,inf2,viewpergunta,p1,p2,p3,p4);
                                      } else {
                                          j++;
                                          setaTextos(inf,inf2,viewpergunta,p1,p2,p3,p4);
                                      }
                                  }
                              } else {

                                  AlertDialog.Builder dialogo = new
                                          AlertDialog.Builder(PerguntasActivity.this);
                                  dialogo.setTitle("Resultado");
                                  dialogo.setMessage("Voce acertou: "+ acertos + " de 3 perguntas");
                                  dialogo.setNeutralButton("OK",new
                                          DialogInterface.OnClickListener(){
                                              @Override
                                              public void onClick(DialogInterface dialog, int which) {
                                                  Intent Main2Activity = new Intent(PerguntasActivity.this,Main2Activity.class);
                                                  startActivity(Main2Activity);
                                                  j = 0;
                                              }
                                          }
                                  );
                                  dialogo.show();
                              }
                              break;

                          case "Física":
                              if (j != 2) {

                                  if (op == R.id.op1) {
                                      if (p1.getText().toString().equals(fis2.get(nrand)[0])) {
                                          acertos++;
                                          j++;
                                          setaTextos(fis,fis2,viewpergunta,p1,p2,p3,p4);
                                      } else {
                                          j++;
                                          setaTextos(fis,fis2,viewpergunta,p1,p2,p3,p4);
                                      }
                                  } else if (op == R.id.op2) {
                                      if (p2.getText().toString().equals(fis2.get(nrand)[0])) {
                                          acertos++;
                                          j++;
                                          setaTextos(fis,fis2,viewpergunta,p1,p2,p3,p4);
                                      } else {
                                          j++;
                                          setaTextos(fis,fis2,viewpergunta,p1,p2,p3,p4);
                                      }
                                  } else if (op == R.id.op3) {
                                      if (p3.getText().toString().equals(fis2.get(nrand)[0])) {
                                          acertos++;
                                          j++;
                                          setaTextos(fis,fis2,viewpergunta,p1,p2,p3,p4);
                                      } else {
                                          j++;
                                          setaTextos(fis,fis2,viewpergunta,p1,p2,p3,p4);
                                      }
                                  } else if (op == R.id.op4) {
                                      if (p4.getText().toString().equals(fis2.get(nrand)[0])) {
                                          j++;
                                          acertos++;
                                          setaTextos(fis,fis2,viewpergunta,p1,p2,p3,p4);
                                      } else {
                                          j++;
                                          setaTextos(fis,fis2,viewpergunta,p1,p2,p3,p4);
                                      }
                                  }
                              } else {

                                  AlertDialog.Builder dialogo = new
                                          AlertDialog.Builder(PerguntasActivity.this);
                                  dialogo.setTitle("Resultado");
                                  dialogo.setMessage("Voce acertou: "+ acertos + " de 3 perguntas");
                                  dialogo.setNeutralButton("OK",new
                                          DialogInterface.OnClickListener(){
                                              @Override
                                              public void onClick(DialogInterface dialog, int which) {
                                                  Intent Main2Activity = new Intent(PerguntasActivity.this,Main2Activity.class);
                                                  startActivity(Main2Activity);
                                                  j = 0;
                                              }
                                          }
                                  );
                                  dialogo.show();
                              }
                              break;

                          case "Português":
                              if (j != 2) {

                                  if (op == R.id.op1) {
                                      if (p1.getText().toString().equals(por2.get(nrand)[0])) {
                                          acertos++;
                                          j++;
                                          setaTextos(por,por2,viewpergunta,p1,p2,p3,p4);
                                      } else {
                                          j++;
                                          setaTextos(por,por2,viewpergunta,p1,p2,p3,p4);
                                      }
                                  } else if (op == R.id.op2) {
                                      if (p2.getText().toString().equals(por2.get(nrand)[0])) {
                                          acertos++;
                                          j++;
                                          setaTextos(por,por2,viewpergunta,p1,p2,p3,p4);
                                      } else {
                                          j++;
                                          setaTextos(por,por2,viewpergunta,p1,p2,p3,p4);
                                      }
                                  } else if (op == R.id.op3) {
                                      if (p3.getText().toString().equals(por2.get(nrand)[0])) {
                                          acertos++;
                                          j++;
                                          setaTextos(por,por2,viewpergunta,p1,p2,p3,p4);
                                      } else {
                                          j++;
                                          setaTextos(por,por2,viewpergunta,p1,p2,p3,p4);
                                      }
                                  } else if (op == R.id.op4) {
                                      if (p4.getText().toString().equals(por2.get(nrand)[0])) {
                                          j++;
                                          acertos++;
                                          setaTextos(por,por2,viewpergunta,p1,p2,p3,p4);
                                      } else {
                                          j++;
                                          setaTextos(por,por2,viewpergunta,p1,p2,p3,p4);
                                      }
                                  }
                              } else {

                                  AlertDialog.Builder dialogo = new
                                          AlertDialog.Builder(PerguntasActivity.this);
                                  dialogo.setTitle("Resultado");
                                  dialogo.setMessage("Voce acertou: "+ acertos + " de 3 perguntas");
                                  dialogo.setNeutralButton("OK",new
                                          DialogInterface.OnClickListener(){
                                              @Override
                                              public void onClick(DialogInterface dialog, int which) {
                                                  Intent Main2Activity = new Intent(PerguntasActivity.this,Main2Activity.class);
                                                  startActivity(Main2Activity);
                                                  j = 0;
                                              }
                                          }
                                  );
                                  dialogo.show();
                              }
                              break;
                          case "Lógica":
                              if (j != 2) {

                                  if (op == R.id.op1) {
                                      if (p1.getText().toString().equals(log2.get(nrand)[0])) {
                                          acertos++;
                                          j++;
                                          setaTextos(log,log2,viewpergunta,p1,p2,p3,p4);
                                      } else {
                                          j++;
                                          setaTextos(log,log2,viewpergunta,p1,p2,p3,p4);
                                      }
                                  } else if (op == R.id.op2) {
                                      if (p2.getText().toString().equals(log2.get(nrand)[0])) {
                                          acertos++;
                                          j++;
                                          setaTextos(por,por2,viewpergunta,p1,p2,p3,p4);
                                      } else {
                                          j++;
                                          setaTextos(por,por2,viewpergunta,p1,p2,p3,p4);
                                      }
                                  } else if (op == R.id.op3) {
                                      if (p3.getText().toString().equals(por2.get(nrand)[0])) {
                                          acertos++;
                                          j++;
                                          setaTextos(por,por2,viewpergunta,p1,p2,p3,p4);
                                      } else {
                                          j++;
                                          setaTextos(por,por2,viewpergunta,p1,p2,p3,p4);
                                      }
                                  } else if (op == R.id.op4) {
                                      if (p4.getText().toString().equals(por2.get(nrand)[0])) {
                                          j++;
                                          acertos++;
                                          setaTextos(por,por2,viewpergunta,p1,p2,p3,p4);
                                      } else {
                                          j++;
                                          setaTextos(por,por2,viewpergunta,p1,p2,p3,p4);
                                      }
                                  }
                              } else {

                                  AlertDialog.Builder dialogo = new
                                          AlertDialog.Builder(PerguntasActivity.this);
                                  dialogo.setTitle("Resultado");
                                  dialogo.setMessage("Voce acertou: "+ acertos + " de 3 perguntas");
                                  dialogo.setNeutralButton("OK",new
                                          DialogInterface.OnClickListener(){
                                              @Override
                                              public void onClick(DialogInterface dialog, int which) {
                                                  Intent Main2Activity = new Intent(PerguntasActivity.this,Main2Activity.class);
                                                  startActivity(Main2Activity);
                                                  j = 0;
                                              }
                                          }
                                  );
                                  dialogo.show();
                              }
                              break;

                          default:
                              break;
                      }
                  }
                });
    }
}
