package com.example.antug.hello;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Intent intent;
    RequisicaoOMDB requisicaoOMDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.tvAnswer);
        intent = new Intent(this, RecViewActivity.class);

        requisicaoOMDB = new RequisicaoOMDB(this);


    }

    public void callTheBest(View view) {
        textView.setText("The Best");
        startActivity(intent);

        /*requisicaoOMDB.fazRequest("batman");

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Log.d("AUIQUIQUIQUIQ", "ddddd: " + requisicaoOMDB.getMovies()[0].getTitulo());
            }
        }, 300);
        Log.d("AUIQUIQUIQUIQ", "ddddd: semsemsem");*/
    }
}
