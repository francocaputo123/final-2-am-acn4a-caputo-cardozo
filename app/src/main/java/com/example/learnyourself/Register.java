package com.example.learnyourself;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
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

    public void regis(){
        String userRegister = unt.getText().toString();
        String nameText = nt.getText().toString();
        String lastNameText = lnt.getText().toString();
        String userNameText = unt.getText().toString();
        String passwordText = up.getText().toString();

        try
        {
            OutputStreamWriter user = new OutputStreamWriter(openFileOutput(userRegister, Context.MODE_PRIVATE));
            user.write(nameText);
            user.write(lastNameText);
            user.write(userNameText);
            user.write(passwordText);
            user.flush();
            nt.setText("");
            lnt.setText("");
            unt.setText("");
            up.setText("");
            Toast.makeText(this,"Usuario registrado con éxito, vuelva a la pantalla inicial e ingrese con su usuario", Toast.LENGTH_SHORT);
        } catch(IOException e){
            Toast.makeText(this, "No se pudo crear el usuario, intentelo denuevo", Toast.LENGTH_SHORT);
        }
    }
    public void preView()
    {
        finish();
    }
}