package com.example.android.lab1.data.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.android.lab1.data.model.Movie;

import java.util.List;

@Dao
public interface MovieDAO {
    @Query("Select * From Movie")
    LiveData<List<Movie>> getAllMovies();

    @Insert
    void insertMovie(Movie movie);

    @Delete
    void deleteMovie(Movie movie);
}
