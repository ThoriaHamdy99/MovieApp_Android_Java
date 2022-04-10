package com.example.android.lab1.data.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.android.lab1.data.model.Movie;

import java.util.List;

@Dao
public interface MovieDAO {
    @Query("Select * From Movie")
    LiveData<List<Movie>> getAllMovies();

    //SELECT * FROM user WHERE user_name LIKE :name
    @Query("Select * From Movie WHERE title LIKE :title")
    LiveData<Movie> getMovie(String title);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertMovie(Movie movie);

    @Delete
    void deleteMovie(Movie movie);
}
