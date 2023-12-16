package com.example.learnyourself;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class LearnRoute extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_route);
   }

    public void dowload (View v){
        ImageView imageview15 = findViewById(R.id.imageView15);
        ImageDowloaderJava descarga = new ImageDowloaderJava(imageview15);
        descarga.execute("https://wallpapercave.com/wp/wp7250087.jpg");
    }


    public void volver(View v){finish();}
}
