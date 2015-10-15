package movierental;

public class RegularMovieRentalStrategy extends MovieRentalStrategy {

    @Override
    public int calculateFidelityPoints(Rental rental) {
        return 0;
    }

    @Override
    public double calculateRentalPrice(Rental rental) {
        int thisAmount = 2;
        if (rental.getDaysRented() > 2)
            thisAmount += (rental.getDaysRented() - 2) * 1.5;

        return thisAmount;
    }
}
