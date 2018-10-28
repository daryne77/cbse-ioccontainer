package MovieApp.MovieFinder;

import MovieApp.Movie;

import java.util.ArrayList;
import java.util.Arrays;

public class MovieFinderFromFile implements IMovieFinder {

    private final String file;
    private final ArrayList<Movie> movies;

    public MovieFinderFromFile(String file) {
        this.file = file;
        this.movies = new ArrayList<>(Arrays.asList(
                new Movie("Fight Club (2nd impl - from file " + file + ")", 1999, "Drama"),
                new Movie("The Shining (2nd impl - from file " + file + ")", 1980, "Drama, Horror"),
                new Movie("Pulp Fiction (2nd impl - from file " + file + ")", 1994, "Crime, Drama")
        ));
    }

    @Override
    public ArrayList<Movie> getAll() {
        return this.movies;
    }
}
