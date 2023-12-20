package com.example.learnyourself;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.URL;

public class ImageDownloaderPhyton extends AsyncTask<String, Integer, Bitmap> {

    private Bitmap imagenDescargada = null;
    private ImageView imageView;

    public ImageDownloaderPhyton(ImageView imageView){
        this.imageView = imageView;
    }
    @Override
    protected Bitmap doInBackground(String... strings) {
        String URL_consulta = strings[0];
        try {
            URL consulta = new URL(URL_consulta);
            InputStream contenido = (InputStream) consulta.getContent();

            imagenDescargada = BitmapFactory.decodeStream(contenido);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return imagenDescargada;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        if (bitmap == null) {

            return;
        }
        this.imageView.setImageBitmap(bitmap);
    }
}
