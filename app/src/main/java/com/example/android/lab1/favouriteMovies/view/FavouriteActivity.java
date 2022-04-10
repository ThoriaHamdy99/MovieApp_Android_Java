package com.example.android.lab1.favouriteMovies.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.android.lab1.R;
import com.example.android.lab1.data.model.Movie;
import com.example.android.lab1.data.model.Repository;
import com.example.android.lab1.favouriteMovies.presenter.FavouritePresenter;
import com.example.android.lab1.favouriteMovies.presenter.FavouritePresenterInterface;

import java.util.List;

public class FavouriteActivity extends AppCompatActivity implements FavouriteActivityInterface, OnClickRemoveFavBtnListner {

    RecyclerView recyclerView;
    FavouriteAdapter favouriteAdapter;
    FavouritePresenterInterface favouritePresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourite);

        recyclerView = findViewById(R.id.favouriteRecyclerView);
        linkRecyclerViewWithLayoutManagerAndAdapter();
        favouritePresenter = new FavouritePresenter(this, this);
        favouritePresenter.getAllMovies(this);
    }

    public void linkRecyclerViewWithLayoutManagerAndAdapter(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(FavouriteActivity.this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);

        recyclerView.setLayoutManager(linearLayoutManager);
        favouriteAdapter = new FavouriteAdapter(FavouriteActivity.this, this);

        recyclerView.setAdapter(favouriteAdapter);
    }
    @Override
    public void onRemoveBtnClicked(Movie movie) {
        favouritePresenter.removeMovie(movie);
        favouriteAdapter.notifyDataSetChanged();
        Toast.makeText(FavouriteActivity.this, "Movie Deleted Successfully!", 1).show();
    }

    @Override
    public void showMovie(List<Movie> movies) {
        favouriteAdapter.setMovies(movies);
        favouriteAdapter.notifyDataSetChanged();
    }
}