package com.example.android.lab1.data.model;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.android.lab1.data.db.MovieDAO;
import com.example.android.lab1.data.db.MovieDatabase;
import com.example.android.lab1.data.network.MovieClient;
import com.example.android.lab1.data.network.NetworkDelegate;
import com.example.android.lab1.data.network.RemoteSourceInterface;

import java.util.List;

public class Repository {
    private Context context;
    private MovieDAO movieDAO;
    private LiveData<List<Movie>> storedMovies;
    private RemoteSourceInterface remoteSource;
    MovieClient movieClient;

    public Repository(Context context){
        this.context = context;
        MovieDatabase movieDatabase = MovieDatabase.getInstance(context.getApplicationContext());
        movieDAO = movieDatabase.movieDAO();
        movieClient = new MovieClient();
        storedMovies = movieDAO.getAllMovies();
        remoteSource = new MovieClient();
    }

//    public void setNetworkDelegate(NetworkDelegate networkDelegate){
//        this.networkDelegate = networkDelegate;
//        movieClient = new MovieClient(context, networkDelegate);
//    }
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

    public LiveData<Movie> getMovie(String title){
        return movieDAO.getMovie(title);
    }

    public void getRemoteMovies(NetworkDelegate networkDelegate){
        remoteSource.enqueueCall(networkDelegate);
    }

}
