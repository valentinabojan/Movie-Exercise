package movierental.movie_rental_entities;

import movierental.rental_visitables.RentalVisitable;

public abstract class Rental implements RentalVisitable {

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

    public abstract int getDaysForNormalRental();

    public abstract double getPriceForNormalRental();

    public abstract double getPricePerDayForExtendedRental();

}