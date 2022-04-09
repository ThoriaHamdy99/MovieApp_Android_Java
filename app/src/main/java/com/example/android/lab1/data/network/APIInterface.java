package com.example.android.lab1.data.network;

import com.example.android.lab1.data.model.Movie;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIInterface {

    @GET("movies.json")
    Call<List<Movie>> getAllMovies();
}
