package com.example.para_entregar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button button_perfil; //cria o botão privado referente ao perfil / login

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_perfil = findViewById(R.id.button_perfil); // encontra o botão na interface usando id

        // configura um ouvinte de clique para o botão perfil
        button_perfil.setOnClickListener(new View.OnClickListener() {

            @Override
           // metodo chamado quando o botão é clicado
            public void onClick(View view) {
              //  cria uma intent  para iniciar a activy perfil
                Intent intent = new Intent(MainActivity.this,Perfil.class);
               // inicia a activy perfil
                startActivity(intent);
            }
        });
        //recupera e exibe a saudação  se o perfil já foi armazenado
        SharedPreferences preferences = getSharedPreferences("profile",MODE_PRIVATE);
        // recupera o nome salvo nas preferencias
        String namesaved = preferences.getString("name","");
        // verifica se o nome salvo n está vazio
        if (!namesaved.isEmpty()) {
            // exibe o toast informando o usuario
            Toast.makeText(this,"Olá "+ namesaved, Toast.LENGTH_SHORT).show();
        }


    }
}