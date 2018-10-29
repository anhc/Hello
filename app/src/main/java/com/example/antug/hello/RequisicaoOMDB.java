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
    RequestQueue requestQueue;
    String jsonUrlRequest;
    String apiKeyOMDB = "&apikey=96330142";
    Movie movies[];
    boolean chegouResposta = false;

    public RequisicaoOMDB(Context context) {
        requestQueue = Volley.newRequestQueue(context);
    }

    public void setJsonUrlRequest(String txtSearch) {
        jsonUrlRequest = "http://www.omdbapi.com/?s=" + txtSearch + apiKeyOMDB;
    }

    public Movie[] getMovies() {
        return movies;
    }

    public void fazRequest(String txtSearch) {
        setJsonUrlRequest(txtSearch);

        final JsonObjectRequest jsonObjRequest = new JsonObjectRequest
                (Request.Method.GET, jsonUrlRequest, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                            JSONArray jsonArray = response.getJSONArray("Search");

                            movies = new Movie[jsonArray.length()];

                            for(int i = 0; i < jsonArray.length(); i++) {
                                JSONObject searchResult = jsonArray.getJSONObject(i);

                                String titulo = searchResult.getString("Title");
                                String posterURL = searchResult.getString("Poster");
                                Log.d("RESPONSE REQ", "onResponse: " + titulo);

                                movies[i] = new Movie(titulo, posterURL);

                                chegouResposta = true;
                            }
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
}
