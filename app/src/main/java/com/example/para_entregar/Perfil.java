package com.example.para_entregar;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Perfil extends AppCompatActivity {

    // Declaração dos campos EditText para armazenar as referencias
    EditText name_edit, email_edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        // Encontra o botão  e o campos de entrada
        Button buttonsave = findViewById(R.id.buttonsave);
        name_edit = findViewById((R.id.name_edit));
        email_edit = findViewById(R.id.edit_email);

        // Configura um ouvinte para o botão gravar
        buttonsave.setOnClickListener(new View.OnClickListener() {

            @Override
           // Metodo chamado quando é clicado no botão gravar
            public void onClick(View view) {
               // chama o metodo para salvar
                saveprofile();
            }
        });

    }
    // Metodo para salvar dados do perfil no SharedPreferences
    private void saveprofile(){
        // obtém uma referencia ao objeto sharedpreferences
        SharedPreferences preferences = getSharedPreferences("profile", Context.MODE_PRIVATE);
        // obtém um editor para modificar as preferencias
        SharedPreferences.Editor editor = preferences.edit();
       // armazena os valores dos camos nome e email nas preferencias
        editor.putString("name",name_edit.getText().toString());
        editor.putString("email", email_edit.getText().toString());
        // aplica as alterações
        editor.apply();
        // exibe um toast informando que o perfil foi salvo
        Toast.makeText(this,"Profile saved successfully",Toast.LENGTH_SHORT).show();
    }
}