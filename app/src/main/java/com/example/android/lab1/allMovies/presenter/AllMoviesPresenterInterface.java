package com.example.android.lab1.allMovies.presenter;

import androidx.lifecycle.LifecycleOwner;

import com.example.android.lab1.data.model.Movie;

public interface AllMoviesPresenterInterface {
    public void getAllMovies();
    public void addMovie(Movie movie, LifecycleOwner lifecycleOwner);
}
