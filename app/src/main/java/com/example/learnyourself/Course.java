package com.example.learnyourself;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class Course extends AppCompatActivity {

    private TextView title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);

        title = findViewById(R.id.c_title);

        String name = getIntent().getStringExtra("name");
        title.setText("Hola " + name);
    }

    //metodo para la seleccion de cursos
    public void selectCourse(View v) {
        String buttonTag = (String) v.getTag();
        if (buttonTag != null) {
            Intent in = new Intent(this, LearnRoute.class);

            switch (buttonTag) {
                case "js":
                    startActivity(in);
                    break;

                case "java":
                    startActivity(in);
                    break;

                case "mysql":
                    startActivity(in);
                    break;

                case "php":
                    startActivity(in);
                    break;

                case "piton":
                    startActivity(in);
                    break;

                default:
                    Toast.makeText(this, "Error al seleccionar", Toast.LENGTH_SHORT).show();

            }
        }
    }

    public void create(View v){
        Toast.makeText(this, "Estamos en la creacion de esta sección", Toast.LENGTH_SHORT).show();
    }

    public void profile(View v){
        Intent in = new Intent(this, Profile.class);
        startActivity(in);
    }
}