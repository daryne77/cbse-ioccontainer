package MovieApp;

import IOCFramework.IOCContainer;
import IOCFramework.IOCContainerFactory;
import MovieApp.MovieLister.MovieLister;

public class MovieApp {
    public static void main(String [] args) {
        IOCContainer container = IOCContainerFactory.configureIOCContainer();

        MovieLister movieLister = (MovieLister) container.getInstance(MovieLister.class);
        if (movieLister != null) {
            movieLister.listMovies();
        } else {
            System.out.println("No registered implementation for movieLister");
        }
    }


}
