package movierental;

public class RegularMovieRental extends Rental {

    private static final double PRICE_PER_DAY_FOR_LONG_RENTALS = 1.5;
    private static final double PRICE_FOR_REGULAR_RENTAL = 2;
    private static final int DAYS_FOR_REGULAR_RENTAL = 2;

    public RegularMovieRental(Movie movie, int numberOfDaysRented) {
        super(movie, numberOfDaysRented);
    }

    @Override
    public int getDaysForRegularRental() {
        return DAYS_FOR_REGULAR_RENTAL;
    }

    @Override
    public double getPriceForRegularRental() {
        return PRICE_FOR_REGULAR_RENTAL;
    }

    @Override
    public double getPricePerDayForLongRental() {
        return PRICE_PER_DAY_FOR_LONG_RENTALS;
    }

    @Override
    public void accept(RentalVisitor rentalVisitor) {
        rentalVisitor.visit(this);
    }
}
