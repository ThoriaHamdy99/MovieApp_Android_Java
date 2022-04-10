package com.example.android.lab1.favouriteMovies.presenter;

import android.content.Context;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;

import com.example.android.lab1.data.model.Movie;
import com.example.android.lab1.data.model.Repository;
import com.example.android.lab1.favouriteMovies.view.FavouriteActivity;
import com.example.android.lab1.favouriteMovies.view.FavouriteActivityInterface;

import java.util.List;

public class FavouritePresenter implements FavouritePresenterInterface {
    Repository repository;
    Context context;
    FavouriteActivityInterface favouriteActivityInterface;

    public FavouritePresenter(Context context, FavouriteActivityInterface favouriteActivityInterface){
        this.context = context;
        repository = new Repository(context);
        this.favouriteActivityInterface = favouriteActivityInterface;

    }

    @Override
    public void getAllMovies(LifecycleOwner lifecycleOwner) {
        repository.getStoredMovies().observe(lifecycleOwner, new Observer<List<Movie>>() {
            @Override
            public void onChanged(List<Movie> movies) {
                favouriteActivityInterface.showMovie(movies);
            }
        });
    }

    @Override
    public void removeMovie(Movie movie) {
        repository.delete(movie);
    }
}
