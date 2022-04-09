package com.example.android.lab1.allMovies.view;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.android.lab1.R;
import com.example.android.lab1.allMovies.model.OnClickAddFavBtnListner;
import com.example.android.lab1.data.model.Movie;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    List<Movie> movies = null;
    MovieViewHolder movieViewHolder;
    Context context;
    OnClickAddFavBtnListner listner;

    public MovieAdapter(Context context, OnClickAddFavBtnListner listner) {
        this.context = context;
        this.listner = listner;
    }

    public void setMovies(List<Movie> movies){
        this.movies = movies;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflator = LayoutInflater.from(parent.getContext());
        View v = inflator.inflate(R.layout.movie_row, parent, false);
        MovieViewHolder vh = new MovieViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        //movieViewHolder = holder;
        if(movies != null){
            holder.titleTextView.setText(movies.get(position).getTitle());
            holder.releaseYearTextView.setText(String.valueOf(movies.get(position).getReleaseYear()));
            String url = movies.get(position).getUrlImage();
            Glide.with(context)
                    .load(url).
                    into(holder.imageView);
        }
        holder.addToFavouriteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listner.onAddBtnClicked(movies.get(position));
            }
        });

    }

    @Override
    public int getItemCount() {
        if(movies == null)
            return 0;
        return movies.size();
    }

    class MovieViewHolder extends RecyclerView.ViewHolder{
        TextView titleTextView;
        ImageView imageView;
        TextView releaseYearTextView;
        Button addToFavouriteBtn;
        View view;

        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
            titleTextView = view.findViewById(R.id.title);
            imageView = view.findViewById(R.id.imageView);
            releaseYearTextView = view.findViewById(R.id.releaseYear);
            addToFavouriteBtn = view.findViewById(R.id.removeBtn);
            addToFavouriteBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
        }

    }
}
