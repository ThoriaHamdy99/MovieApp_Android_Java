package com.example.android.lab1.data.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Movie")
public class Movie {
    @PrimaryKey
    @NonNull
    public String title;
    public int releaseYear;
    public Float rating;
    public String image;

    public Movie() {
    }

    public Movie(String title, int releaseYear, Float rating, String image) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.rating = rating;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public String getUrlImage() {
        return image;
    }

    public void setUrlImage(String image) {
        this.image = image;
    }
}
