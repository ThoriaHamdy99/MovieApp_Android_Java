package com.example.android.lab1.favouriteMovies.presenter;

import androidx.lifecycle.LifecycleOwner;

import com.example.android.lab1.data.model.Movie;

public interface FavouritePresenterInterface {
    public void getAllMovies(LifecycleOwner lifecycleOwner);
    public void removeMovie(Movie movie);
}
