package com.example.android.lab1.allMovies.presenter;

import android.content.Context;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;

import com.example.android.lab1.allMovies.view.MoviesActivity;
import com.example.android.lab1.allMovies.view.MoviesActivityInterface;
import com.example.android.lab1.data.model.Movie;
import com.example.android.lab1.data.model.Repository;
import com.example.android.lab1.data.network.MovieClient;
import com.example.android.lab1.data.network.NetworkDelegate;

import java.util.List;

public class AllMoviesPresenter implements NetworkDelegate, AllMoviesPresenterInterface {

    Context context;
    MoviesActivityInterface moviesActivityInterface;
    Repository repository;

    public AllMoviesPresenter(){

    }
    public AllMoviesPresenter(Context context, MoviesActivityInterface moviesActivityInterface){
        this.context = context;
        this.moviesActivityInterface = moviesActivityInterface;
        repository = new Repository(context);
    }

    @Override
    public void getAllMovies() {
        repository.getRemoteMovies(this);
    }

    @Override
    public void onSuccessResult(List<Movie> movies) {
        moviesActivityInterface.showMovie(movies);
    }

    @Override
    public void onFailureResult(String errorMsg) {
        moviesActivityInterface.showError(errorMsg);
    }

    public void addMovie(Movie movie, LifecycleOwner lifecycleOwner) {
        repository.insert(movie);
//        repository.getMovie(movie.title).observe(lifecycleOwner, new Observer<Movie>() {
//            @Override
//            public void onChanged(Movie movie) {
//                if(movie == null){
//                    repository.insert(movie);
//                    moviesActivityInterface.showIfInsertedSuccessfully(true);
//                }
//            }
//        });
//        moviesActivityInterface.showIfInsertedSuccessfully(false);
    }

}
