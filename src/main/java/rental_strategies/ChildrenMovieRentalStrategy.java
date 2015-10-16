package rental_strategies;

import beans.Rental;

public class ChildrenMovieRentalStrategy extends RentalStrategy {

    private static final int FIDELITY_POINTS_FOR_NORMAL_RENTAL = 1;
    private static final double PRICE_FOR_NORMAL_RENTAL = 1.5;
    private static final int NUMBER_OF_DAYS_FOR_NORMAL_RENTAL = 3;
    private static final double PRICE_PER_DAY_FOR_EXTENDED_RENTAL = 1.5;

    @Override
    public int calculateFidelityPoints(Rental rental) {
        return FIDELITY_POINTS_FOR_NORMAL_RENTAL;
    }

    @Override
    public double calculateRentalPrice(Rental rental) {
        double rentalPrice = PRICE_FOR_NORMAL_RENTAL;

        int extendedRentalDays = rental.getDaysRented() - NUMBER_OF_DAYS_FOR_NORMAL_RENTAL;
        if (extendedRentalDays > 0)
            rentalPrice += extendedRentalDays * PRICE_PER_DAY_FOR_EXTENDED_RENTAL;

        return rentalPrice;
    }

}
