package com.example.learnyourself;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    private EditText userText, userPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userText = findViewById(R.id.userEdit);
        userPassword = findViewById(R.id.passEdit);
    }

    //Método para el botón de registro: cambia de activity a la pagina registro.
    public void registerAc(View v)
    {
        Intent i = new Intent(this, Register.class);
        startActivity(i);
    }

    public void login(){


    }
}