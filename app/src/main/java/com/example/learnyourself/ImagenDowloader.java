package com.example.learnyourself;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.util.Log;

public class ImagenDowloader extends AsyncTask<String, Integer, Bitmap> {
    private Bitmap imagenDescargada = null;
    @Override
    protected Bitmap doInBackground(String... strings)
    {
        String URL = strings[0];
        Log.i("testing", URL);
        return imagenDescargada;
    }
}
