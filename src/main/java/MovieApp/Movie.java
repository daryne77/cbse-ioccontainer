package MovieApp;

public class Movie {
    private String name;
    private int year;
    private String type;

    public Movie(String name, int year, String type) {
        this.name = name;
        this.year = year;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", year=" + year +
                ", type='" + type + '\'' +
                '}';
    }
}
