package movierental;

public class Movie {

    private String title;
    private MovieType type;

    public Movie(String title, MovieType type) {
        this.title = title;
        this.type = type;
    }

    public MovieType getType() {
        return type;
    }

    public String getTitle() {
        return title;
    }

}