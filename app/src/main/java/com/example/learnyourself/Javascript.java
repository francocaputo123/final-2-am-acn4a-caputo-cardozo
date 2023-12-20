package com.example.learnyourself;

import androidx.appcompat.app.AppCompatActivity;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;

import android.widget.ImageView;

import android.widget.LinearLayout;


public class Javascript extends AppCompatActivity {

       @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_javascript);

    }

    public void dowload (View v){
        ImageView imageview = findViewById(R.id.imageView);
        ImageDownloaderJavascript descarga = new ImageDownloaderJavascript(imageview);
        descarga.execute("https://clipground.com/images/logo-javascript-clipart-1.jpg");

    }

    public void volver(View v)
    {
        finish();
    }
}

