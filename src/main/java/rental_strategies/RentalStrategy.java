package rental_strategies;

import beans.Rental;

public abstract class RentalStrategy {

    public abstract int calculateFidelityPoints(Rental rental);

    public abstract double calculateRentalPrice(Rental rental);

}
