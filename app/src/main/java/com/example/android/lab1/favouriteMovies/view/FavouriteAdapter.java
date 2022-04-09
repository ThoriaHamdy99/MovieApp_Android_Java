package com.example.android.lab1.favouriteMovies.view;

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
import com.example.android.lab1.data.model.Movie;
import com.example.android.lab1.favouriteMovies.model.OnClickRemoveFavBtnListner;

import java.util.List;

public class FavouriteAdapter extends RecyclerView.Adapter<FavouriteAdapter.FavouriteViewHolder> {
    List<Movie> movies = null;
    Context context;
    OnClickRemoveFavBtnListner listner;

    public FavouriteAdapter(Context context, OnClickRemoveFavBtnListner listner){
        this.context = context;
        this.listner = listner;
    }

    public void setMovies(List<Movie> movies){
        this.movies = movies;
    }

    @NonNull
    @Override
    public FavouriteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflator = LayoutInflater.from(parent.getContext());
        View v = inflator.inflate(R.layout.favourite_row, parent, false);
        FavouriteAdapter.FavouriteViewHolder vh = new FavouriteAdapter.FavouriteViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull FavouriteAdapter.FavouriteViewHolder holder, int position) {
        //movieViewHolder = holder;
        if(movies != null){
            holder.titleTextView.setText(movies.get(position).getTitle());
            holder.releaseYearTextView.setText(String.valueOf(movies.get(position).getReleaseYear()));
            String url = movies.get(position).getUrlImage();
            Glide.with(context)
                    .load(url).
                    into(holder.imageView);
        }
        holder.removeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listner.onRemoveBtnClicked(movies.get(position));
            }
        });

    }

    @Override
    public int getItemCount() {
        if(movies == null)
            return 0;
        return movies.size();
    }

    class FavouriteViewHolder extends RecyclerView.ViewHolder{
        TextView titleTextView;
        ImageView imageView;
        TextView releaseYearTextView;
        Button removeBtn;
        View view;

        public FavouriteViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
            titleTextView = view.findViewById(R.id.title);
            imageView = view.findViewById(R.id.imageView);
            releaseYearTextView = view.findViewById(R.id.releaseYear);
            removeBtn = view.findViewById(R.id.removeBtn);
        }

    }
}
