package movierental;

public class RegularMovieRental extends Rental {

    public RegularMovieRental(Movie movie, int numberOfDaysRented) {
        super(movie, numberOfDaysRented);
    }

    @Override
    public void accept(RentalVisitor rentalVisitor) {
        rentalVisitor.visit(this);
    }
}
