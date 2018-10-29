package com.example.antug.hello;

public class Movie {
    String titulo;
    String posterURL;

    public Movie(String titulo, String posterURL) {
        this.titulo = titulo;
        this.posterURL = posterURL;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public String getPosterURL() {
        return this.posterURL;
    }
}
