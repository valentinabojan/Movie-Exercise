package movierental;

public abstract class Rental implements Visitable {

    private Movie movie;
    private int numberOfDaysRented;

    public Rental(Movie movie, int numberOfDaysRented) {
        this.movie = movie;
        this.numberOfDaysRented = numberOfDaysRented;
    }

    public int getDaysRented() {
        return numberOfDaysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public abstract int getDaysForRegularRental();

    public abstract double getPriceForRegularRental();

    public abstract double getPricePerDayForLongRental();

}