package com.example.learnyourself;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Javascript extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_javascript);

    }

    public void dowload (View v){
        ImageView imageview = findViewById(R.id.imageView);
        ImageDownloader descarga = new ImageDownloader(imageview);
        descarga.execute("https://clipground.com/images/logo-javascript-clipart-1.jpg");
    }

    public void volver(View v)
    {
        finish();
    }
}

