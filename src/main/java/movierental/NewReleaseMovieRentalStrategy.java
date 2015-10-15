package movierental;

public class NewReleaseMovieRentalStrategy extends MovieRentalStrategy {

    @Override
    public int calculateFidelityPoints(Rental rental) {
        if (rental.getDaysRented() > 1)
            return 2;
        else
            return 1;
    }

    @Override
    public double calculateRentalPrice(Rental rental) {
        return rental.getDaysRented() * 3;
    }
}
