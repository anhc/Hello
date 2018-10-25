package com.example.antug.hello;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.net.MalformedURLException;
import java.net.URL;

public class DownloadImgAsync extends AsyncTask<ImageView, Void, Bitmap> {

    ImageView imgView = null;

    @Override
    protected Bitmap doInBackground(ImageView... imageViews) {
        Bitmap bitmap = null;

        this.imgView = imageViews[0];
        try {
            bitmap = BitmapFactory.decodeStream( new URL((String) imgView.getTag()).openStream());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return bitmap;
    }

    @Override
    protected void onPostExecute(Bitmap result) {

        imgView.setImageBitmap(result);
    }
}
