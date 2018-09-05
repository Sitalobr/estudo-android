package com.sitalobr.dev.recyclerview.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.sitalobr.dev.recyclerview.R;
import com.sitalobr.dev.recyclerview.adapter.MovieAdapter;
import com.sitalobr.dev.recyclerview.model.Movie;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerMovies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.recyclerMovies = findViewById(R.id.recyclerMovies);

        // Configure Adapter
        MovieAdapter movieAdapter = new MovieAdapter(this.getMovies());

        // Configure RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerMovies.setLayoutManager(layoutManager);
        recyclerMovies.setHasFixedSize(true);
        recyclerMovies.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerMovies.setAdapter(movieAdapter);
    }

    private List<Movie> getMovies() {
        List<Movie> movies = new ArrayList<>();

        movies.add(new Movie("Once Upon a Time in Hollywood", 2019, "Crime/Drama/Thriller"));
        movies.add(new Movie("Captain Marvel", 2019, "Action/Adventure/Sci-Fi"));
        movies.add(new Movie("The Avengers 4", 2019, "Action/Adventure/Fantasy"));
        movies.add(new Movie("It: Chapter Two", 2019, "Horror/Thriller"));
        movies.add(new Movie("X-Men: Dark Phoenix", 2019, "Action/Adventure/Sci-Fi"));
        movies.add(new Movie("The Irishman", 2019, "Biography/Crime/Drama"));
        movies.add(new Movie("Joker", 2019, "Crime"));
        movies.add(new Movie("John Wick 3: Parabellum", 2019, "Action/Crime/Thriller"));
        movies.add(new Movie("Untitled Terminator Reboot", 2019, "Action/Crime/Thriller"));
        movies.add(new Movie("Vidro", 2019, "Drama/Mistery/Sci-Fi"));

        return movies;
    }
}
