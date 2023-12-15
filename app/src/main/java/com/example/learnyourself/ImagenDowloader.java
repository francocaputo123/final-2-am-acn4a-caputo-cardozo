package com.example.learnyourself;

import android.graphics.Bitmap;
import android.os.AsyncTask;

public class ImagenDowloader extends AsyncTask<String, Integer, Bitmap> {
    private Bitmap imagenDescargada = null;
    @Override
    protected Bitmap doInBackground(String... strings)
    {
        return imagenDescargada;
    }
}
