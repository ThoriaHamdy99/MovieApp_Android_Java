package com.example.android.lab1.data.network;

import android.content.Context;

import com.example.android.lab1.data.model.Movie;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MovieClient implements RemoteSourceInterface{
    //private List<Movie> movies;
    private MovieClient movieClient = null;

    public MovieClient(){

    }

    @Override
    public void enqueueCall(NetworkDelegate networkDelegate) {
        APIRetrofit.getClient().getAllMovies().enqueue(new Callback<List<Movie>>() {
            @Override
            public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {
                networkDelegate.onSuccessResult(response.body());
            }

            @Override
            public void onFailure(Call<List<Movie>> call, Throwable t) {
                networkDelegate.onFailureResult(t.getMessage());
            }
        });
    }
}
