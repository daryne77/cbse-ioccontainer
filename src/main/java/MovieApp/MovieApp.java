package MovieApp;

import IOCFramework.IOCContainer;
import IOCFramework.IOCContainerFactory;
import MovieApp.MovieLister.MovieLister;

import java.util.HashMap;

public class MovieApp {
    public static void main(String [] args) {
        IOCContainer container = IOCContainerFactory.configureIOCContainer();

        MovieLister movieLister = (MovieLister) container.getInstance(MovieLister.class);
        if (movieLister != null) {
            System.out.println("Listed movies:");
            movieLister.listMovies();
        } else {
            System.out.println("No registered implementation for movieLister");
        }

        System.out.println("Registered classes: ");
        HashMap registeredClasses = container.getRegisteredClasses();
        registeredClasses.forEach((key, value) -> System.out.println(key + " -> " + value));

        System.out.println("Registered params: ");
        HashMap params = container.getRegisteredParams();
        params.forEach((key, value) -> {
            System.out.println("Class " + key + ":");
            for (Object param : (Object[])value) {
                System.out.println(param);
            }
        });
    }


}
