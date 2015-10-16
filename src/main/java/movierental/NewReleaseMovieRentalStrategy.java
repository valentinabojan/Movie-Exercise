package movierental;

public class NewReleaseMovieRentalStrategy extends MovieRentalStrategy {
    private static final int FIDELITY_POINTS_FOR_NORMAL_RENTAL = 1;
    private static final int FIDELITY_POINTS_FOR_EXTENDED_RENTAL = 2;
    private static final double PRICE_PER_DAY_FOR_RENTAL = 3;
    private static final int NUMBER_OF_DAYS_FOR_NORMAL_RENTAL = 1;


    @Override
    public int calculateFidelityPoints(Rental rental) {
        if (rental.getDaysRented() > NUMBER_OF_DAYS_FOR_NORMAL_RENTAL)
            return FIDELITY_POINTS_FOR_EXTENDED_RENTAL;

        return FIDELITY_POINTS_FOR_NORMAL_RENTAL;
    }

    @Override
    public double calculateRentalPrice(Rental rental) {
        return rental.getDaysRented() * PRICE_PER_DAY_FOR_RENTAL;
    }

}
