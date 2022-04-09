package com.example.android.lab1.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.android.lab1.R;
import com.example.android.lab1.allMovies.controller.MoviesActivity;
import com.example.android.lab1.favouriteMovies.controller.FavouriteActivity;

public class MainActivity extends AppCompatActivity {

    Button getAllMoviesBtn;
    Button getFavouriteMoviesBtn;
    Button exiteBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getAllMoviesBtn = findViewById(R.id.getAllMoviesBtn);
        getFavouriteMoviesBtn = findViewById(R.id.getFavouriteMoviesBtn);
        exiteBtn = findViewById(R.id.exiteBtn);

        getAllMoviesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, MoviesActivity.class));
            }
        });
        getFavouriteMoviesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, FavouriteActivity.class));
            }
        });
        exiteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}