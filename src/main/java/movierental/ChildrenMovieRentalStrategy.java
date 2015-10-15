package movierental;

public class ChildrenMovieRentalStrategy extends MovieRentalStrategy {

    @Override
    public int calculateFidelityPoints(Rental rental) {
        return 1;
    }

    @Override
    public double calculateRentalPrice(Rental rental) {
        double thisAmount = 1.5;
        if (rental.getDaysRented() > 3)
            thisAmount += (rental.getDaysRented() - 3) * 1.5;

        return thisAmount;
    }
}
