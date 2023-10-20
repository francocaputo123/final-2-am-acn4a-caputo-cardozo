package com.example.learnyourself;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Recovery extends AppCompatActivity {

    private EditText editUser, editPass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recovery);
        editUser = findViewById(R.id.editUser);
        editPass = findViewById(R.id.editPass);
    }
    //metodo volver hacai atras
    public void preView2(View v){ finish(); }

    //Método de recuperación de contraseña
    public void recovery(View v){
        //Caputuro lo que me llega en los edit.
        String eu= editUser.getText().toString();
        String ep = editPass.getText().toString();
        try {
            //Verifico si el usuario ingresado existe.
            if(getFileStreamPath(eu).exists()){
                InputStreamReader in = new InputStreamReader(openFileInput(eu));
                BufferedReader br = new BufferedReader(in);

                //Lectura del archivo y almacenaje de cada linea dentro de un array.
                String content[] = new String[4];
                for(int i = 0; i < 3; i++){
                    String line = br.readLine();
                        content[i] = line;
                }
                //reemplazo la 4ta linea con la nueva contraseña
                content[3] = ep.trim();

                OutputStreamWriter ou = new OutputStreamWriter(openFileOutput(eu, Context.MODE_PRIVATE));
                for (int i = 0; i < 4; i++) {
                    //sobreescribo todos los archivos nuevos, mas la contraseña.
                    ou.write(content[i] + "\n");
                }
                editUser.setText("");
                editPass.setText("");
                br.close();
                ou.close();
                Toast.makeText(this,"Contraseña actualizada con éxito",Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Usuario no encontrado", Toast.LENGTH_SHORT).show();
            }

        } catch(IOException e){
            Toast.makeText(this, "No se pudo recuperar la contraseña", Toast.LENGTH_SHORT);
        }
    }

}