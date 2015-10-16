package movierental.rental_visitables;

import movierental.movie_rental_entities.Movie;
import movierental.movie_rental_entities.Rental;
import movierental.rental_visitors.RentalVisitor;

public class RegularMovieRental extends Rental {

    private static final double PRICE_PER_DAY_FOR_EXTENDED_RENTALS = 1.5;
    private static final double PRICE_FOR_NORMAL_RENTAL = 2;
    private static final int DAYS_FOR_NORMAL_RENTAL = 2;

    public RegularMovieRental(Movie movie, int numberOfDaysRented) {
        super(movie, numberOfDaysRented);
    }

    @Override
    public int getDaysForNormalRental() {
        return DAYS_FOR_NORMAL_RENTAL;
    }

    @Override
    public double getPriceForNormalRental() {
        return PRICE_FOR_NORMAL_RENTAL;
    }

    @Override
    public double getPricePerDayForExtendedRental() {
        return PRICE_PER_DAY_FOR_EXTENDED_RENTALS;
    }

    @Override
    public void accept(RentalVisitor rentalVisitor) {
        rentalVisitor.visit(this);
    }
}
