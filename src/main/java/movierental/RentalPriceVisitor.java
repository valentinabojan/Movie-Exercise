package movierental;

public class RentalPriceVisitor implements RentalVisitor {

    private static final double REGULAR_MOVIE_PRICE_PER_DAY_FOR_LONG_RENTALS =1.5;
    private static final double REGULAR_MOVIE_PRICE_FOR_REGULAR_RENTAL = 2;
    private static final int REGULAR_MOVIE_DAYS_FOR_REGULAR_RENTAL = 2;

    private static final double NEW_RELEASE_MOVIE_PRICE_PER_DAY_FOR_LONG_RENTALS = 3;
    private static final double NEW_RELEASE_MOVIE_PRICE_FOR_REGULAR_RENTAL = 0;
    private static final int NEW_RELEASE_MOVIE_DAYS_FOR_REGULAR_RENTAL = 0;

    private static final double CHILDREN_MOVIE_PRICE_PER_DAY_FOR_LONG_RENTALS =1.5;
    private static final double CHILDREN_MOVIE_PRICE_FOR_REGULAR_RENTAL = 1.5;
    private static final int CHILDREN_MOVIE_DAYS_FOR_REGULAR_RENTAL = 3;

    private double rentalPrice;

    public double getRentalPrice() {
        return rentalPrice;
    }

    @Override
    public void visit(RegularMovieRental rental) {
        rentalPrice = REGULAR_MOVIE_PRICE_FOR_REGULAR_RENTAL;

        int longRentalDays = rental.getDaysRented() - REGULAR_MOVIE_DAYS_FOR_REGULAR_RENTAL;
        if (longRentalDays > 0)
            rentalPrice += longRentalDays * REGULAR_MOVIE_PRICE_PER_DAY_FOR_LONG_RENTALS;
    }

    @Override
    public void visit(NewReleaseMovieRental rental) {
        rentalPrice = NEW_RELEASE_MOVIE_PRICE_FOR_REGULAR_RENTAL;

        int longRentalDays = rental.getDaysRented() - NEW_RELEASE_MOVIE_DAYS_FOR_REGULAR_RENTAL;
        if (longRentalDays > 0)
            rentalPrice += longRentalDays * NEW_RELEASE_MOVIE_PRICE_PER_DAY_FOR_LONG_RENTALS;
    }

    @Override
    public void visit(ChildrenMovieRental rental) {
        rentalPrice = CHILDREN_MOVIE_PRICE_FOR_REGULAR_RENTAL;

        int longRentalDays = rental.getDaysRented() - CHILDREN_MOVIE_DAYS_FOR_REGULAR_RENTAL;
        if (longRentalDays > 0)
            rentalPrice += longRentalDays * CHILDREN_MOVIE_PRICE_PER_DAY_FOR_LONG_RENTALS;
    }
}
