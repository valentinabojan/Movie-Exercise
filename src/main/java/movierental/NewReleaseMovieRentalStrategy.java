package movierental;

public class NewReleaseMovieRentalStrategy extends MovieRentalStrategy {

    @Override
    public int calculateFidelityPoints(Rental rental) {
        return 0;
    }

    @Override
    public double calculateRentalPrice(Rental rental) {
        return rental.getDaysRented() * 3;
    }
}
