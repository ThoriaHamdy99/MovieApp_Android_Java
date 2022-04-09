package com.example.android.lab1.favouriteMovies.controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.android.lab1.R;
import com.example.android.lab1.allMovies.controller.MoviesActivity;
import com.example.android.lab1.controller.MainActivity;
import com.example.android.lab1.data.model.Movie;
import com.example.android.lab1.data.model.Repository;
import com.example.android.lab1.favouriteMovies.model.OnClickRemoveFavBtnListner;
import com.example.android.lab1.favouriteMovies.view.FavouriteAdapter;

import java.util.List;

public class FavouriteActivity extends AppCompatActivity implements OnClickRemoveFavBtnListner {

    RecyclerView recyclerView;
    FavouriteAdapter favouriteAdapter;
    Repository repository;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourite);

        recyclerView = findViewById(R.id.favouriteRecyclerView);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(FavouriteActivity.this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);

        recyclerView.setLayoutManager(linearLayoutManager);
        favouriteAdapter = new FavouriteAdapter(FavouriteActivity.this, this);

        recyclerView.setAdapter(favouriteAdapter);
        repository = new Repository(FavouriteActivity.this);

        repository.getStoredMovies().observe(this, new Observer<List<Movie>>() {
            @Override
            public void onChanged(List<Movie> movies) {
                favouriteAdapter.setMovies(movies);
                favouriteAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void onRemoveBtnClicked(Movie movie) {
        repository.delete(movie);
        favouriteAdapter.notifyDataSetChanged();
        Toast.makeText(FavouriteActivity.this, "Movie Deleted Successfully!", 1).show();
    }
}