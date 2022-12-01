package com.deleon.sorteiorapido;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultadoActivity extends AppCompatActivity {
    private TextView textoResultado;
    private Button btVoltar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

         textoResultado = findViewById(R.id.textoResultado);
         btVoltar = findViewById(R.id.btVoltar);
        /*Para fazer a utilização de dados de uma Activity para outra utilizamos o objeto Bundle
        onde o getIntent mostrará a Activity que queremos pegar a informação enquanto o getExtras
        estará trazendo as informações declaradas dentro do putExtra
         */

        Bundle dados = getIntent().getExtras();

        /*Agora iremos fazer uma verificação. Se o dado passado nos limite inf e superior forem
        diferentes de nulo a variável textoResultado irá obter o valot para ela e imprimir na tela
         */

        if(dados != null){
            int resultado = dados.getInt("result");
            /*Explicando: Se a variavel dados for diferente de nulo a variável resultado irá
            receber  um valor inteiro, o result é o parâmetro de chamada, que está chamando a
            variávvel resultado lá da outra Activity.

            Agora a variável textoResultado irá receber a variável Resultado
             */

            textoResultado.setText("" + resultado);
        }

        btVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }
}