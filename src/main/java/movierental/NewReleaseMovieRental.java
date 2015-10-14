package movierental;

public class NewReleaseMovieRental extends Rental {

    private static final double PRICE_PER_DAY_FOR_LONG_RENTALS = 3;
    private static final double PRICE_FOR_REGULAR_RENTAL = 0;
    private static final int DAYS_FOR_REGULAR_RENTAL = 0;

    public NewReleaseMovieRental(Movie movie, int numberOfDaysRented) {
        super(movie, numberOfDaysRented);
    }

    @Override
    public void accept(RentalVisitor rentalVisitor) {
        rentalVisitor.visit(this);
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
}