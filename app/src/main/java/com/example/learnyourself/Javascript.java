package com.example.learnyourself;

import androidx.appcompat.app.AppCompatActivity;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

public class Javascript extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_javascript);

    }

    public void dowload (View v){
        ImagenDowloader descarga = new ImagenDowloader();
        descarga.execute("https://upload.wikimedia.org/wikipedia/commons/6/6a/JavaScript-logo.png");
    }

    public void volver(View v)
    {
        finish();
    }
}

