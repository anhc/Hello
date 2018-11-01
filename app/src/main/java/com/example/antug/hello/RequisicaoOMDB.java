package com.example.antug.hello;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class RequisicaoOMDB {
    String jsonUrlRequest;
    String apiKeyOMDB = "&apikey=96330142";
    Movie movies[];

    public void setJsonUrlRequest(String txtSearch) {
        jsonUrlRequest = "http://www.omdbapi.com/?s=" + txtSearch + apiKeyOMDB;
    }

    public String getJsonUrlRequest() {
        return jsonUrlRequest;
    }

    public Movie[] getMovies() {
        return movies;
    }

    public Movie[] fazRequest(JSONArray jsonArray) {

        movies = new Movie[jsonArray.length()];

        for (int i = 0; i < jsonArray.length(); i++) {
            try {
                JSONObject searchResult = jsonArray.getJSONObject(i);

                String titulo = searchResult.getString("Title");
                String posterURL = searchResult.getString("Poster");
                Log.d("RESPONSE REQ", "onResponse: " + titulo);

                movies[i] = new Movie(titulo, posterURL);
            } catch(JSONException e) {
                e.printStackTrace();
            }
        }
        return getMovies();
    }
}
