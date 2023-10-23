package com.example.learnyourself;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Profile extends AppCompatActivity {

    private EditText editName, editLastName, pEditPass;
    private String pathName;
    private TextView e;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        editName = findViewById(R.id.editName);
        editLastName = findViewById(R.id.editLastName);
        pEditPass = findViewById(R.id.pEditPass);

        pathName = getIntent().getStringExtra("name");
    }

    public void preView3(View v)
    {
        finish();
    }

    public void changeProfile(View v)
    {
        String en = editName.getText().toString();
        String eln = editLastName.getText().toString();
        String pep = pEditPass.getText().toString();
        try {
            if(en.isEmpty() || eln.isEmpty() || pep.isEmpty()){
                Toast.makeText(this, "Alguno de los campos están vacios", Toast.LENGTH_SHORT).show();
             } else {
                //verifico si exite el usuario en los data files
                if (getFileStreamPath(pathName).exists()) {
                    InputStreamReader in = new InputStreamReader(openFileInput(pathName));
                    BufferedReader br = new BufferedReader(in);

                    //Lectura del archivo y almacenaje de cada linea dentro de un array.
                    String content[] = new String[4];
                    for (int i = 0; i < 3; i++) {
                        String line = br.readLine();
                        content[i] = line;
                    }

                    //reemplazo el nombre, el apellido y la contraseña.
                    content[0] = en.trim();
                    content[1] = eln.trim();
                    content[3] = pep.trim();

                    OutputStreamWriter ou = new OutputStreamWriter(openFileOutput(pathName, Context.MODE_PRIVATE));
                    for (int i = 0; i < 4; i++) {
                        //sobreescribo todos los archivos nuevos.
                        ou.write(content[i] + "\n");
                    }
                    br.close();
                    in.close();
                    ou.close();
                    editName.setText("");
                    editLastName.setText("");
                    pEditPass.setText("");
                    Toast.makeText(this, "Se actualizaron los datos ", Toast.LENGTH_SHORT).show();
                }
             }
        } catch(IOException e){
            Toast.makeText(this, "No se pudieron actualizar sus datos", Toast.LENGTH_SHORT).show();
        }
    }
    }