package rental_strategies;

import beans.MovieType;

public class RentalStrategyFactory {

    public static RentalStrategy createStrategy(MovieType movieType) {
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
