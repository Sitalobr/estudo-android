package com.sitalobr.dev.recyclerview.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sitalobr.dev.recyclerview.R;
import com.sitalobr.dev.recyclerview.model.Movie;

import java.util.List;
import java.util.Locale;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieHolder> {

    private List<Movie> movies;

    public MovieAdapter(List<Movie> movies) {
        this.movies = movies;
    }

    @NonNull
    @Override
    public MovieHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View movieItem = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.movie_item, viewGroup, false);

        return new MovieHolder(movieItem);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieHolder movieHolder, int i) {
        Movie movie = this.movies.get(i);
        movieHolder.tvTitle.setText(movie.getTitle());
        movieHolder.tvYear.setText(String.format(Locale.getDefault(), "%1$d", movie.getYear()));
        movieHolder.tvGender.setText(movie.getGender());
    }

    @Override
    public int getItemCount() {
        return this.movies.size();
    }

    class MovieHolder extends RecyclerView.ViewHolder {

        TextView tvTitle, tvYear, tvGender;

        MovieHolder(@NonNull View itemView) {
            super(itemView);

            this.tvTitle = itemView.findViewById(R.id.tvTitle);
            this.tvYear = itemView.findViewById(R.id.tvYear);
            this.tvGender = itemView.findViewById(R.id.tvGender);
        }
    }

}
