package com.example.android.lab1.data.network;

import com.example.android.lab1.data.model.Movie;

import java.util.List;

public interface NetworkDelegate {
    public void onSuccessResult(List<Movie> movies);
    public void onFailureResult(String errorMsg);

}
