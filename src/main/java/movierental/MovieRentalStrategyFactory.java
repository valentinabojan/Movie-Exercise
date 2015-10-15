package movierental;

public class MovieRentalStrategyFactory {

    public static MovieRentalStrategy createStrategy(MovieType movieType) {
        switch (movieType) {
            case NEW_RELEASE:
                return new NewReleaseMovieRentalStrategy();
            case CHILDREN:
                return new ChildrenMovieRentalStrategy();
            default:
                return new RegularMovieRentalStrategy();
        }
    }

}
