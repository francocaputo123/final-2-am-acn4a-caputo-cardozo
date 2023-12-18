package com.example.learnyourself;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Mysql extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mysql);
    }


    public void dowload (View v){
        ImageView imageview = findViewById(R.id.imageView);
        ImageDownloaderMySql descarga = new ImageDownloaderMySql(imageview);
        descarga.execute("https:  //tse4.mm.bing.net/th?id=OIP.kV1bZdb28RGUp3f3ECnG5AHaHa&pid=Api&P=0&h=180");
    }

    public void volver(View v)
    {
        finish();
    }
    }
