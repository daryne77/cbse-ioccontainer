public class Main {
    public static void main(String [] args) {
        IOCContainer container = configureIOCContainer();

        IMovieFinder movieFinder = (IMovieFinder) container.getInstance(IMovieFinder.class);
        movieFinder.findById();

        MovieLister movieLister = (MovieLister) container.getInstance(MovieLister.class);
        movieLister.listMovies();
    }

    static IOCContainer configureIOCContainer() {
        IOCContainer container = new IOCContainer();
//        container.registerClass(IMovieFinder.class, MovieFinder.class);
        container.registerInstance(IMovieFinder.class, new MovieFinderFromFile("sfsdf"));
        container.registerClass(MovieLister.class, MovieLister.class);
        return container;
    }
}
