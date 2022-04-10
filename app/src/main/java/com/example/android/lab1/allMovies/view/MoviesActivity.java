package com.example.android.lab1.allMovies.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import com.example.android.lab1.R;
import com.example.android.lab1.allMovies.presenter.AllMoviesPresenter;
import com.example.android.lab1.allMovies.presenter.AllMoviesPresenterInterface;
import com.example.android.lab1.data.model.Movie;
import com.example.android.lab1.data.model.Repository;
import com.example.android.lab1.data.network.MovieClient;
import com.example.android.lab1.data.network.NetworkDelegate;

import java.util.List;

public class MoviesActivity extends AppCompatActivity implements MoviesActivityInterface, OnClickAddFavBtnListner {

    RecyclerView recyclerView;
    MovieAdapter movieAdapter;
    ProgressDialog progressDialog;
    AllMoviesPresenterInterface allMoviesPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);
        recyclerView = findViewById(R.id.recyclerView);

        linkRecyclerViewWithLayoutManagerAndAdapter();
        showProgressDialod();

        allMoviesPresenter = new AllMoviesPresenter(this, this);
        allMoviesPresenter.getAllMovies();


    }

    public void linkRecyclerViewWithLayoutManagerAndAdapter(){

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MoviesActivity.this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);

        recyclerView.setLayoutManager(linearLayoutManager);

        movieAdapter = new MovieAdapter(MoviesActivity.this, this);
        recyclerView.setAdapter(movieAdapter);
    }

    public void showProgressDialod(){
        progressDialog = new ProgressDialog(MoviesActivity.this);
        progressDialog.setCancelable(false); // set cancelable to false
        progressDialog.setMessage("Please Wait"); // set message
        progressDialog.show();
    }

    @Override
    public void showMovie(List<Movie> movies) {
        progressDialog.dismiss();
        movieAdapter.setMovies(movies);
        movieAdapter.notifyDataSetChanged();
    }

    @Override
    public void showError(String errorMsg) {
        progressDialog.dismiss();
        Toast.makeText(MoviesActivity.this, errorMsg, 1).show();
    }

    @Override
    public void onAddBtnClicked(Movie movie) {
        allMoviesPresenter.addMovie(movie, this);
        Toast.makeText(MoviesActivity.this, "Movie Added Successfully", 1).show();
    }

    @Override
    public void showIfInsertedSuccessfully(Boolean flag) {
        if(flag)
            Toast.makeText(MoviesActivity.this, "Movie Added Successfully", 1).show();
        else
            Toast.makeText(MoviesActivity.this, "Movie Already Exist", 1).show();
    }
}