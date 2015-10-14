package movierental;

public class NewReleaseMovieRental extends Rental {

    public NewReleaseMovieRental(Movie movie, int numberOfDaysRented) {
        super(movie, numberOfDaysRented);
    }

    @Override
    public void accept(RentalVisitor rentalVisitor) {
        rentalVisitor.visit(this);
    }
}