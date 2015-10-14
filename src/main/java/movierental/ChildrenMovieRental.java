package movierental;

public class ChildrenMovieRental extends Rental {

    public ChildrenMovieRental(Movie movie, int numberOfDaysRented) {
        super(movie, numberOfDaysRented);
    }

    @Override
    public void accept(RentalVisitor rentalVisitor) {
        rentalVisitor.visit(this);
    }
}