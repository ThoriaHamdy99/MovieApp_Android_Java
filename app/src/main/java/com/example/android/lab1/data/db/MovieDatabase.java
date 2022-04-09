package com.example.android.lab1.data.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.android.lab1.data.model.Movie;

@Database(entities = {Movie.class}, version = 1)
public abstract class MovieDatabase extends RoomDatabase {
    private static MovieDatabase movieDatabase = null;
    public abstract MovieDAO movieDAO();

    public static synchronized MovieDatabase getInstance(Context context){
        if(movieDatabase == null){
            movieDatabase = Room.databaseBuilder(context.getApplicationContext(), MovieDatabase.class, "Movie").build();
        }
        return movieDatabase;
    }

}
