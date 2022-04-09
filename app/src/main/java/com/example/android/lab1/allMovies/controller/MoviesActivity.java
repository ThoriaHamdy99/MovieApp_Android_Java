package com.example.android.lab1.allMovies.controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import com.example.android.lab1.R;
import com.example.android.lab1.allMovies.model.OnClickAddFavBtnListner;
import com.example.android.lab1.allMovies.view.MovieAdapter;
import com.example.android.lab1.data.model.Movie;
import com.example.android.lab1.data.model.Repository;
import com.example.android.lab1.data.network.MovieClient;
import com.example.android.lab1.data.network.NetworkDelegate;
import com.example.android.lab1.favouriteMovies.model.OnClickRemoveFavBtnListner;

import java.util.List;

public class MoviesActivity extends AppCompatActivity implements NetworkDelegate, OnClickAddFavBtnListner {

    RecyclerView recyclerView;
    MovieAdapter movieAdapter;
    MovieClient movieClient;
    ProgressDialog progressDialog;
    Repository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);
        recyclerView = findViewById(R.id.recyclerView);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MoviesActivity.this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);

        recyclerView.setLayoutManager(linearLayoutManager);

        movieAdapter = new MovieAdapter(MoviesActivity.this, this);
        recyclerView.setAdapter(movieAdapter);

        progressDialog = new ProgressDialog(MoviesActivity.this);
        progressDialog.setCancelable(false); // set cancelable to false
        progressDialog.setMessage("Please Wait"); // set message
        progressDialog.show();

        movieClient = new MovieClient(MoviesActivity.this, this);
        repository = new Repository(MoviesActivity.this);

    }

    @Override
    public void onSuccessResult(List<Movie> movies) {
        progressDialog.dismiss();
        movieAdapter.setMovies(movies);
        movieAdapter.notifyDataSetChanged();

    }

    @Override
    public void onFailureResult(String errorMsg) {
        progressDialog.dismiss();
        Toast.makeText(MoviesActivity.this, "Network Error", 1).show();
    }

    @Override
    public void onAddBtnClicked(Movie movie) {
        repository.insert(movie);
        Toast.makeText(MoviesActivity.this, "Movie Added Successfully", 1).show();
    }
}