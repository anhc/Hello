package com.example.antug.hello;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class RecViewActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter recViewAdapter;

    RequisicaoOMDB requisicaoOMDB;

    String[] myData = {"Australia", "Japan", "United States", "Canada", "France", "England", "Brazil", "China",
    "Corea", "Russia", "Argentina", "Italia", "Finland", "Germany"};

    Movie[] movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rec_view);

        recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        requisicaoOMDB = new RequisicaoOMDB(this);

        requisicaoOMDB.fazRequest("batman");

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                movies = requisicaoOMDB.getMovies();
                recViewAdapter = new RecViewAdapter(movies);
                recyclerView.setAdapter(recViewAdapter);
            }
        }, 300);
    }

    public void textAdpClick (View view) {

        TextView tv = (TextView) view;
        Log.d("dwkadkwad", (String) tv.getText());
    }
}
