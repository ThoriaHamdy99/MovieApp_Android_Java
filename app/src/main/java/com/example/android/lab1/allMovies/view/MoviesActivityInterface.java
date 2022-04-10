package com.example.android.lab1.allMovies.view;

import com.example.android.lab1.data.model.Movie;

import java.util.List;

public interface MoviesActivityInterface {
    public void showMovie(List<Movie> movies);
    public void showError(String errorMsg);
    public void showIfInsertedSuccessfully(Boolean flag);

}
