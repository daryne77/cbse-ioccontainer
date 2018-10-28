package MovieApp.MovieFinder;

import MovieApp.Movie;

import java.util.ArrayList;
import java.util.Arrays;

public class MovieFinder implements IMovieFinder {
    private final ArrayList<Movie> movies;

    public MovieFinder() {
        this.movies = new ArrayList<>(Arrays.asList(
                new Movie("Fight Club (1st Impl)", 1999, "Drama"),
                new Movie("The Shining (1st Impl)", 1980, "Drama, Horror"),
                new Movie("Pulp Fiction (1st Impl)", 1994, "Crime, Drama")
        ));
    }

    @Override
    public ArrayList<Movie> getAll() {
        return this.movies;
    }
}

