package com.example.android.lab1.data.network;

import android.content.Context;

import com.example.android.lab1.data.model.Movie;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MovieClient {
    //private List<Movie> movies;
    private MovieClient movieClient = null;
    private NetworkDelegate networkDelegate;
    private Context context;

    public MovieClient(Context context, NetworkDelegate networkDelegate){
        this.context = context;
        this.networkDelegate = networkDelegate;
        start();
    }

    private void start(){
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
