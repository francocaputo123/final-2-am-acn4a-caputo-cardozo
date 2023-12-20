package com.example.learnyourself;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import android.widget.ImageView;



public class Phyton extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phyton);
    }



    public void dowload (View v){
        ImageView imageview = findViewById(R.id.imageView);
        ImageDownloaderPhyton descarga = new ImageDownloaderPhyton(imageview);
        descarga.execute("https://tse2.mm.bing.net/th?id=OIP.hicFMnjJf8GyP0sleHrTbAHaE-&pid=Api&P=0&h=180");
    }

    public void volver(View v)
    {
        finish();
    }


}