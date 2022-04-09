package com.example.android.lab1.data.model;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.android.lab1.data.db.MovieDAO;
import com.example.android.lab1.data.db.MovieDatabase;

import java.util.List;

public class Repository {
    private Context context;
    private MovieDAO movieDAO;
    private LiveData<List<Movie>> storedMovies;

    public Repository(Context context){
        this.context = context;
        MovieDatabase movieDatabase = MovieDatabase.getInstance(context.getApplicationContext());
        movieDAO = movieDatabase.movieDAO();
        storedMovies = movieDAO.getAllMovies();
    }

    public LiveData<List<Movie>> getStoredMovies(){
        return storedMovies;
    }

    public void insert(Movie movie){
        new Thread(new Runnable() {
            @Override
            public void run() {
                movieDAO.insertMovie(movie);
            }
        }
        ).start();
    }
    public void delete(Movie movie){
        new Thread(new Runnable() {
            @Override
            public void run() {
                movieDAO.deleteMovie(movie);
            }
        }
        ).start();
    }

}
