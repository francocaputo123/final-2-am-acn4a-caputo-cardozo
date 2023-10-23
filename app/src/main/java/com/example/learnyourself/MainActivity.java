package com.example.learnyourself;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    private EditText userText, userPassword;
    private String[] content;

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

    //Método para boton de recuperar contraseña
    public void recoveryPass(View v){
        Intent i = new Intent(this, Recovery.class);
        startActivity(i);
    }

    //metodo para loguearse
    public void login(View v){
        String userN = userText.getText().toString();
        try{
            //se crea un inputStreamReader para leer el archivo y el bufferReader para leer linea por linea
            InputStreamReader file = new InputStreamReader(openFileInput(userN));
            BufferedReader br = new BufferedReader(file);
            //inicializo el array
            content = new String[4];
            String line = br.readLine();
            int i = 0;
            //guardo todos los strings provenientes del archivo dentro del array
            while(line != null && i < 4 ){
                //guargo en el array y salto la linea
                content[i] = line;
                i++;
                line = br.readLine();
            }
            //cierro el archivo y el lector buffer
            br.close();
            file.close();

            String edit1 = content[2];
            String edit2 = content[3];

            if (userText.getText().toString().equals(edit1) && userPassword.getText().toString().equals(edit2)) {
                // Acceso permitido, inicia la actividad
                Intent in = new Intent(this, Course.class);
                in.putExtra("name", content[0]);
                startActivity(in);
            } else {
                // Usuario o contraseña incorrectos, muestra un mensaje de error
                Toast.makeText(this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
            }

        } catch (IOException e){
            Toast.makeText(this, "No existe el usuario", Toast.LENGTH_SHORT).show();
        }


    }
}