package com.example.antug.hello;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class RecViewActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter recViewAdapter;
    RequestQueue requestQueue;

    RequisicaoOMDB requisicaoOMDB;

    /*String[] myData = {"Australia", "Japan", "United States", "Canada", "France", "England", "Brazil", "China",
    "Corea", "Russia", "Argentina", "Italia", "Finland", "Germany"};*/

    Movie[] movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rec_view);

        recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        requestQueue = Volley.newRequestQueue(this);

        requisicaoOMDB = new RequisicaoOMDB();

        setRecViewMovies();
    }

    public void setRecViewMovies() {
        requisicaoOMDB.setJsonUrlRequest("batman");

        final JsonObjectRequest jsonObjRequest = new JsonObjectRequest
            (Request.Method.GET, requisicaoOMDB.getJsonUrlRequest(), null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {

                try {
                    JSONArray jsonArray = response.getJSONArray("Search");

                    movies = requisicaoOMDB.fazRequest(jsonArray);

                    recViewAdapter = new RecViewAdapter(movies);
                    recyclerView.setAdapter(recViewAdapter);

                } catch(JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        requestQueue.add(jsonObjRequest);
    }

    public void textAdpClick (View view) {
        TextView tv = (TextView) view;
        Log.d("dwkadkwad", (String) tv.getText());
        Toast.makeText(this, tv.getText(), Toast.LENGTH_SHORT).show();
    }

    public void clickFloatBtn (View view) {
        Toast.makeText(this, "Click FAB", Toast.LENGTH_SHORT).show();
    }
}
