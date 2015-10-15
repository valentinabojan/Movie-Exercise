package movierental;

public abstract class MovieRentalStrategy {

    public abstract int calculateFidelityPoints(Rental rental);

    public abstract double calculateRentalPrice(Rental rental);

}
