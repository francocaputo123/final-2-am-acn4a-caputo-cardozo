package com.example.learnyourself;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.io.OutputStreamWriter;

public class Register extends AppCompatActivity {

    private EditText nt, lnt, unt, up;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        nt = findViewById(R.id.nameText);
        lnt = findViewById(R.id.lastNameText);
        unt = findViewById(R.id.userNameText);
        up = findViewById(R.id.passwordText);
    }

    public void regis(View v){
        //capturo los datos de todos los EditText
        String userRegister = unt.getText().toString();
        String nameText = nt.getText().toString();
        String lastNameText = lnt.getText().toString();
        String userNameText = unt.getText().toString();
        String passwordText = up.getText().toString();

        //verifico si todos los campos estan vacios
        if(nameText.isEmpty() || lastNameText.isEmpty() || userNameText.isEmpty() || passwordText.isEmpty()){
            Toast.makeText(this, "Algunos de los campos estan vacios", Toast.LENGTH_SHORT).show();
        } else {
            try
            {
                //verificacion de si existe el archivo que se intenta cear, pasando el usuario como referencia
                if(getFileStreamPath(userRegister).exists()){
                    Toast.makeText(this, "Usuario en uso, ingrese otro usuario",Toast.LENGTH_SHORT).show();
                } else {
                    //creacion del archivo y cada uno de los campos provenientes de los edit
                    OutputStreamWriter user = new OutputStreamWriter(openFileOutput(userRegister, Context.MODE_PRIVATE));
                    user.write(nameText + "\n");
                    user.write(lastNameText + "\n");
                    user.write(userNameText + "\n");
                    user.write(passwordText + "\n");
                    user.flush();
                    nt.setText("");
                    lnt.setText("");
                    unt.setText("");
                    up.setText("");
                    Toast.makeText(this,"Usuario registrado con éxito, vuelva a la pantalla inicial e ingrese con su usuario", Toast.LENGTH_SHORT).show();

                }
            } catch(IOException e){
                Toast.makeText(this, "Error desconocido, intentelo nuevamente", Toast.LENGTH_SHORT).show();
            }
        }

    }
    //metodo para volver a la anterior activity
    public void preView(View v)
    {
        finish();
    }
}