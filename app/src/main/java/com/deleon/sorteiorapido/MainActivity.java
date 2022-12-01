package com.deleon.sorteiorapido;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private EditText etLimiteInferior;
    private EditText etLimiteSuperior;
    private Button btSortear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //1º Fazendo os Find VIew By Id

        etLimiteInferior = findViewById(R.id.etLimiteInf);
        etLimiteSuperior= findViewById(R.id.etLimiteSup);
        btSortear = findViewById(R.id.btSortear);

        /*Adicionando método de click onde quando eu clicar em Sortear o botão me mandará pra outra
        Activity, que será a tela de Resultado
         */

        /*O SetOnClickListener é o responsável por fazer essa conexão quando clicarmos no botão
        sortear ele vai executar o código que está dentro do onClick
        //Devemos adicionar o new entre parentese para ser criado um novo objeto anônimo

         */
        btSortear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*
                Aqui iremos criar uma variável que pegará a String que está dentro de
                etLimiteInferior e etlimiteSuperior e converterá a mesma para INT

                A variável pegara o EtLimiteInferior mostrará o Texto em String e convererá
                para INT, essa é a função do parseInt, no caso está pegando o texto em String
                e convertendo para Inteiro


                 */
                int limiteInf = Integer.parseInt(etLimiteInferior.getText().toString());
                int limiteSup = Integer.parseInt(etLimiteSuperior.getText().toString());

                //Agora vmaos gerar o número aleatório
               int resultado = new Random().nextInt(limiteSup-limiteInf+1)+ limiteInf;
                //Dentro do parenteses iremos adicionar o limite de número a ser sorteado de 0 a N+1

                /*
                Obs:
                Para sortearmos valores de 5 a 10 por exemplo devemos colocar o seguinte código
                ... .nextInt(10-5+1)+5;
                 */


                //Agora vamos chamar a outra Intent para podermos mostrar o valor na Tela de Resultado
                Intent intent = new Intent(MainActivity.this, ResultadoActivity.class);
                //Para passarmos o resultado para dentro do campo da Bola devemos utilizar:


                /* O primeiro parâmetro é o parâmetro de chamada de dados onde teremos que
                declara-lo dentro da nossa  classe 'ResultadoActivity' e a variável resultado
                é a que vai ser inserida no campo.
                 */
                intent.putExtra("result" , resultado);

                startActivity(intent);







            }
        });
    }
}