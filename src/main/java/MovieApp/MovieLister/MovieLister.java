package MovieApp.MovieLister;

import MovieApp.Movie;
import MovieApp.MovieFinder.IMovieFinder;

import java.util.ArrayList;

public class MovieLister {
    private final IMovieFinder movieFinder;

    public MovieLister(IMovieFinder movieFinder) {
        this.movieFinder = movieFinder;
    }

    public void listMovies() {
        ArrayList<Movie> movies = this.movieFinder.getAll();

        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }
}
