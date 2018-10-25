package com.example.antug.hello;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.net.MalformedURLException;
import java.net.URL;

public class TwoActivity extends AppCompatActivity {

    ImageView imgView;
    Button btn;

    String urlNormalForm    = "https://assets.pokemon.com//assets//cms2//img//pokedex//full//041.png";
    String urlShinyForm     = "https://portalwonder.com.br//wp-content//uploads//2018//06//041_Zubat_ShinyOtm.png";

    String urlAtual = "https://assets.pokemon.com//assets//cms2//img//pokedex//full//041.png";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        imgView = findViewById(R.id.imgZubat);
        imgView.setDrawingCacheEnabled(true);
        imgView.setOnTouchListener(touchZubat);

        btn = findViewById(R.id.btnForm);

        imgView.setTag(urlAtual);

        new DownloadImgAsync().execute(imgView);
    }

    private final View.OnTouchListener touchZubat = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            Bitmap bitMap = Bitmap.createBitmap(v.getDrawingCache());
            int color = bitMap.getPixel((int) event.getX(), (int) event.getY());
            if (color == Color.TRANSPARENT) {
                Log.d("aaaaaa", "onTouch: ddddddddd");
                return true;
            } else {
                return false;
            }
        }
    };

    public void clickBat(View view) {
        finish();
    }

    public void changeImg(View view) {

        if (urlAtual == urlNormalForm) {
            urlAtual = urlShinyForm;
            btn.setText("Normal Form");
        } else {
            urlAtual = urlNormalForm;
            btn.setText("Shiny Form");
        }

        imgView.setTag(urlAtual);

        new DownloadImgAsync().execute(imgView);
    }
}