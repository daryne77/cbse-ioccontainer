public class MovieLister {
    private final IMovieFinder movieFinder;

    public MovieLister(IMovieFinder movieFinder) {
        this.movieFinder = movieFinder;
    }

    public void listMovies() {
        System.out.println("Listed movies");
    }
}
