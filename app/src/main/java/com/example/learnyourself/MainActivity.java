package com.example.learnyourself;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText userText, userPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //userText = findViewById(R.id.userText);
        //userPassword = findViewById(R.id.userPassword);
    }

    //Método para el botón de registro: cambia de activity a la pagina registro.
    public void register(View v)
    {
        Intent i = new Intent(this, Register.class);
        startActivity(i);
    }

}