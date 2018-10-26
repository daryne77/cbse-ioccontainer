public class MovieFinderFromFile implements IMovieFinder {

    private final String file;

    public MovieFinderFromFile(String file) {
        this.file = file;
    }

    @Override
    public void findById() {
        System.out.println("file  " + file);
    }
}
